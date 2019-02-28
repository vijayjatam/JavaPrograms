package com.kali.shopping.test;




// AddItem.java




import java.awt.event.ActionEvent;
import java.util.HashMap;

import java.util.Map;


import javax.swing.JOptionPane;
public class AddItem extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final String VEG = "Veg";
	
   private javax.swing.JButton addButton;
   private javax.swing.JTextField itemNameTextField;
   private javax.swing.JComboBox<String> itmeSelectionCombo;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JTextField qtyTextField;
   private javax.swing.JButton resetButton;
   private static javax.swing.JLabel loggedInUserLabel;
   
	private javax.swing.JButton logoutButton;
	
	 private String loggedInUser=null;
	/** Creates new form AddItem */
   public AddItem() 
   {
       initComponents();
   }
   public static  Map<String, Map<String, Double>> itemsMap =null;
   

	public  void setItemsMap(Map<String, Map<String, Double>> itemsMap) 
	{
		AddItem.itemsMap = itemsMap;
		
	}

	public void addItem(Map<String, Map<String, Double>> itemMap, String text1, String qty,String menuType) throws NumberFormatException {
      
		if(null==itemMap.get(menuType))
       {
           Map<String,Double> element=new HashMap<String,Double>();
           element.put(text1, Double.valueOf(qty));
           itemMap.put(menuType, element);
       }
       else
       {
           Map<String, Double> addedMap = itemMap.get(menuType);
           if(null==addedMap.get(text1))
           {
           	addedMap.put(text1, Double.valueOf(qty));
           }
           else
           {
               addedMap.put(text1, Double.valueOf(qty)+addedMap.get(text1));
           }
       }
   }

   
   private void initComponents() {

       jPanel2 = new javax.swing.JPanel();
       jPanel1 = new javax.swing.JPanel();
       jLabel2 = new javax.swing.JLabel();
       itemNameTextField = new javax.swing.JTextField();
       jLabel3 = new javax.swing.JLabel();
       qtyTextField = new javax.swing.JTextField();
       addButton = new javax.swing.JButton();
       resetButton = new javax.swing.JButton();
       jLabel1 = new javax.swing.JLabel();
       itmeSelectionCombo = new javax.swing.JComboBox<String>();
       loggedInUserLabel = new javax.swing.JLabel();
       logoutButton = new javax.swing.JButton();

       setBorder(javax.swing.BorderFactory.createTitledBorder("Add Items")); // NOI18N

       jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(itmeSelectionCombo.getName()));

       jLabel2.setText("Item Name:");

       jLabel3.setText("No.of Items(Kgs/Ltrs):");

       addButton.setText("Add");
       addButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               addButtonActionPerformed(evt);
           }
       });

       resetButton.setText("Reset");
       resetButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               resetButtonActionPerformed(evt);
           }
       });
       jLabel1.setText("Choose an  Item  from the List ");

       itmeSelectionCombo.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Vegetables", "Fruits", "Dairy Items", "Others"}));

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(4, 4, 4))
                           .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                       .addGap(69, 69, 69)
                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                           .addGroup(jPanel1Layout.createSequentialGroup()
                               .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(itmeSelectionCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(itemNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                           .addComponent(qtyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                       .addGap(68, 68, 68))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                       .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                       .addGap(171, 171, 171))))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(itmeSelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(19, 19, 19)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel2)
                   .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(28, 28, 28)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(resetButton)
                   .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addContainerGap(25, Short.MAX_VALUE))
       );

       loggedInUserLabel.setText("Logged In User:");

       logoutButton.setText("Logout");
       logoutButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               logoutButtonActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
       jPanel2.setLayout(jPanel2Layout);
       jPanel2Layout.setHorizontalGroup(
           jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel2Layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                       .addGap(8, 8, 8)
                       .addComponent(loggedInUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(logoutButton))
                   .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addContainerGap(24, Short.MAX_VALUE))
       );
       jPanel2Layout.setVerticalGroup(
           jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel2Layout.createSequentialGroup()
               .addGap(19, 19, 19)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(loggedInUserLabel)
                   .addComponent(logoutButton))
               .addGap(27, 27, 27)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(57, Short.MAX_VALUE))
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(24, 24, 24)
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(19, 19, 19)
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(46, Short.MAX_VALUE))
       );
   }

protected void resetButtonActionPerformed(ActionEvent evt) 
{
	itmeSelectionCombo.setSelectedIndex(0);
   itemNameTextField.setText("");
   qtyTextField.setText("");
}

protected void logoutButtonActionPerformed(ActionEvent evt) 
{
	ShoppingCart.showUserDeatilsPanel();
}

private void addButtonActionPerformed(ActionEvent evt)
{

   int selectedIndex = itmeSelectionCombo.getSelectedIndex();
   String itemName = itemNameTextField.getText().trim();
   String qty=qtyTextField.getText().trim();
   if(itemName.equals("") ||qty.equals("") )
   {
   	JOptionPane.showMessageDialog(null, "Item name and No. of items values should not be empty.", "STOP", 2);
		itemNameTextField.setText("");
       qtyTextField.setText("");
   	return;
   }
   try
	{
		Double.valueOf(qty);
	}
	catch (NumberFormatException e)
	{
		JOptionPane.showMessageDialog(null, "No. of items value should be a Numeric(in Kgs/Ltrs).", "Error", 2);
		qtyTextField.setText("");
		return;
	}
   if(selectedIndex ==0)
   {
       addItem(itemsMap, itemName, qty,VEG); 
   }
   else if(selectedIndex ==1)
   {
   	 addItem(itemsMap, itemName, qty,"Fruits"); 
   }
   else if(selectedIndex==2)
   {
   	addItem(itemsMap, itemName, qty,"DryItems"); 
   }
   else if(selectedIndex==3)
   {
   	addItem(itemsMap, itemName, qty,"Others"); 
   }
   JOptionPane.showMessageDialog(null, "Item is successfully added to the list.", "Successfully", 1);

   itemNameTextField.setText("");
   qtyTextField.setText("");
}
	public void setLoggedInUserLabel(String loggedInUser) 
	{
		loggedInUserLabel.setForeground(new java.awt.Color(255,0,0));
		loggedInUserLabel.setText("Logged In User : "+loggedInUser);
		this.loggedInUser = loggedInUser;
	}

	public boolean updatePanel()
	{
		if(loggedInUser==null || loggedInUser.equals(""))
	    {
		  return false;
	    }
		itmeSelectionCombo.setSelectedIndex(0);
		itemNameTextField.setText("");
		qtyTextField.setText("");
		return true;
	}
}

