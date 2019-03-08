package com.kali.kali.shopping.test;

import com.kali.shopping.test.ShoppingCart;

import java.awt.CardLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class UserDetailsForm extends JPanel implements
		ActionListener {
	private static final long serialVersionUID = 1L;
	private Map<String, Map<String, Map<String, Double>>> userBasedItemsMap;
	
	private Map<String, String> loggedInUserMap;
	/** Creates new form UserDetailsForm */
	public UserDetailsForm() {
		initComponents();
	}

	public UserDetailsForm(
			Map<String, Map<String, Map<String, Double>>> userBasedItemsMap, Map<String, String> loggedInUser) {
		this.userBasedItemsMap = userBasedItemsMap;
		loggedInUserMap=loggedInUser;
		initComponents();
	}
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new JPanel();
		
		jLabel1 = new javax.swing.JLabel();
		loggedinUserText = new javax.swing.JTextField();
		loggedInUserButton = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		registrationText = new javax.swing.JTextField();
		registrationButton = new javax.swing.JButton();

		jLabel1.setText("Customer Name");
		
		 setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Login"));

		loggedInUserButton.setText("Login");
		loggedInUserButton.addActionListener(this);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(1, 1,255));
		jLabel2.setText("New Customer?");

		jLabel3.setText("Customer Name");

		registrationButton.setText("Save");
		registrationButton.addActionListener(this);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								108,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								100,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				28,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(21,
																												21,
																												21)
																										.addComponent(
																												registrationText,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												170,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												55,
																												Short.MAX_VALUE)
																										.addComponent(
																												registrationButton,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												77,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(19,
																												19,
																												19)
																										.addComponent(
																												loggedinUserText,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												172,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												51,
																												Short.MAX_VALUE)
																										.addComponent(
																												loggedInUserButton,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												81,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(52,
																				52,
																				52))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				501,
																				Short.MAX_VALUE)
																		.addContainerGap()))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																loggedinUserText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																loggedInUserButton))
										.addGap(40, 40, 40)
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																registrationButton)
														.addComponent(
																registrationText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(142, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(120, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(30, 30, 30)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(194, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private JPanel jPanel1;
	private javax.swing.JButton loggedInUserButton;
	private javax.swing.JTextField loggedinUserText;
	private javax.swing.JButton registrationButton;
	private javax.swing.JTextField registrationText;
	private CardLayout cardLayout;
	private JPanel rightPanel;

	// End of variables declaration//GEN-END:variables

	public void setCardLayout(JPanel rightPanel, CardLayout cardlayout) {
		this.cardLayout = cardlayout;
		this.rightPanel = rightPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == registrationButton) 
		{
			loggedinUserText.setText("");
			String customerName = registrationText.getText().trim();
			if(!("".equals(customerName)) )
			{
				String customer_Name = customerName.toLowerCase();
				if(null !=userBasedItemsMap.get(customer_Name))
				{
					 JOptionPane.showMessageDialog(null, customerName +" already exists.please enter valid customer name", "STOP", 2);
					 registrationText.setText("");
					 return;
				}
				Map<String, Map<String, Double>> itemsMap = new HashMap<String, Map<String, Double>>(
						20);
				userBasedItemsMap.put(customer_Name, itemsMap);
				JOptionPane.showMessageDialog(null, customerName +" is registered successfully.", "Successefully", 1);
				registrationText.setText("");
			}
			else
			{
				 JOptionPane.showMessageDialog(null, "Customer name should not be Empty.", "Error", 2);
				 registrationText.setText("");
			}
			
		}
		else if(e.getSource() == loggedInUserButton) 
		{
			registrationText.setText("");
			String loggedInUserText = loggedinUserText.getText().trim();
			if("".equals(loggedInUserText))
			{
				JOptionPane.showMessageDialog(null, "Customer name should not be Empty.", "Error", 2);
				loggedinUserText.setText("");
				return;
			}
			String customer_Name = loggedInUserText.toLowerCase();
			
			Map<String, Map<String, Double>> itemsMap = userBasedItemsMap.get(customer_Name);
			if(null ==itemsMap)
			{
				JOptionPane.showMessageDialog(null, loggedInUserText +" is not a registered customer.", "STOP", 2);
				loggedinUserText.setText("");
				 return;
			}
			loggedinUserText.setText("");
			loggedInUserMap.put("loggedInUser", customer_Name);
			ShoppingCart.updateAddItem();
			cardLayout.show(rightPanel, "AddItems");
			
			
		}
		
	}
}

