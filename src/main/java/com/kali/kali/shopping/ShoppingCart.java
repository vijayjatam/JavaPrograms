package com.kali.kali.shopping;

import com.kali.shopping.AddItem;
import com.kali.shopping.ConsumeItems;
import com.kali.shopping.StockItems;
import com.kali.shopping.UserDetailsForm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

public class ShoppingCart extends javax.swing.JFrame {

	private static final String OTHERS = "Others";

	private static final String DRY_ITEMS = "DryItems";

	private static final String FRUITS = "Fruits";

	private static final String VEG = "Veg";

	private static final String VEG_Indicator = "Veg::";

	private static final String User_Seperator = "=:";

	private static final String ELEMENTS_TXT = "src/main/java/com/kali/shopping/elements.txt";

	private static final long serialVersionUID = 1L;

	private static final String FRUITS_Indicator = "Fruits::";

	private static final String DRYITEMS_Indicator = "DryItems::";

	private static final String OTHERS_Indicator = "Others::";

	private JSplitPane splitPane = null;

	private JPanel leftPanel;
	private static JPanel rightPanel;

	private static CardLayout cardlayout;

	private UserDetailsForm userDetailsForm;
	
	private com.kali.shopping.ConsumeItems consuptionItemPanel;
	
	
	private static Map<String, String> loggedInUserMap=new HashMap<String, String>(1);
	

	/** Creates new form MainFrame */
	public ShoppingCart() {

		userBasedItemsMap = readFromFile();
		addItemPanel = new com.kali.shopping.AddItem();
		userDetailsForm = new UserDetailsForm(userBasedItemsMap,loggedInUserMap);
		stockItemPanel = new com.kali.shopping.StockItems(userBasedItemsMap,loggedInUserMap);
		consuptionItemPanel=new ConsumeItems();
		initComponents();
		userDetailsForm.setCardLayout(rightPanel, cardlayout);
	}
	private void initComponents() {

		setTitle("MAHANKALI Application");
		setBackground(Color.gray);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Main Menu"));
		getContentPane().add(topPanel);

		splitPane = new JSplitPane();
		splitPane.setDividerLocation(150);
		splitPane.setMinimumSize(new java.awt.Dimension(200, 25));

		createLeftPanel();

		rightPanel = new JPanel();
		cardlayout = new CardLayout();
		rightPanel.setLayout(cardlayout);

		rightPanel.add(userDetailsForm, "UserDeatils");
		rightPanel.add(addItemPanel, "AddItems");
		rightPanel.add(stockItemPanel, "StockItems");
		rightPanel.add(consuptionItemPanel, "ConsumeItems");

		splitPane.setLeftComponent(leftPanel);
		splitPane.setRightComponent(rightPanel);

		topPanel.add(splitPane);

		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// what happens when user closes the JFrame.
		WindowAdapter windowListener = new WindowAdapter() {
			// anonymous WindowAdapter class
			public void windowClosing(WindowEvent w) {

				WriteItemsToFile();
				// Whatever code you want to actually close the JFrame, e.g.
				ShoppingCart.this.setVisible(false);
				ShoppingCart.this.dispose();
			} // end windowClosing

		};// end anonymous class
		this.addWindowListener(windowListener);

	}

	private void WriteItemsToFile()
	{
		StringBuilder text = new StringBuilder();
		File f = new File(ELEMENTS_TXT);
		
		Set<Entry<String, Map<String, Map<String, Double>>>> userVsItems = userBasedItemsMap.entrySet();
		for (Entry<String, Map<String, Map<String, Double>>> userVsItem : userVsItems) 
		{
			String customerName = userVsItem.getKey();
			Map<String, Map<String, Double>> itemsMap = userVsItem.getValue();
			
			text.append(customerName);
			text.append(User_Seperator);
			
			Map<String, Double> vegItems =itemsMap.get(VEG);
			Map<String, Double> fruitItems =itemsMap.get(FRUITS);
			Map<String, Double> dryItems =itemsMap.get(DRY_ITEMS);
			Map<String, Double> otherItems =itemsMap.get(OTHERS);
			
			appendItem(text, vegItems,VEG_Indicator);
			appendItem(text, fruitItems,FRUITS_Indicator);
			appendItem(text, dryItems,DRYITEMS_Indicator);
			appendItem(text, otherItems,OTHERS_Indicator);
			
			text.append("\n");
		}
		try
		{
			FileWriter fw = new FileWriter(f);
			fw.write(text.toString());
			fw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	private void appendItem(StringBuilder text, Map<String, Double> vegItems, String itemIndicator) {
		if (null != vegItems)
		{
			text.append(itemIndicator);
			Set<Entry<String, Double>> items = vegItems.entrySet();
			final Iterator<Entry<String, Double>> iterator = items
					.iterator();

			for (Iterator<Entry<String, Double>> it = iterator; it.hasNext();) 
			{
				Entry<String, Double> entry = it.next();
				text.append(entry.getKey());
				text.append('^');
				text.append(entry.getValue());
				text.append(';');
			}
			text.append("#");
		 }
	}

	private void createLeftPanel() 
	{
		leftPanel = new JPanel();
		addItemsButton = new JButton("Add Items");
		addItemsButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		stockItemsButton = new JButton("Stock Items");
		stockItemsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stockItemsButtonActionPerformed(evt);
			}

		});

		conItemsButton = new JButton("Consume Items");
		conItemsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				consumeItemsButtonActionPerformed(evt);
			}

		});
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				leftPanel);
		leftPanel.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																addItemsButton,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																107,
																Short.MAX_VALUE)
														.addComponent(
																stockItemsButton,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																conItemsButton,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																107,
																Short.MAX_VALUE))
										.addGap(10, 10, 10)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addGap(59, 59, 59)
						.addComponent(addItemsButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 51,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)
						.addComponent(stockItemsButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 56,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(47, 47, 47)
						.addComponent(conItemsButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 53,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(287, Short.MAX_VALUE)));

	}

	public void jButton1ActionPerformed(ActionEvent e) {

		if (e.getSource() == addItemsButton) 
		{
		/*	String loggedInUser = loggedInUserMap.get("loggedInUser");
			if(null==loggedInUser)
			{
				cardlayout.show(rightPanel, "UserDeatils");
			}
			else
			{
				updateAddItem();
				cardlayout.show(rightPanel, "AddItems");
			}*/
			String loggedInUser = loggedInUserMap.get("loggedInUser");
			addItemPanel.setLoggedInUserLabel(loggedInUser);
			addItemPanel.setItemsMap(userBasedItemsMap.get(loggedInUser));
			boolean isUserLogged = addItemPanel.updatePanel();
			if(false==isUserLogged)
			{
				JOptionPane.showMessageDialog(null, "You have not Login.", "STOP", 2);
				return;
			}
			cardlayout.show(rightPanel, "AddItems");
		}
	}

	private void stockItemsButtonActionPerformed(ActionEvent e) 
	{
		if (e.getSource() == stockItemsButton) 
		{
			String loggedInUser = loggedInUserMap.get("loggedInUser");
			stockItemPanel.setLoggedInUser(loggedInUser);
			stockItemPanel.setItemsMap(userBasedItemsMap.get(loggedInUser));
			boolean isUserLogged = stockItemPanel.updateTable();
			if(false==isUserLogged)
			{
				JOptionPane.showMessageDialog(null, "You have not Login.", "STOP", 2);
				return;
			}
			cardlayout.show(rightPanel, "StockItems");
		}

	}
	private void consumeItemsButtonActionPerformed(ActionEvent e) 
	{
		if (e.getSource() == conItemsButton) 
		{
			String loggedInUser = loggedInUserMap.get("loggedInUser");
			consuptionItemPanel.setLoggedInUser(loggedInUser);
			consuptionItemPanel.setItemsMap(userBasedItemsMap.get(loggedInUser));
			boolean isUserLogged = consuptionItemPanel.updatePanel();
			if(false==isUserLogged)
			{
				JOptionPane.showMessageDialog(null, "Your have not Login.", "STOP", 2);
				return;
			}
			cardlayout.show(rightPanel, "ConsumeItems");
		}

	}
	public static void main(String args[]) {

		ShoppingCart mainFrame1 = new ShoppingCart();
		mainFrame1.pack();
		mainFrame1.setSize(800, 550);
		mainFrame1.setLocationRelativeTo(null);
		mainFrame1.setResizable(false);
		mainFrame1.setVisible(true);

	}

	private Map<String, Map<String, Map<String, Double>>> readFromFile() {

		Map<String, Map<String, Map<String, Double>>> userBasedItems = new HashMap<String, Map<String, Map<String, Double>>>(
				20);
		File inFile = new File(ELEMENTS_TXT);
		if (!inFile.exists())
		{
			return userBasedItems;
		}
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
					inFile)));
			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				Map<String, Map<String, Double>> itemsMap = new HashMap<String, Map<String, Double>>(
						20);
				String customer=inputLine.substring(0, inputLine.indexOf(User_Seperator));
				inputLine=inputLine.substring(inputLine.indexOf(User_Seperator)+2);
				
				addItems(inputLine, itemsMap);
				
				userBasedItems.put(customer.toLowerCase(), itemsMap);
			 }
		} 
		catch (Exception ex)
		{
			ex.getStackTrace();
		}

		
		return userBasedItems;
	}

	private void addItems(String inputLine,
			Map<String, Map<String, Double>> itemsMap)
	{
		int veg_index = inputLine.indexOf(VEG_Indicator);
		if(-1 != veg_index)
		{
			String vegData = inputLine.substring(veg_index + 5,inputLine.indexOf("#"));
			addItems(itemsMap, vegData,VEG);
		}
		
		int fruitsIndex = inputLine.indexOf(FRUITS_Indicator);
		if(-1 != fruitsIndex)
		{
			String fruitsData = inputLine.substring(fruitsIndex + 8,inputLine.indexOf("#",fruitsIndex));
			addItems(itemsMap, fruitsData, FRUITS);
		}
		
		int dryItems_index = inputLine.indexOf(DRYITEMS_Indicator);
		if(-1 != dryItems_index)
		{
			String dryItemsData = inputLine.substring(dryItems_index + 10,inputLine.indexOf("#",dryItems_index));
			addItems(itemsMap, dryItemsData, DRY_ITEMS);
		}
		
		int Others_index = inputLine.indexOf(OTHERS_Indicator);
		if(-1 != dryItems_index)
		{
			String otherData = inputLine.substring(Others_index + 8,inputLine.indexOf("#",Others_index));
			addItems(itemsMap, otherData, OTHERS);
		}
		
	}

	private void addItems(Map<String, Map<String, Double>> itemsMap,String vegData,String itemType) 
	{
		Map<String, Double> individualItemsMap = new HashMap<String, Double>();
		String[] vegItems = vegData.split(";");
		for (int i = 0; i < vegItems.length; i++) 
		{
			String itemName = vegItems[i].substring(0,vegItems[i].indexOf("^"));
			String qty = vegItems[i].substring(vegItems[i].indexOf("^") + 1);
			final Double qtyVal = Double.valueOf(qty);
			final Double value = individualItemsMap.get(itemName);
			if (null == value)
			{
				individualItemsMap.put(itemName, qtyVal);
			} 
			else 
			{
				individualItemsMap.put(itemName, value + qtyVal);
			}
		}
		itemsMap.put(itemType, individualItemsMap);
	}
	public static void updateAddItem()
	{
		String loggedInUser = loggedInUserMap.get("loggedInUser");
		if(null != loggedInUser)
		{
			addItemPanel.setItemsMap(userBasedItemsMap.get(loggedInUser));
			addItemPanel.setLoggedInUserLabel(loggedInUser);
			addItemPanel.updatePanel();
		}
	}
	public static void showUserDeatilsPanel()
	{
		loggedInUserMap.remove("loggedInUser");
		cardlayout.show(rightPanel, "UserDeatils");
	}
	static Map<String, Map<String, Map<String, Double>>> userBasedItemsMap = null;

	private JButton addItemsButton;

	private JButton stockItemsButton;

	private JButton conItemsButton;

	private static AddItem addItemPanel;

	private static StockItems stockItemPanel;

}

