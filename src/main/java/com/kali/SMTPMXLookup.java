package com.kali;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class SMTPMXLookup {

	private static int hear(BufferedReader in) throws IOException {
		String line = null;
		int res = 0;
		while ((line = in.readLine()) != null) {
			String pfx = line.substring(0, 3);
			try {
				res = Integer.parseInt(pfx);
			} catch (Exception ex) {
				res = -1;
			}
			if (line.charAt(3) != '-')
				break;
		}
		return res;
	}

	private static void say(BufferedWriter wr, String text) throws IOException {
		wr.write(text + "\r\n");
		wr.flush();
		return;
	}

	private static ArrayList getMX(String hostName) throws NamingException {
		// Perform a DNS lookup for MX records in the domain
		Hashtable env = new Hashtable();
		env.put("java.naming.factory.initial",
				"com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext(env);
		Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });
		Attribute attr = attrs.get("MX");
		// if we don't have an MX record, try the machine itself
		if ((attr == null) || (attr.size() == 0)) {
			attrs = ictx.getAttributes(hostName, new String[] { "A" });
			attr = attrs.get("A");
			if (attr == null)
				throw new NamingException("No match for name '" + hostName
						+ "'");
		}
		ArrayList resultList = new ArrayList();
		NamingEnumeration enumeration = attr.getAll();
		while (enumeration.hasMore()) {
			String mailhost;
			String x = (String) enumeration.next();
			String f[] = x.split(" ");
			// THE fix *************
			if (f.length == 1)
				mailhost = f[0];
			else if (f[1].endsWith("."))
				mailhost = f[1].substring(0, (f[1].length() - 1));
			else
				mailhost = f[1];
			resultList.add(mailhost);
		}
		return resultList;
	}

	public static boolean isAddressValid(String address) {
		int pos = address.indexOf('@');
		if (pos == -1)
			return false;
		String domain = address.substring(++pos);
		ArrayList mxList = null;
		try {
			mxList = getMX(domain);
		} catch (NamingException ex) {
			return false;
		}
		if (mxList.size() == 0)
			return false;
		for (int mx = 0; mx < mxList.size(); mx++) {
			boolean valid = false;
			try {
				int res;
				Socket skt = new Socket((String) mxList.get(mx), 25);
				BufferedReader rdr = new BufferedReader(new InputStreamReader(
						skt.getInputStream()));
				BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(
						skt.getOutputStream()));
				res = hear(rdr);
				if (res != 220)
					throw new Exception("Invalid header");
				say(wtr, "EHLO rgagnon.com");
				res = hear(rdr);
				if (res != 250)
					throw new Exception("Not ESMTP");
				// validate the sender address
				say(wtr, "MAIL FROM: <tim@orbaker.com>");
				res = hear(rdr);
				if (res != 250)
					throw new Exception("Sender rejected");
				say(wtr, "RCPT TO: <" + address + ">");
				res = hear(rdr);
				say(wtr, "RSET");
				hear(rdr);
				say(wtr, "QUIT");
				hear(rdr);
				if (res != 250)
					throw new Exception(address + "  Address is not valid!");
				valid = true;
				rdr.close();
				wtr.close();
				skt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (valid) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		boolean status = isAddressValid("palavellik.22@gmail.com");
		if(status)
			System.out.println("Valid email id");
		else
			System.out.println("Invalid email id");
	}
}