package com.kali.kali.shopping.test;

import com.kali.shopping.test.ShoppingCart;

import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class StockItems extends javax.swing.JPanel {

	private static final String DRY_ITEMS = "DryItems";

	private static final String OTHERS = "Others";

	private static final String FRUITS = "Fruits";

	private static final String VEG = "Veg";

	private static final long serialVersionUID = 1L;

	private Map<String, Map<String, Double>> itemsMap;
    
    public void setItemsMap(Map<String, Map<String, Double>> itemsMap) {
		this.itemsMap = itemsMap;
	}

	private String loggedInUser=null;

	

	
    public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}


	public StockItems	(
			Map<String, Map<String, Map<String, Double>>> userBasedItemsMap,
			Map<String, String> loggedInUserMap) {
    	initComponents();
	}


	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPanel = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("Logged User:"+loggedInUser);
        menuItemsCombobox = new javax.swing.JComboBox();
        logoutButton = new javax.swing.JButton();
        loggedInUserLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Items"));

        DefaultTableModel defaultTableModel = new DefaultTableModel(
            new Object [][] {      
            },
            new String [] { "Item Name", "Stock(kg/ltr)"  }
        ) 
        {
            Class[] types = new Class [] {
                String.class, Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
		itemsTable.setModel(defaultTableModel);
		
        jScrollPanel.setViewportView(itemsTable);

        jLabel1.setText("Choose  menu item to view stock");

        menuItemsCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vegetables", FRUITS, "Dairy Items", OTHERS }));
        menuItemsCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemsComboboxActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        //loggedInUserLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        //loggedInUserLabel.setForeground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(menuItemsCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(loggedInUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(logoutButton)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loggedInUserLabel)
                    .addComponent(logoutButton))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuItemsCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Choose menu item to view stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// initComponents

private void menuItemsComboboxActionPerformed(java.awt.event.ActionEvent evt) 
{
	int selectedIndex = menuItemsCombobox.getSelectedIndex();
	DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
	removeTableElements(model);
	if(selectedIndex==0)
	{
		showTable(model,itemsMap.get(VEG));
	}
	else if(selectedIndex==1)
	{
		showTable(model,itemsMap.get(FRUITS));
	}
	else if(selectedIndex==2)
	{
		showTable(model,itemsMap.get(DRY_ITEMS));
	}
	else if(selectedIndex==3)
	{
		showTable(model,itemsMap.get(OTHERS));
	}
	sortAllRowsBy(model, 0, true);
}


private void showTable(DefaultTableModel model,Map<String, Double> vegItemsMap)
{
	if(null !=vegItemsMap)
	{
		Set<Entry<String, Double>> entrySet = vegItemsMap.entrySet();
		for (Entry<String, Double> entry : entrySet) 
		{
			String key = entry.getKey();
			Double value = entry.getValue();
			model.addRow(new Object[]{key,value});
		}
	}
	else
	{
		model.addRow(new Object[]{null,null});
		model.addRow(new Object[]{null,null});
		model.addRow(new Object[]{null,null});
		model.addRow(new Object[]{null,null});
		model.addRow(new Object[]{null,null});
	}
}


private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) 
{
	ShoppingCart.showUserDeatilsPanel();
	
}


    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JLabel loggedInUserLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JComboBox menuItemsCombobox;
    // End of variables declaration//GEN-END:variables

	public boolean updateTable()
	{
		if(loggedInUser==null || loggedInUser.equals(""))
		{
			return false;
		}
		loggedInUserLabel.setForeground(new java.awt.Color(255,0,0));
		loggedInUserLabel.setText("Logged in User : "+loggedInUser);
		DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
		//removeTableElements(model);
		menuItemsCombobox.setSelectedIndex(0);
		//showTable( model,itemsMap.get(VEG));
		//sortAllRowsBy(model, 0, true);
		return true;
	}


	private void removeTableElements(DefaultTableModel model) {
		int rowCount = model.getRowCount();
		while(rowCount!=0)
		{
			model.removeRow(0);
			rowCount=model.getRowCount();
		}
	}
	public void sortAllRowsBy(DefaultTableModel model, int colIndex, boolean ascending) 
	{
	    Vector data = model.getDataVector();
	    Collections.sort(data, new ColumnSorter(colIndex, ascending));
	    
	    model.fireTableStructureChanged();
	    Enumeration<TableColumn> columns = itemsTable.getColumnModel().getColumns();
	    while( columns.hasMoreElements())
	    {
	    	TableColumn col = columns.nextElement();
	    	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();    
	        dtcr.setHorizontalAlignment(SwingConstants.CENTER);  
	        col.setCellRenderer(dtcr);
	    }
       
	}
	class ColumnSorter implements Comparator {
	    int colIndex;
	    boolean ascending;
	    ColumnSorter(int colIndex, boolean ascending) {
	        this.colIndex = colIndex;
	        this.ascending = ascending;
	    }
	    public int compare(Object a, Object b) {
	        Vector v1 = (Vector)a;
	        Vector v2 = (Vector)b;
	        Object o1 = v1.get(colIndex);
	        Object o2 = v2.get(colIndex);

	        // Treat empty strains like nulls
	        if (o1 instanceof String && ((String)o1).length() == 0) {
	            o1 = null;
	        }
	        if (o2 instanceof String && ((String)o2).length() == 0) {
	            o2 = null;
	        }

	        // Sort nulls so they appear last, regardless
	        // of sort order
	        if (o1 == null && o2 == null) {
	            return 0;
	        } else if (o1 == null) {
	            return 1;
	        } else if (o2 == null) {
	            return -1;
	        } else if (o1 instanceof Comparable) {
	            if (ascending) {
	                return ((Comparable)o1).compareTo(o2);
	            } else {
	                return ((Comparable)o2).compareTo(o1);
	            }
	        } else {
	            if (ascending) {
	                return o1.toString().compareTo(o2.toString());
	            } else {
	                return o2.toString().compareTo(o1.toString());
	            }
	        }
	    }
	}
	
	
}

