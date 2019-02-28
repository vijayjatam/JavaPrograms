package com.kali.game.one;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author mahan.k.palavelli
 *
 */
public class WelcomePage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5506314437088003780L;
	JLabel welcomeLabel, levelLabel, versionLabel;
	JButton nextButton;
	@SuppressWarnings("rawtypes")
	JComboBox level;
	static String userName = null;
	MindGame mindGameObj = new MindGame();
	static UtilClass util = new UtilClass();
	static Map<String, String> KEY_VALUE = new ConcurrentHashMap<String, String>();
	static int USER_STATUS = 1;

	/**
	 * Constructor create GUI :)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WelcomePage() {
		welcomeLabel = new JLabel("   Welcome to MIND GAME " + userName);
		// Update the user Name
		mindGameObj.updateDetails(userName, KEY_VALUE);

		levelLabel = new JLabel(" Select level: ");
		changeLabelFontSize();

		welcomeLabel.setForeground(Color.red);
		nextButton = new JButton("Next >");
		level = new JComboBox();
		level.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Level 1", "Level 2", "Level 3", "Level 4", "Level 5",
				"Level 6" }));
		add(welcomeLabel);
		add(levelLabel);
		add(level);
		add(nextButton);
		nextButton.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				/*
				 * String selectedLevel = (String) level.getSelectedItem();
				 * System.out.println(level.getSelectedIndex()); if
				 * (selectedLevel.equalsIgnoreCase("Low"))
				 * mindGameObj.newMindGame(1, 0, 10); else if
				 * (selectedLevel.equalsIgnoreCase("Medium"))
				 * mindGameObj.newMindGame(2, 0, 18); else
				 * mindGameObj.newMindGame(3, 0, 25);
				 */

				switch (level.getSelectedIndex()) {
				case 0:
					mindGameObj.newMindGame(1, 0, 50);
					break;
				case 1:
					mindGameObj.newMindGame(2, 0, 40);
					break;
				case 2:
					mindGameObj.newMindGame(3, 0, 35);
					break;
				case 3:
					mindGameObj.newMindGame(4, 0, 30);
					break;
				case 4:
					mindGameObj.newMindGame(5, 0, 25);
					break;
				case 5:
					mindGameObj.newMindGame(6, 0, 20);
					break;
				}
			}
		});
		setResizable(false);
		setSize(200, 150);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Main
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		subMain();
	}

	private static void subMain() throws IOException {
		// userName = JOptionPane.showInputDialog("Enter Name: ");
		// System.out.println(userName);
		InetAddress inet = InetAddress.getLocalHost();
		NetworkInterface network = NetworkInterface.getByInetAddress(inet);
		byte[] mac = network.getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "." : ""));		
		}
		sb.append("."+inet.getHostAddress());
		System.out.println(sb.toString());
		System.out.println("IP of my system is := " + inet.getHostAddress());
		File file = new File("src/main/java/com/kali/game/one/filename.txt");
		boolean status = getData(file, inet.getHostAddress().toString());

		if (status) {
			while (USER_STATUS == 1)
				validateUserName();
		} else{
			JOptionPane.showMessageDialog(null, "Enough plays completed for '"
					+ inet.getHostAddress().toString() + "'", "STOP", 0);
			/*String adminName = JOptionPane.showInputDialog(null,"If your Mahan you can play....!");
			if(adminName!=null&&!adminName.equalsIgnoreCase("")&&adminName.equalsIgnoreCase("G=6.67")){
				new WelcomePage();
			}else{*/
			String adminName = null;
			adminName = JOptionPane.showInputDialog("But Mahan you can play....!");
				/*for (int tries=1;tries<=3;tries++){
					switch (tries){
						case 1: adminName = JOptionPane.showInputDialog("If your Mahan you can play....!");break;
						case 2: adminName = JOptionPane.showInputDialog(null,"*****Prove your Mahan****"); break;
						case 3: adminName = JOptionPane.showInputDialog(null,"I don't trust you"); break;
						//case 4: adminName = JOptionPane.showInputDialog(null,"Last time stranger...!"); break;
					}
					if(adminName!=null&&!adminName.equalsIgnoreCase("")&&adminName.equalsIgnoreCase("G=6.67")){
						break;
					}
				}*/
				if(adminName!=null&&!adminName.equalsIgnoreCase("")&&adminName.equalsIgnoreCase("G=6.67")){
					userName = adminName;
					new WelcomePage();
				}else {
					JOptionPane.showMessageDialog(null, "Your not Mahan..!", "STOP", 0);
				}

			/*}*/
		}
	}

	public static void validateUserName() {
		try {
			USER_STATUS = 1;
			userName = JOptionPane.showInputDialog(null, "Name :").trim();
			Pattern pattern = Pattern.compile("[^a-z]",Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(userName);
			if (matcher.find()) {
				JOptionPane.showMessageDialog(null,
						"Numbers or Special Charactors not allowed", "STOP", 0);
				USER_STATUS = 1;
				return;
			}
			if (userName.length() < 3 || userName.length() > 25) {
				JOptionPane.showMessageDialog(null,
						"Name should be 3 to 25 charactors only", "STOP", 0);
				USER_STATUS = 1;
				return;
			}
			if (userName != null && !userName.trim().equalsIgnoreCase("")) {
				userName = userName.trim().toUpperCase();

				KEY_VALUE = UtilClass.getExistedDataFromFile(new File("src/main/java/com/kali/game/one/score.txt"));
				boolean userStatus = UtilClass.findValueInFile(KEY_VALUE, userName);
				if (userStatus) {
					USER_STATUS = JOptionPane.showConfirmDialog(null, userName
							+ " is already existed, update score?");
					if (USER_STATUS == 0) {
						USER_STATUS = 0;
						new WelcomePage();

					} else if (USER_STATUS == 2) {
						JOptionPane.showMessageDialog(null, "Game closed by "
								+ userName, "STOP", 0);
						System.exit(0);
					}
				} else {
					USER_STATUS = 0;
					new WelcomePage();
				}
			} else if (userName == null || userName.trim().equalsIgnoreCase("")) {
				// Nothing to do
				JOptionPane.showMessageDialog(null, "Name Mandatory", "Error",
						0);
				System.exit(0);
			}
		} catch (Exception e) {
			if(JOptionPane.showConfirmDialog(null,"Do you wish to close the game?") == 0) {
				USER_STATUS = 0;
				JOptionPane.showMessageDialog(null, "Game closed by User", "STOP", 0);
				System.exit(0);
			}
			else 
				USER_STATUS = 1;
		}

	}

	/**
	 * Writing data to file (if file not exist create)
	 * 
	 * @param file
	 * @param ipAddress
	 * @return
	 * @throws IOException
	 */
	private static boolean getData(File file, String ipAddress)
			throws IOException {
		boolean status = true;
		StringBuilder data = new StringBuilder();
		Map<String, String> ipAddressVsPlayTimes = new ConcurrentHashMap<String, String>();
		// call addData for Reading already existed data.
		ipAddressVsPlayTimes = util.getExistedDataFromFile(file);

		if (null != ipAddressVsPlayTimes && ipAddressVsPlayTimes.size() > 0) {
			if (ipAddressVsPlayTimes.containsKey(ipAddress)) {
				// Here Compare IpAddress vs Play Times(How many times this IP played).
				if (Integer.parseInt(ipAddressVsPlayTimes.get(ipAddress)) >= 5)
					return false;
				ipAddressVsPlayTimes = util.updateOldInfoWithNewInfo(
						ipAddressVsPlayTimes, ipAddress); // processing(ipAddressVsPlayTimes,ipAddress);
			} else {
				data.append(ipAddress.toString() + "=:" + "1\n");
			}
			util.mapToStringBuilder(ipAddressVsPlayTimes, data);
		}
		// if file doesnt exists, then create it
		else if (!file.exists()) {
			file.createNewFile();
			data.append(ipAddress.toString() + "=:" + "1");
		} else
			data.append(ipAddress.toString() + "=:" + "1");

		FileWriter fw = new FileWriter(file);
		fw.write(data.toString());
		fw.close();
		return status;
	}

	private JLabel changeLabelFontSize() {
		versionLabel = new JLabel(
				"� 2017 MindGame All Rights Reserved. MindGame Highly Confidential.");
		Font labelFont = versionLabel.getFont();
		String labelText = versionLabel.getText();

		int stringWidth = versionLabel.getFontMetrics(labelFont).stringWidth(
				labelText);
		int componentWidth = versionLabel.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double) componentWidth / (double) stringWidth;

		int newFontSize = (int) (labelFont.getSize() * widthRatio);
		int componentHeight = versionLabel.getHeight();

		// Pick a new font size so it will not be larger than the height of
		// label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		versionLabel.setFont(new Font(labelFont.getName(), Font.PLAIN,
				fontSizeToUse));
		add(versionLabel);
		return versionLabel;
	}
}
