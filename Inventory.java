package Inventory;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultTreeModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;


public class Inventory {

	private JFrame frmAsianPaints,frameA;
	public JTable table,rectable,rectable1,purcdetail;
	private JFrame f1;
	//private JTable table;
	private JPanel contentPane;
	public JTextField textField,textField_1,textField_2,textField_3;
	 private static final AtomicInteger counter = new AtomicInteger();
	 
	JScrollPane scrollPane;
	int age,age1,prod=0,prod1;
	private JFrame frmStockOrder;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table1;
	private JTable Stable;
	private static JTextField textFieldQ;
	private static JTextField textFieldT;
	private static JTextField textFieldU;
	

	/**

	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory();
					window.frmAsianPaints.setVisible(true);
					
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inventory() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsianPaints = new JFrame("Inventory Control");
		frmAsianPaints.setTitle("Chinna Enterprise");
		frmAsianPaints.setBounds(100, 100, 450, 300);
		frmAsianPaints.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		final JSplitPane splitPane = new JSplitPane();
		frmAsianPaints.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JTree tree = new JTree();
		tree.setFont(new Font("Dialog", Font.PLAIN, 11));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Inventory Control") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Items");
						node_1.add(new DefaultMutableTreeNode("Add New Item"));
						//node_1.add(new DefaultMutableTreeNode("Update"));
						node_1.add(new DefaultMutableTreeNode("Delete"));
						node_1.add(new DefaultMutableTreeNode("Find Item"));
						//node_1.add(new DefaultMutableTreeNode("Transfer Stock"));
						//node_1.add(new DefaultMutableTreeNode("Import Items from Csv"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Purchase");
						node_1.add(new DefaultMutableTreeNode("Order Stock"));
						node_1.add(new DefaultMutableTreeNode("Receive Stock"));
						node_1.add(new DefaultMutableTreeNode("View Orders"));
						//node_1.add(new DefaultMutableTreeNode("View Receive History"));
						//node_1.add(new DefaultMutableTreeNode("View Items On Order"));
						//node_1.add(new DefaultMutableTreeNode("Order Low Stock Items"));
						//node_1.add(new DefaultMutableTreeNode("Return Stock"));
					add(node_1);
					//node_1 = new DefaultMutableTreeNode("Sell");
					//	node_1.add(new DefaultMutableTreeNode("Sell Stock"));
					//	node_1.add(new DefaultMutableTreeNode("View Sales History"));
					//add(node_1);
					//node_1 = new DefaultMutableTreeNode("Reports");
					//	node_1.add(new DefaultMutableTreeNode("Inventory"));
					//	node_1.add(new DefaultMutableTreeNode("Inventory by Location and Category"));
					//	node_1.add(new DefaultMutableTreeNode("Inventory with Image by Category"));
					//	node_1.add(new DefaultMutableTreeNode("Low Level Stock"));
					//	node_1.add(new DefaultMutableTreeNode("Inventory by Default Supplier"));
					//	node_1.add(new DefaultMutableTreeNode("BackOrder Report"));
					//	node_1.add(new DefaultMutableTreeNode("Sales Report"));
					//add(node_1);
				}
			}
		));
		for (int i = 0; i < tree.getRowCount(); i++) {
	         tree.expandRow(i);
	}
		splitPane.setLeftComponent(tree);
		Dimension minimumSize = new Dimension(150, 75);
		tree.setMinimumSize(new Dimension(150, 100));
		splitPane.setMinimumSize(minimumSize);
		  scrollPane = new JScrollPane();
			splitPane.setRightComponent(scrollPane);
			
			
			
		    table = new JTable();
			   Object[] columns = {"Item","Description","Category","Tax", "Cost", "Price", "Location", "Quantity"};
		        final DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(columns);
		     // set the model to the table
		        table.setModel(model);
		       
		        // Change A JTable Background Color, Font Size, Font Color, Row Height
		        table.setBackground(Color.LIGHT_GRAY);
		        table.setForeground(Color.black);
		        Font font = new Font("",1,22);
		        table.setFont(font);
		        table.setRowHeight(30);
		 /*       table.addMouseListener( { e->
		        if (e.isPopupTrigger()){
		           int row = table.rowAtPoint( e.getPoint() );
		           jtable.changeSelection( row, 0, false, false );
		           swing.popupMenu(menuItems).show(e.getComponent(), e.getX(), e.getY());
		       }
		       } as java.awt.event.MouseListener)*/
		        
		        final Object[] row = new Object[8];  
		       try{ 
		        BufferedReader br = new BufferedReader(new FileReader("itemslist.csv"));
        	    String line = null;
        	    int index=0;
        	    
        	    while ((line = br.readLine()) != null) {
        	    	// if(index == 0) {
                    //     index++;
                    //     continue; //skip first line
                    //  }
        	      String[] values = line.split(",");
        	      int i=0;
        	    
        	    //for ( String str : values) {
        	    	 
        	    	             	    	                 	    	 
        	       row[i] = values;
        	       Object[]  row1 = (Object[])  row[i];
        	    	// str= myVec.add(str);
        	       
        	          model.addRow(row1);
        	             
        	    	 
        	    		//  System.out.println(row1);
        	  //  }
        	      i++; 
        	    }
        	    br.close();
        	  
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
		        
		        
		        final JPopupMenu popupMenu = new JPopupMenu();
		        final JMenuItem updatedeleteItem = new JMenuItem("Update");
		        updatedeleteItem.addActionListener(new ActionListener() {
		        	

		            @Override
		            public void actionPerformed(ActionEvent e) {
		               // JOptionPane.showMessageDialog(frame, "Right-click performed on table and choose DELETE");
		            	 // create JFrame and JTable
		    	        final JFrame upframe = new JFrame();
		    	        
		    	        // create a table model and set a Column Identifiers to this model 
		    	     
		    	        Font font1 = new Font("",1,22);	   
		    	        
		    	              
		    	        
		    	       
		    	        
		    	        
		    	        // create JTextFields
		    	        final JTextField textId1 = new JTextField();
		    	        textId1.setToolTipText("Enter Item");
		    	        textId1.setBounds(100, 15, 100, 25);
		    	        final JTextField textFname = new JTextField();
		    	        textFname.setToolTipText("Enter Description");
		    	        final JTextField textLname = new JTextField();
		    	        textLname.setToolTipText("Enter Tax");
		    	        final JTextField textAge = new JTextField();
		    	        textAge.setToolTipText("Enter Category");
		    	        
		    	        
		    	        textField = new JTextField();
		    	        textField.setToolTipText("Enter Cost");
		    	        textField.setBounds(371, 15, 100, 25);
		    	        upframe.getContentPane().add(textField);
		    	        textField.setColumns(10);
		    	        
		    	        textField_1 = new JTextField();
		    	        textField_1.setToolTipText("Enter Price");
		    	        textField_1.setBounds(371, 68, 100, 25);
		    	        upframe.getContentPane().add(textField_1);
		    	        textField_1.setColumns(10);
		    	        
		    	        textField_2 = new JTextField();
		    	        textField_2.setToolTipText("Enter Location");
		    	        textField_2.setBounds(371, 126, 100, 25);
		    	        upframe.getContentPane().add(textField_2);
		    	        textField_2.setColumns(10);
		    	        
		    	        textField_3 = new JTextField();
		    	        textField_3.setToolTipText("Enter Quantity");
		    	        textField_3.setBounds(371, 191, 100, 25);
		    	        upframe.getContentPane().add(textField_3);
		    	        textField_3.setColumns(10);
		    	        
		    	        // create JButtons
		    	        //JButton btnAdd = new JButton("Add");
		    	        JButton btnDelete = new JButton("Delete");
		    	        JButton btnUpdate = new JButton("Update");
		    	        JButton btnCancel = new JButton("Cancel");
		    	      
		    	        
		    	        textId1.setBounds(117, 12, 100, 25);
		    	        textFname.setBounds(117, 65, 100, 25);
		    	        textLname.setBounds(117, 123, 100, 25);
		    	        textAge.setBounds(117, 188, 100, 25);
		    	        
		    	       // btnAdd.setBounds(150, 265, 100, 25);
		    	        btnUpdate.setBounds(140, 265, 100, 25);
		    	      //  btnDelete.setBounds(260, 265, 100, 25);
		    	       btnCancel.setBounds(260, 265, 100, 25);
		    	        
		    	        upframe.getContentPane().setLayout(null);
		    	        
		    	        // add JTextFields to the jframe
		    	        upframe.getContentPane().add(textId1);
		    	        upframe.getContentPane().add(textFname);
		    	        upframe.getContentPane().add(textLname);
		    	        upframe.getContentPane().add(textAge);
		    	    
		    	        // add JButtons to the jframe
		    	      //  frame.getContentPane().add(btnAdd);
		    	        //upframe.getContentPane().add(btnDelete);
		    	        upframe.getContentPane().add(btnUpdate);
		    	  //      frame.getContentPane().add(btnCancel);
		    	        
		    	        JLabel lblNewLabel = new JLabel("Item");
		    	        lblNewLabel.setBounds(24, 17, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel);
		    	        
		    	        JLabel lblNewLabel_1 = new JLabel("Description");
		    	        lblNewLabel_1.setBounds(24, 70, 100, 15);
		    	        upframe.getContentPane().add(lblNewLabel_1);
		    	        
		    	        JLabel lblNewLabel_2 = new JLabel("Tax");
		    	        lblNewLabel_2.setBounds(24, 128, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel_2);
		    	        
		    	        JLabel lblNewLabel_3 = new JLabel("Category");
		    	        lblNewLabel_3.setBounds(24, 193, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel_3);
		    	        
		    	        JLabel lblNewLabel_4 = new JLabel("Cost");
		    	        lblNewLabel_4.setBounds(253, 17, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel_4);
		    	        
		    	        JLabel lblNewLabel_5 = new JLabel("Price");
		    	        lblNewLabel_5.setBounds(253, 70, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel_5);
		    	        
		    	        JLabel lblNewLabel_6 = new JLabel("Location");
		    	        lblNewLabel_6.setBounds(253, 128, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel_6);
		    	        
		    	        JLabel lblNewLabel_7 = new JLabel("Quantity");
		    	        lblNewLabel_7.setBounds(253, 193, 70, 15);
		    	        upframe.getContentPane().add(lblNewLabel_7);
		    	   
		    	        
		    	        
		    	        
		    	    
		    	        
		    	        
		    	        
		    	        // create an array of objects to set the row data
		    	        final Object[] row = new Object[8];
		    	        
		    	   
		    	        
		    	        
		    	        
		    	        // button remove row
		    	        btnDelete.addActionListener(new ActionListener(){

		    	            @Override
		    	            public void actionPerformed(ActionEvent e) {
		    	            
		    	                // i = the index of the selected row
		    	                int i = table.getSelectedRow();
		    	                if(i >= 0){
		    	                    // remove a row from jtable
		    	                    model.removeRow(i);

	    	                    	BufferedWriter writer = null;
	    	                    	 OutputStreamWriter output;
	    	                    	 FileOutputStream filestream;
	    	                    	 BufferedReader br = null;
	    	                    	 
	    	                    	
	    	                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    	                int nRow = dtm.getRowCount();
	    	                int nCol = dtm.getColumnCount();
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	FileWriter fw = new FileWriter("itemslist.csv", false);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writer = new BufferedWriter(fw);
	    	              	//   String line;
	    	              //	  int index=0;
	    	              	    
	    	              	//  while ((line = br.readLine()) == null) {
	    	              	    	
	    	              //             if(line==null){
	    	                	

	    	                    //write the header information
	    	                   StringBuffer bufferHeader = new StringBuffer();
	    	                 
	    	                   for (int j =0; j < nCol; j++) {
	    	                      bufferHeader.append(dtm.getColumnName(j));
	    	                        if (j!=nCol) bufferHeader.append(", ");
	    	                    }
	    	                    //writer.write(bufferHeader.toString() + "\r\n");

	    	                   //write row information
	    	                    for (int i1 = 0 ; i1 < nRow ; i1++){
	    	                         StringBuffer buffer = new StringBuffer();
	    	                        for (int j = 0 ; j < nCol ; j++){
	    	                           buffer.append(dtm.getValueAt(i1,j));
	    	                           if (j!=nCol) buffer.append(", ");
	    	                        }
	    	                        writer.write(buffer.toString() + "\r");
	    	                    }JOptionPane.showMessageDialog(null,	" item deleted " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e3) {
	    	        			// TODO Auto-generated catch block
	    	        			e3.printStackTrace();
	    	        		} catch (FileNotFoundException e1) {
	    	        			// TODO Auto-generated catch block
	    	        			e1.printStackTrace();
	    	        		} catch (IOException e2) {
	    	        			// TODO Auto-generated catch block
	    	        			e2.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writer.flush();
	    	        				writer.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}
	    	                }
		    	                }
		    	                else{
		    	                    JOptionPane.showInputDialog(null, "please select item to delete");
		    	                }
		    	               // frame.dispose();
		    	            }
		    	        });
		    	        
		    	        // get selected row data From table to textfields 
		    	        table.addMouseListener(new MouseAdapter(){
		    	        @Override
		    	        public void mouseEntered(MouseEvent e){
		    	            
		    	            // i = the index of the selected row
		    	            int i = table.getSelectedRow();
		    	            //table.changeSelection(i, i, false, false);
		    	            String x= model.getValueAt(i, 0).toString();
		                       System.out.println("x is "+x);
		    	            textId1.setText(model.getValueAt(i, 0).toString());
		    	            textFname.setText(model.getValueAt(i, 1).toString());
		    	            textLname.setText(model.getValueAt(i, 2).toString());
		    	            textAge.setText(model.getValueAt(i, 3).toString());
		    	            textField.setText(model.getValueAt(i, 4).toString());
		    	            textField_1.setText(model.getValueAt(i, 5).toString());
		    	            textField_2.setText(model.getValueAt(i, 6).toString());
		    	            textField_3.setText(model.getValueAt(i, 7).toString());
		    	        }
		    	        });
		    	        
		    	        
		    	        // button update row
		    	        btnUpdate.addActionListener(new ActionListener(){

		    	            @Override
		    	            public void actionPerformed(ActionEvent e) {
		    	             
		    	                // i = the index of the selected row
		    	                int i = table.getSelectedRow();
		    	                
		    	                if(i >= 0) 
		    	                {
		    	                   model.setValueAt(textId1.getText(), i, 0);
		    	                   model.setValueAt(textFname.getText(), i, 1);
		    	                   model.setValueAt(textLname.getText(), i, 2);
		    	                   model.setValueAt(textAge.getText(), i, 3);
		    	                   model.setValueAt(textField.getText(), i, 4);
		    	                   model.setValueAt(textField_1.getText(), i, 5);
		    	                   model.setValueAt(textField_2.getText(), i, 6);
		    	                   model.setValueAt(textField_3.getText(), i, 7);
		    	                   
		    	               	
	    	                    	BufferedWriter writer = null;
	    	                    	 OutputStreamWriter output;
	    	                    	 FileOutputStream filestream;
	    	                    	 BufferedReader br = null;
	    	                    	 
	    	                    	
	    	                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    	                int nRow = dtm.getRowCount();
	    	                int nCol = dtm.getColumnCount();
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	FileWriter fw = new FileWriter("itemslist.csv", false);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writer = new BufferedWriter(fw);
	    	              	//   String line;
	    	              //	  int index=0;
	    	              	    
	    	              	//  while ((line = br.readLine()) == null) {
	    	              	    	
	    	              //             if(line==null){
	    	                	

	    	                    //write the header information
	    	                   StringBuffer bufferHeader = new StringBuffer();
	    	                 
	    	                   for (int j =0; j < nCol; j++) {
	    	                      bufferHeader.append(dtm.getColumnName(j));
	    	                        if (j!=nCol) bufferHeader.append(", ");
	    	                    }
	    	                    //writer.write(bufferHeader.toString() + "\r\n");

	    	                   //write row information
	    	                    for (int i1 = 0 ; i1 < nRow ; i1++){
	    	                         StringBuffer buffer = new StringBuffer();
	    	                        for (int j = 0 ; j < nCol ; j++){
	    	                           buffer.append(dtm.getValueAt(i1,j));
	    	                           if (j!=nCol) buffer.append(", ");
	    	                        }
	    	                        writer.write(buffer.toString() + "\r");
	    	                    }JOptionPane.showMessageDialog(null,	" item updated " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e3) {
	    	        			// TODO Auto-generated catch block
	    	        			e3.printStackTrace();
	    	        		} catch (FileNotFoundException e1) {
	    	        			// TODO Auto-generated catch block
	    	        			e1.printStackTrace();
	    	        		} catch (IOException e2) {
	    	        			// TODO Auto-generated catch block
	    	        			e2.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writer.flush();
	    	        				writer.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}
	    	                }
		    	                }
		    	                else{
		    	                	 System.out.println("Update Error");
		    	                }
		    	            }
		    	        });
		    	        
		    	        // button close window
		    	        btnCancel.addActionListener(new ActionListener(){

		    	            @Override
		    	            public void actionPerformed(ActionEvent e) {
		    	          
		    	            	upframe.dispose();
		    	             
		    	                }
		    	        });
		    	        upframe.setTitle("Update Item");
		    	        upframe.getContentPane().add(btnCancel);
		    	       /* JPanel bottompanel = new JPanel();
		    	        frame.add(bottompanel, BorderLayout.NORTH);
		    	        bottompanel.setVisible(true);
		    	        bottompanel.setSize(500, 100);
		    	        Border eBorder = BorderFactory.createEtchedBorder();
		    	        bottompanel.setBorder(BorderFactory.createTitledBorder(eBorder, "General"));
		    	        bottompanel.add(lblNewLabel);
		    	        bottompanel.add(textId);
		    	        bottompanel.add(lblNewLabel_1);
		    	        bottompanel.add(textFname);*/
		    	        upframe.setSize(500,400);
		    	        upframe.setLocationRelativeTo(null);	    	       
		    	        upframe.setVisible(true);
		    	        //selectedNode=null;
		            }
		        });
		        popupMenu.add(updatedeleteItem);
		        table.setComponentPopupMenu(popupMenu);
		      
				
				scrollPane.setViewportView(table);
			
			
			
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
	   // tree.addTreeSelectionListener(new TreeSelectionListener(){
	    	//public void valueChanged(TreeSelectionEvent se) {
		tree.addMouseListener(new MouseAdapter() {
		      @SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent me) {
	    	    JTree tree = (JTree) me.getSource();
	    	    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	    	    String selectedNodeName = selectedNode.toString();
	    	   
	    	    if (selectedNodeName=="Add New Item") {
	    	    	/*table = new JTable();
	    			   Object[] columns = {"Item","Description","Category","Tax", "Cost", "Price", "Location", "Quantity"};
	    		        final DefaultTableModel model = new DefaultTableModel();
	    		        model.setColumnIdentifiers(columns);
	    		     // set the model to the table
	    		        table.setModel(model);
	    		       
	    		        // Change A JTable Background Color, Font Size, Font Color, Row Height
	    		        table.setBackground(Color.LIGHT_GRAY);
	    		        table.setForeground(Color.black);
	    		        Font font = new Font("",1,22);
	    		        table.setFont(font);
	    		        table.setRowHeight(30);*/
	    	    	 
	    	        // create JFrame and JTable
	    	        final JFrame frame = new JFrame();
	    	        
	    	        // create a table model and set a Column Identifiers to this model 
	    	     
	    	        Font font1 = new Font("",1,22);	   
	    	       
	    	      
	    	        
	    	        // create JTextFields
	    	        final JTextField textId = new JTextField();
	    	        textId.setToolTipText("Enter Item");
	    	        textId.setBounds(100, 15, 100, 25);
	    	        final JTextField textFname = new JTextField();
	    	        textFname.setToolTipText("Enter Description");
	    	        final JTextField textLname = new JTextField();
	    	        textLname.setToolTipText("Enter Category");
	    	        final JTextField textAge = new JTextField();
	    	        textAge.setToolTipText("Enter Tax");
	    	        
	    	        
	    	        textField = new JTextField();
	    	        textField.setToolTipText("Enter Cost");
	    	        textField.setBounds(371, 15, 100, 25);
	    	        frame.getContentPane().add(textField);
	    	        textField.setColumns(10);
	    	        
	    	        textField_1 = new JTextField();
	    	        textField_1.setToolTipText("Enter Price");
	    	        textField_1.setBounds(371, 68, 100, 25);
	    	        frame.getContentPane().add(textField_1);
	    	        textField_1.setColumns(10);
	    	        
	    	        textField_2 = new JTextField();
	    	        textField_2.setToolTipText("Enter Location");
	    	        textField_2.setBounds(371, 126, 100, 25);
	    	        frame.getContentPane().add(textField_2);
	    	        textField_2.setColumns(10);
	    	        
	    	        textField_3 = new JTextField();
	    	        textField_3.setToolTipText("Enter Quantity");
	    	        textField_3.setBounds(371, 191, 100, 25);
	    	        frame.getContentPane().add(textField_3);
	    	        textField_3.setColumns(10);
	    	        
	    	        // create JButtons
	    	        JButton btnAdd = new JButton("Add");
	    	        JButton btnClear = new JButton("Clear");
	    	       // JButton btnUpdate = new JButton("Update");
	    	        //JButton btnUpdate = new JButton("Update");
	    	        JButton btnCancel = new JButton("Cancel");
	    	      
	    	        
	    	        textId.setBounds(117, 12, 100, 25);
	    	        textFname.setBounds(117, 65, 100, 25);
	    	        textLname.setBounds(117, 123, 100, 25);
	    	        textAge.setBounds(117, 188, 100, 25);
	    	        
	    	        btnAdd.setBounds(150, 265, 100, 25);
	    	        //btnUpdate.setBounds(1305, 265, 100, 25);
	    	       btnClear.setBounds(20, 265, 100, 25);
	    	        btnCancel.setBounds(300, 265, 100, 25);
	    	        
	    	        frame.getContentPane().setLayout(null);
	    	        
	    	        // add JTextFields to the jframe
	    	        frame.getContentPane().add(textId);
	    	        frame.getContentPane().add(textFname);
	    	        frame.getContentPane().add(textLname);
	    	        frame.getContentPane().add(textAge);
	    	    
	    	        // add JButtons to the jframe
	    	        frame.getContentPane().add(btnAdd);
	    	       frame.getContentPane().add(btnClear);
	    	   //     frame.getContentPane().add(btnUpdate);
	    	        frame.getContentPane().add(btnCancel);
	    	        
	    	        JLabel lblNewLabel = new JLabel("Item");
	    	        lblNewLabel.setBounds(24, 17, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel);
	    	        
	    	        JLabel lblNewLabel_1 = new JLabel("Description");
	    	        lblNewLabel_1.setBounds(24, 70, 100, 15);
	    	        frame.getContentPane().add(lblNewLabel_1);
	    	        
	    	        JLabel lblNewLabel_2 = new JLabel("Category");
	    	        lblNewLabel_2.setBounds(24, 128, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel_2);
	    	        
	    	        JLabel lblNewLabel_3 = new JLabel("Tax (%)");
	    	        lblNewLabel_3.setBounds(24, 193, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel_3);
	    	        
	    	        JLabel lblNewLabel_4 = new JLabel("Cost");
	    	        lblNewLabel_4.setBounds(253, 17, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel_4);
	    	        
	    	        JLabel lblNewLabel_5 = new JLabel("Price");
	    	        lblNewLabel_5.setBounds(253, 70, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel_5);
	    	        
	    	        JLabel lblNewLabel_6 = new JLabel("Location");
	    	        lblNewLabel_6.setBounds(253, 128, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel_6);
	    	        
	    	        JLabel lblNewLabel_7 = new JLabel("Quantity");
	    	        lblNewLabel_7.setBounds(253, 193, 70, 15);
	    	        frame.getContentPane().add(lblNewLabel_7);
	    	   
	    	        
	    	        
	    	        
	    	    
	    	        
	    	        
	    	        
	    	        // create an array of objects to set the row data
	    	        final Object[] row = new Object[8];
	    	        //button clear row
	    	        btnClear.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	textId.setText("");
		    	            textFname.setText("");
		    	            textLname.setText("");
		    	            textAge.setText("");
		    	            textField.setText("");
		    	            textField_1.setText("");
		    	            textField_2.setText("");
		    	            textField_3.setText("");
		    	            textId.setBackground(Color.WHITE);
	  	            		  textFname.setBackground(Color.WHITE);
	  	            		  textLname.setBackground(Color.WHITE);
	  	            		  textAge.setBackground(Color.WHITE);
	  	            		  textField.setBackground(Color.WHITE);
	  	            		  textField_1.setBackground(Color.WHITE);
	  	            		  textField_2.setBackground(Color.WHITE);
	  	            		  textField_3.setBackground(Color.WHITE);
	    	            }
	    	        });
	    	       
	    	        // button add row
	    	        btnAdd.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	             
	    	                row[0] = textId.getText();
	    	                row[1] = textFname.getText();
	    	                row[2] = textLname.getText();
	    	                row[3] = textAge.getText();
	    	                row[4] = textField.getText();
	    	                row[5] = textField_1.getText();
	    	                row[6] = textField_2.getText();
	    	                row[7] = textField_3.getText();
	    	             
	    	                
	    	                
	    	                if (row[0].equals("")&& row[1].equals("") && row[2].equals("") && row[3].equals("") && row[4].equals("") && row[5].equals("") && row[6].equals("") && row[7].equals("") )
	    	            	{
	    	            		  JOptionPane.showMessageDialog(null,"Please enter All Fields");
	    	            		  textId.setBackground(Color.RED);
	    	            		  textFname.setBackground(Color.RED);
	    	            		  textLname.setBackground(Color.RED);
	    	            		  textAge.setBackground(Color.RED);
	    	            		  textField.setBackground(Color.RED);
	    	            		  textField_1.setBackground(Color.RED);
	    	            		  textField_2.setBackground(Color.RED);
	    	            		  textField_3.setBackground(Color.RED);
	    	            	}
	    	            	else{
	    	            		
	    	            	
	    					if (row[0].equals("")){  //User have not entered anything. 
	    	            	    JOptionPane.showMessageDialog(null,"Please enter Item-ID");
	    	            	    textId.setBackground(Color.RED);
	    	            	    }
	    					else{					
	    		                
	    		                textId.setBackground(Color.GREEN);
	    	  //Object[]  a =  (Object[]) row[0];
	    	            	    
	    	            	    //model.addRow(a);    
	    					}
	    					
	    					
	    	            	    if (row[1].equals("")){  //User have not entered anything. 
	    	                	  JOptionPane.showMessageDialog(null,"Please Enter Description");
	    	                	    textFname.setBackground(Color.RED);
	    	                	    
	    	                	    
	    	                	    //Do NOT loop here.
	    	                	}
	    	            	    else{
	    	    					
	    	            	    	 
	    	    	                textFname.setBackground(Color.GREEN);}
	    	            	    if (row[2].equals("")){  //User have not entered anything. 
	    	                	  JOptionPane.showMessageDialog(null,"Please Enter Category");
	    	                	    textLname.setBackground(Color.RED);
	    	                	    //Do NOT loop here.
	    	                	}
	    	            	    else{
	    	    					
	    	            	    	
	    	            	    	textLname.setBackground(Color.GREEN);}
	    	            	    if (row[3].equals("")){  //User have not entered anything. 
	    	                	  JOptionPane.showMessageDialog(null,"Please Enter Tax");
	    	                	    textAge.setBackground(Color.RED);
	    	                	    //Do NOT loop here.
	    	                	}
	    	            	    boolean match3;
	    	            	    match3=((String) row[3]).matches("[0-9]+");
	    	            	    if (match3==true){  //User have not entered anything. 
	    	            	    	textAge.setBackground(Color.GREEN);
	    	                  	}
	    	            	    
	    	                      else{
	    	                    	  JOptionPane.showMessageDialog(null,"Please Enter Numbers for Tax");
	    	            	    	
	    	            	    	textAge.setBackground(Color.RED);}                
	    	            	    if (row[4].equals("")){  //User have not entered anything. 
	    	                	  JOptionPane.showMessageDialog(null,"Please Enter Cost");
	    	                	    textField.setBackground(Color.RED);
	    	                	    //Do NOT loop here.
	    	                	}
	    	            	    boolean match;
	    	            	    match=((String) row[4]).matches("[0-9]+");
	    	            	    if (match==true){  //User have not entered anything. 
	    	            	    	textField.setBackground(Color.GREEN);
	    	                  	}
	    	                       else{
	    	    					

	    	                    	   JOptionPane.showMessageDialog(null,"Please Enter Numbers for cost");
	    	                      	    textField.setBackground(Color.RED);
	    	                       	 
	    	            	    	}   
	    	            	    if (row[5].equals("")){  //User have not entered anything. 
	    	                	    JOptionPane.showMessageDialog(null,"Please Enter price");
	    	                	    textField_1.setBackground(Color.RED);
	    	                	    //Do NOT loop here.
	    	                	}
	    	            	    boolean match1;
	    	            	    match1=((String) row[5]).matches("[0-9]+");
	    	            	    if (match1==true){  //User have not entered anything. 
	    	            	    	textField_1.setBackground(Color.GREEN);
	    	                  	}
	    	                       else{
	    	    					
	    	                    	   JOptionPane.showMessageDialog(null,"Please Enter Numbers for price");
	    	                      	    textField_1.setBackground(Color.RED);
	    	                      	    //Do NOT loop here.
	    	                      	    }   
	    	            	    
	    	            	    if (row[6].equals("")){  //User have not entered anything. 
	    	                	    JOptionPane.showMessageDialog(null,"Please Enter Location");
	    	                	    textField_2.setBackground(Color.RED);
	    	                	    //Do NOT loop here.
	    	                	}
	    	                       else{
	    	    					
	    	            	    	
	    	            	    	textField_2.setBackground(Color.GREEN);}   
	    	            	    if (row[7].equals("")){  //User have not entered anything. 
	    	                	    JOptionPane.showMessageDialog(null,"Please Enter Quantity");
	    	                	    textField_3.setBackground(Color.RED);
	    	                	    //Do NOT loop here.
	    	                	}else{
	    	            	    
	    	            	    	textField_3.setBackground(Color.GREEN);
	    	                  	}
	    	            	
	    	            	
							if (!row[0].equals("")&& !row[1].equals("") && !row[2].equals("") && !row[3].equals("") && match3==true&& match==true && match1==true && !row[4].equals("") && !row[5].equals("") && !row[6].equals("") && ! row[7].equals("") )
	                	    {
	                	    row[0] = textId.getText();
	                		row[1] = textFname.getText();
	                		row[2] = textLname.getText();
	                		row[3] = textAge.getText();
	                		row[4] = textField.getText();
	                		row[5] = textField_1.getText();
	                		row[6] = textField_2.getText();                
	                        row[7] = textField_3.getText();
	    	                
	    	                
	    	                
	    	                // add row to the model
	    	                model.addRow(row);
	    	               
	    	                    	
	    	                    	BufferedWriter writer = null;
	    	                    	 OutputStreamWriter output;
	    	                    	 FileOutputStream filestream;
	    	                    	 BufferedReader br = null;
	    	                    	 
	    	                    	
	    	                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    	                int nRow = dtm.getRowCount();
	    	                int nCol = dtm.getColumnCount();
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	new File("Directory1").mkdir();
	    	                	FileWriter fw = new FileWriter("itemslist.csv", false);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writer = new BufferedWriter(fw);
	    	              	//   String line;
	    	              //	  int index=0;
	    	              	    
	    	              	//  while ((line = br.readLine()) == null) {
	    	              	    	
	    	              //             if(line==null){
	    	                	

	    	                    //write the header information
	    	                   StringBuffer bufferHeader = new StringBuffer();
	    	                 
	    	                   for (int j =0; j < nCol; j++) {
	    	                      bufferHeader.append(dtm.getColumnName(j));
	    	                        if (j!=nCol) bufferHeader.append(",");
	    	                    }
	    	                    //writer.write(bufferHeader.toString() + "\r\n");

	    	                   //write row information
	    	                    for (int i = 0 ; i < nRow ; i++){
	    	                         StringBuffer buffer = new StringBuffer();
	    	                        for (int j = 0 ; j < nCol ; j++){
	    	                           buffer.append(dtm.getValueAt(i,j));
	    	                           if (j!=nCol) buffer.append(",");
	    	                        }
	    	                        writer.write(buffer.toString() + "\r");
	    	                    }JOptionPane.showMessageDialog(null,	" item added " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e3) {
	    	        			// TODO Auto-generated catch block
	    	        			e3.printStackTrace();
	    	        		} catch (FileNotFoundException e1) {
	    	        			// TODO Auto-generated catch block
	    	        			e1.printStackTrace();
	    	        		} catch (IOException e2) {
	    	        			// TODO Auto-generated catch block
	    	        			e2.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writer.flush();
	    	        				writer.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}
	    	                }
	                	    }
	    	            }
	    	            }
	    	            });
	    	        
	    	     
	    	        
	    	        // button close window
	    	        btnCancel.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	          
	    	            	frame.dispose();
	    	             
	    	                }
	    	        });
	    	        frame.setTitle("Add New Item");
	    	        /*JPanel bottompanel = new JPanel();
	    	        frame.add(bottompanel, BorderLayout.NORTH);
	    	        bottompanel.setVisible(true);
	    	        bottompanel.setSize(500, 100);
	    	        Border eBorder = BorderFactory.createEtchedBorder();
	    	        bottompanel.setBorder(BorderFactory.createTitledBorder(eBorder, "General"));
	    	        bottompanel.add(lblNewLabel);
	    	        bottompanel.add(textId);
	    	        bottompanel.add(lblNewLabel_1);
	    	        bottompanel.add(textFname);*/
	    	        frame.setSize(500,400);
	    	        frame.setLocationRelativeTo(null);	    	       
	    	        frame.setVisible(true);
	    	        selectedNode=null;
	    		}
	    	   
	    	    if(selectedNodeName=="Update"){
	    	    	
	    	        final JFrame Udframe = new JFrame();
	    	        
	    	        // create a table model and set a Column Identifiers to this model 
	    	     
	    	        Font font1 = new Font("",1,22);	   
	    	        
	    	        
	    	        
	    	        
	    	       
	    	      
	    	        
	    	        // create JTextFields
	    	        final JTextField textId = new JTextField();
	    	        textId.setToolTipText("Enter Item");
	    	        textId.setBounds(100, 15, 100, 25);
	    	        final JTextField textFname = new JTextField();
	    	        textFname.setToolTipText("Enter Description");
	    	        final JTextField textLname = new JTextField();
	    	        textLname.setToolTipText("Enter Tax");
	    	        final JTextField textAge = new JTextField();
	    	        textAge.setToolTipText("Enter Category");
	    	        
	    	        
	    	        textField = new JTextField();
	    	        textField.setToolTipText("Enter Cost");
	    	        textField.setBounds(371, 15, 100, 25);
	    	        Udframe.getContentPane().add(textField);
	    	        textField.setColumns(10);
	    	        
	    	        textField_1 = new JTextField();
	    	        textField_1.setToolTipText("Enter Price");
	    	        textField_1.setBounds(371, 68, 100, 25);
	    	        Udframe.getContentPane().add(textField_1);
	    	        textField_1.setColumns(10);
	    	        
	    	        textField_2 = new JTextField();
	    	        textField_2.setToolTipText("Enter Location");
	    	        textField_2.setBounds(371, 126, 100, 25);
	    	        Udframe.getContentPane().add(textField_2);
	    	        textField_2.setColumns(10);
	    	        
	    	        textField_3 = new JTextField();
	    	        textField_3.setToolTipText("Enter Quantity");
	    	        textField_3.setBounds(371, 191, 100, 25);
	    	        Udframe.getContentPane().add(textField_3);
	    	        textField_3.setColumns(10);
	    	        
	    	        // create JButtons
	    	        //JButton btnAdd = new JButton("Add");
	    	        JButton btnDelete = new JButton("Delete");
	    	        JButton btnUpdate = new JButton("Update");
	    	        JButton btnCancel = new JButton("Cancel");
	    	      
	    	        
	    	        textId.setBounds(117, 12, 100, 25);
	    	        textFname.setBounds(117, 65, 100, 25);
	    	        textLname.setBounds(117, 123, 100, 25);
	    	        textAge.setBounds(117, 188, 100, 25);
	    	        
	    	       // btnAdd.setBounds(150, 265, 100, 25);
	    	        btnUpdate.setBounds(140, 265, 100, 25);
	    	        btnDelete.setBounds(260, 265, 100, 25);
	    	       btnCancel.setBounds(260, 265, 100, 25);
	    	        
	    	       Udframe.getContentPane().setLayout(null);
	    	        
	    	        // add JTextFields to the jframe
	    	       Udframe.getContentPane().add(textId);
	    	       Udframe.getContentPane().add(textFname);
	    	       Udframe.getContentPane().add(textLname);
	    	       Udframe.getContentPane().add(textAge);
	    	    
	    	        // add JButtons to the jframe
	    	      //  frame.getContentPane().add(btnAdd);
	    	        //frame.getContentPane().add(btnDelete);
	    	       Udframe.getContentPane().add(btnUpdate);
	    	  //      frame.getContentPane().add(btnCancel);
	    	        
	    	        JLabel lblNewLabel = new JLabel("Item");
	    	        lblNewLabel.setBounds(24, 17, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel);
	    	        
	    	        JLabel lblNewLabel_1 = new JLabel("Description");
	    	        lblNewLabel_1.setBounds(24, 70, 100, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_1);
	    	        
	    	        JLabel lblNewLabel_2 = new JLabel("Tax");
	    	        lblNewLabel_2.setBounds(24, 128, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_2);
	    	        
	    	        JLabel lblNewLabel_3 = new JLabel("Category");
	    	        lblNewLabel_3.setBounds(24, 193, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_3);
	    	        
	    	        JLabel lblNewLabel_4 = new JLabel("Cost");
	    	        lblNewLabel_4.setBounds(253, 17, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_4);
	    	        
	    	        JLabel lblNewLabel_5 = new JLabel("Price");
	    	        lblNewLabel_5.setBounds(253, 70, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_5);
	    	        
	    	        JLabel lblNewLabel_6 = new JLabel("Location");
	    	        lblNewLabel_6.setBounds(253, 128, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_6);
	    	        
	    	        JLabel lblNewLabel_7 = new JLabel("Quantity");
	    	        lblNewLabel_7.setBounds(253, 193, 70, 15);
	    	        Udframe.getContentPane().add(lblNewLabel_7);
	    	   
	    	        
	    	        
	    	        
	    	    
	    	        
	    	        
	    	        
	    	        // create an array of objects to set the row data
	    	        final Object[] row = new Object[8];
	    	        
	    	   	    	        
	    	        
	    	     
	    	        
	    	        // get selected row data From table to textfields 
	    	        table.addMouseListener(new MouseAdapter(){
	    	        @Override
	    	        public void mouseClicked(MouseEvent e){
	    	            
	    	            // i = the index of the selected row
	    	            int i = table.getSelectedRow();
	    	            //table.changeSelection(i, i, false, false);
	    	           
                       String x= model.getValueAt(i, 0).toString();
                       System.out.println("x is "+x);
                       textId.setText(model.getValueAt(i, 0).toString());
	    	            textFname.setText(model.getValueAt(i, 1).toString());
	    	            textLname.setText(model.getValueAt(i, 2).toString());
	    	            textAge.setText(model.getValueAt(i, 3).toString());
	    	            textField.setText(model.getValueAt(i, 4).toString());
	    	            textField_1.setText(model.getValueAt(i, 5).toString());
	    	            textField_2.setText(model.getValueAt(i, 6).toString());
	    	            textField_3.setText(model.getValueAt(i, 7).toString());
	    	        }
	    	        });
	    	        
	    	        
	    	        // button update row
	    	        btnUpdate.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	             
	    	                // i = the index of the selected row
	    	                int i = table.getSelectedRow();
	    	                
	    	                if(i >= 0) 
	    	                {
	    	                   model.setValueAt(textId.getText(), i, 0);
	    	                   model.setValueAt(textFname.getText(), i, 1);
	    	                   model.setValueAt(textLname.getText(), i, 2);
	    	                   model.setValueAt(textAge.getText(), i, 3);
	    	                   model.setValueAt(textField.getText(), i, 4);
	    	                   model.setValueAt(textField_1.getText(), i, 5);
	    	                   model.setValueAt(textField_2.getText(), i, 6);
	    	                   model.setValueAt(textField_3.getText(), i, 7);
	    	                   
	    	               	
    	                    	BufferedWriter writer = null;
    	                    	 OutputStreamWriter output;
    	                    	 FileOutputStream filestream;
    	                    	 BufferedReader br = null;
    	                    	 
    	                    	
    	                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    	                int nRow = dtm.getRowCount();
    	                int nCol = dtm.getColumnCount();
    	                try {
    	                	//  br = new BufferedReader(new FileReader("file.csv"));
    	                	FileWriter fw = new FileWriter("itemslist.csv", false);
    	                // BufferedWriter bw = new BufferedWriter(fw);
    	                	  writer = new BufferedWriter(fw);
    	              	//   String line;
    	              //	  int index=0;
    	              	    
    	              	//  while ((line = br.readLine()) == null) {
    	              	    	
    	              //             if(line==null){
    	                	

    	                    //write the header information
    	                   StringBuffer bufferHeader = new StringBuffer();
    	                 
    	                   for (int j =0; j < nCol; j++) {
    	                      bufferHeader.append(dtm.getColumnName(j));
    	                        if (j!=nCol) bufferHeader.append(", ");
    	                    }
    	                    //writer.write(bufferHeader.toString() + "\r\n");

    	                   //write row information
    	                    for (int i1 = 0 ; i1 < nRow ; i1++){
    	                         StringBuffer buffer = new StringBuffer();
    	                        for (int j = 0 ; j < nCol ; j++){
    	                           buffer.append(dtm.getValueAt(i1,j));
    	                           if (j!=nCol) buffer.append(", ");
    	                        }
    	                        writer.write(buffer.toString() + "\r");
    	                    }JOptionPane.showMessageDialog(null,	" item updated " );}
    	              // index++;line="ll"; }}
    	                catch (UnsupportedEncodingException e3) {
    	        			// TODO Auto-generated catch block
    	        			e3.printStackTrace();
    	        		} catch (FileNotFoundException e1) {
    	        			// TODO Auto-generated catch block
    	        			e1.printStackTrace();
    	        		} catch (IOException e2) {
    	        			// TODO Auto-generated catch block
    	        			e2.printStackTrace();
    	        		} finally {
    	                      try {
    	                    	  //br.close();
    	        				//writer.close();
    	        				writer.flush();
    	        				writer.close();
    	        			} catch (IOException e4) {
    	        				// TODO Auto-generated catch block
    	        				e4.printStackTrace();
    	        			}
    	                }
	    	                }
	    	                else{
	    	                	 System.out.println("Update Error");
	    	                }
	    	            }
	    	        });
	    	        
	    	        // button close window
	    	        btnCancel.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	          
	    	            	Udframe.dispose();
	    	             
	    	                }
	    	        });
	    	        Udframe.setTitle("Update Item");
	    	        Udframe.getContentPane().add(btnCancel);
	    	        /*JPanel bottompanel = new JPanel();
	    	        frame.add(bottompanel, BorderLayout.NORTH);
	    	        bottompanel.setVisible(true);
	    	        bottompanel.setSize(500, 100);
	    	        Border eBorder = BorderFactory.createEtchedBorder();
	    	        bottompanel.setBorder(BorderFactory.createTitledBorder(eBorder, "General"));
	    	        bottompanel.add(lblNewLabel);
	    	        bottompanel.add(textId);
	    	        bottompanel.add(lblNewLabel_1);
	    	        bottompanel.add(textFname);*/
	    	        Udframe.setSize(500,400);
	    	        Udframe.setLocationRelativeTo(null);	    	       
Udframe.setVisible(true);
	    	        //selectedNode=null;
	    	    }
	    	    
	    	    if(selectedNodeName=="Delete"){
			       
	    	    	// create JTextFields
	    	        final JTextField textId = new JTextField();
	    	        textId.setToolTipText("Enter Item");
	    	        textId.setBounds(100, 15, 100, 25);
	    	        final JTextField textFname = new JTextField();
	    	        textFname.setToolTipText("Enter Description");
	    	        final JTextField textLname = new JTextField();
	    	        textLname.setToolTipText("Enter Tax");
	    	        final JTextField textAge = new JTextField();
	    	        textAge.setToolTipText("Enter Category");
	    	    	 // get selected row data From table to textfields 
	    	       
	    	    	 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                if(i >= 0){
	                    // remove a row from jtable
	                    model.removeRow(i);

                    	BufferedWriter writer = null;
                    	 OutputStreamWriter output;
                    	 FileOutputStream filestream;
                    	 BufferedReader br = null;
                    	 
                    	
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                int nRow = dtm.getRowCount();
                int nCol = dtm.getColumnCount();
                try {
                	//  br = new BufferedReader(new FileReader("file.csv"));
                	FileWriter fw = new FileWriter("itemslist.csv", false);
                // BufferedWriter bw = new BufferedWriter(fw);
                	  writer = new BufferedWriter(fw);
              	//   String line;
              //	  int index=0;
              	    
              	//  while ((line = br.readLine()) == null) {
              	    	
              //             if(line==null){
                	

                    //write the header information
                   StringBuffer bufferHeader = new StringBuffer();
                 
                   for (int j =0; j < nCol; j++) {
                      bufferHeader.append(dtm.getColumnName(j));
                        if (j!=nCol) bufferHeader.append(",");
                    }
                    //writer.write(bufferHeader.toString() + "\r\n");

                   //write row information
                    for (int i1 = 0 ; i1 < nRow ; i1++){
                         StringBuffer buffer = new StringBuffer();
                        for (int j = 0 ; j < nCol ; j++){
                           buffer.append(dtm.getValueAt(i1,j));
                           if (j!=nCol) buffer.append(",");
                        }
                        writer.write(buffer.toString() + "\r");
                    }JOptionPane.showMessageDialog(null,	" item deleted " );}
              // index++;line="ll"; }}
                catch (UnsupportedEncodingException e3) {
        			// TODO Auto-generated catch block
        			e3.printStackTrace();
        		} catch (FileNotFoundException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		} catch (IOException e2) {
        			// TODO Auto-generated catch block
        			e2.printStackTrace();
        		} finally {
                      try {
                    	  //br.close();
        				//writer.close();
        				writer.flush();
        				writer.close();
        			} catch (IOException e4) {
        				// TODO Auto-generated catch block
        				e4.printStackTrace();
        			}
                }
	                }
	                else{
	                    JOptionPane.showInputDialog(null, "please select item to delete");
	                }
	               // frame.dispose();
	    	    }
	    	    if(selectedNodeName=="Find Item"){
	    	    	
	    	    	//JOptionPane.showMessageDialog(null,	" Find Item node selected " );
	    	    	final JFrame frame1 = new JFrame();
	    	        
	    	        // create a table model and set a Column Identifiers to this model 
	    	     
	    	        Font font2 = new Font("",1,22);	
	    	        JLabel findItemLabel = new JLabel("Find Item");
	    	        findItemLabel.setBounds(24, 20, 70, 15);
	    	        frame1.getContentPane().add(findItemLabel);
	    	        
	    	        frame1.setTitle("Find Item: ");
	    	        frame1.setSize(350,200);
	    	        frame1.setLocationRelativeTo(null);	 
	    	        
	    	        final JTextField searchTextField = new JTextField();
	    	        searchTextField.setToolTipText("Enter Search Item");
	    	        searchTextField.setBounds(100, 20, 200, 25);
	    	        frame1.getContentPane().add(searchTextField);
	    	       // searchTextField.setColumns(10);
	    	        frame1.getContentPane().setLayout(null);
	    	        
	    	        // create JButtons
	    	        JButton btnFind = new JButton("Find");
	    	        //JButton btnDelete = new JButton("Delete");
	    	       // JButton btnUpdate = new JButton("Update");
	    	        //JButton btnUpdate = new JButton("Update");
	    	        JButton btnCancel1 = new JButton("Cancel");
	    	        btnFind.setBounds(50, 100, 100, 25);
	    	        btnCancel1.setBounds(200, 100, 100, 25);
	    	        
	    	        frame1.getContentPane().add(btnFind);
	    	        frame1.getContentPane().add(btnCancel1);
	    	        
	    	          // button search item
	    	        btnFind.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
	    	            	int c=0;
	    	            	String findvalue = searchTextField.getText();
	    	            	if((findvalue.isEmpty())){
	    	            		JOptionPane.showMessageDialog(null,"please enter item to search");}
	    	            	else{
	    	            	
	    	            	if(!(findvalue.isEmpty())){
	    	            		//System.out.println("if:"+findvalue);
	    	            		for(int i = 0; i < table.getRowCount(); i++){//For each row
	    	            	       // for(int j = 0; j < table.getColumnCount(); j++){//For each column in that row
	    	            			//System.out.println(model.getValueAt(i, 0));
	    	            	            if(model.getValueAt(i, 0).equals(findvalue)){//Search the model
	    	            	                //System.out.println(table.getModel().getValueAt(i, j));//Print if found string
	    	            	               // System.out.println("Search found");
	    	            	            	c=1;
	    	            	            	table.changeSelection(i, 0, false, false);
	    	            	               // JOptionPane.showMessageDialog(null,	" Search Item is found " );
	    	            	           
	    	            	            }
	    	            	           
	    	            	           
	    	            	   // }
	    	            		
	    	            	}
	    	            		
	    	            	}
	    	            	
	    	            	if(c==0){
	    	            	System.out.println("else:"+findvalue);
	    	            	JOptionPane.showMessageDialog(null,"Search Item is not found");}
	    	            	
	    	            }}
	    	        });
	    	        
	    	        // button close window
	    	        btnCancel1.addActionListener(new ActionListener(){

	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	          
	    	            	frame1.dispose();
	    	             
	    	                }
	    	        });
	    	        
	    	        
	    	        frame1.setVisible(true);
	    	    	
	    	    }
	    	    if(selectedNodeName=="Order Stock"){
	    	    	frmStockOrder = new JFrame();
	    			frmStockOrder.setTitle("Stock Order");
	    			frmStockOrder.setBounds(100, 100, 642, 547);
	    			//frmStockOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    			frmStockOrder.setVisible(true);
	    			
	    			Panel panel = new Panel();
	    			panel.setFocusTraversalPolicyProvider(true);
	    			panel.setPreferredSize(new Dimension(50, 260));
	    			panel.setFocusCycleRoot(true);
	    			frmStockOrder.getContentPane().add(panel, BorderLayout.CENTER);
	    			panel.setLayout(null);
	    			
	    			JLabel lblOrderSupllier = new JLabel("Order Supllier: ");
	    			lblOrderSupllier.setSize(108, 15);
	    			lblOrderSupllier.setHorizontalAlignment(SwingConstants.TRAILING);
	    			lblOrderSupllier.setAlignmentY(0.0f);
	    			lblOrderSupllier.setOpaque(true);
	    			lblOrderSupllier.setLocation(new Point(12, 5));
	    			lblOrderSupllier.setRequestFocusEnabled(false);
	    			lblOrderSupllier.setFocusable(false);
	    			panel.add(lblOrderSupllier);
	    			
	    			JLabel lblNewLabel = new JLabel("Billing Address:");
	    			lblNewLabel.setBounds(new Rectangle(16, 95, 143, 22));
	    			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    			lblNewLabel.setToolTipText("bill");
	    			panel.add(lblNewLabel);
	    			
	    			final JTextArea txtrBilladdress = new JTextArea();
	    			txtrBilladdress.setBounds(16, 129, 279, 50);
	    			txtrBilladdress.setAlignmentX(Component.RIGHT_ALIGNMENT);
	    			txtrBilladdress.setDoubleBuffered(true);
	    			txtrBilladdress.setDragEnabled(true);
	    			txtrBilladdress.setFocusCycleRoot(true);
	    			txtrBilladdress.setFocusTraversalPolicyProvider(true);
	    			txtrBilladdress.setToolTipText("Enter Billing Address");
	    			txtrBilladdress.setPreferredSize(new Dimension(150, 50));
	    			panel.add(txtrBilladdress);
	    			
	    			final Choice choice = new Choice();
	    			choice.setPreferredSize(new Dimension(100, 25));
	    			choice.setBounds(150, 5, 108, 21);
	    			panel.add(choice);
	    			
	    			JLabel lblNewLabel_1 = new JLabel("Expected Receipt Date: ");
	    			lblNewLabel_1.setBounds(12, 32, 177, 15);
	    			panel.add(lblNewLabel_1);
	    			
	    			textField_4 = new JTextField();
	    			textField_4.setBounds(187, 32, 114, 19);
	    			panel.add(textField_4);
	    			textField_4.setColumns(10);
	    			
	    			JLabel lblShippingAddress = new JLabel("Shipping Address:");
	    			lblShippingAddress.setBounds(350, 99, 150, 15);
	    			panel.add(lblShippingAddress);
	    			
	    			JTextArea textArea = new JTextArea();
	    			textArea.setToolTipText("Enter Shipping Address");
	    			textArea.setBounds(347, 129, 246, 50);
	    			panel.add(textArea);
	    			
	    			//JButton btnPreview = new JButton("Preview");
	    			//btnPreview.setBounds(26, 482, 117, 25);
	    			//panel.add(btnPreview);
	    			
	    			JButton btnCancel = new JButton("Cancel");
	    			btnCancel.setBounds(501, 482, 117, 25);
	    			panel.add(btnCancel);
	    			
	    			JButton btnRecordAndPrint = new JButton("Order Stock");
	    			btnRecordAndPrint.setBounds(245, 482, 165, 25);
	    			panel.add(btnRecordAndPrint);
	    			
	    			JLabel lblNewLabel_2 = new JLabel("Order Notes: ");
	    			lblNewLabel_2.setBounds(26, 400, 129, 15);
	    			panel.add(lblNewLabel_2);
	    			
	    			final JTextArea textArea_1 = new JTextArea();
	    			textArea_1.setBounds(26, 427, 129, 43);
	    			panel.add(textArea_1);
	    			
	    			JLabel lblInternalNotes = new JLabel("Internal Notes: ");
	    			lblInternalNotes.setBounds(272, 400, 143, 15);
	    			panel.add(lblInternalNotes);
	    			
	    			JTextArea textArea_2 = new JTextArea();
	    			textArea_2.setBounds(235, 427, 190, 50);
	    			panel.add(textArea_2);
	    			
	    			JLabel lblIssueDate = new JLabel("Issue date:");
	    			lblIssueDate.setBounds(350, 5, 92, 15);
	    			panel.add(lblIssueDate);
	    			
	    			JLabel lblTax = new JLabel("Tax");
	    			lblTax.setBounds(347, 32, 70, 15);
	    			panel.add(lblTax);
	    			
	    			textField_5 = new JTextField();
	    			textField_5.setBounds(460, 7, 114, 19);
	    			panel.add(textField_5);
	    			textField_5.setColumns(10);
	    			
	    			textField_6 = new JTextField();
	    			textField_6.setBounds(460, 30, 114, 19);
	    			panel.add(textField_6);
	    			textField_6.setColumns(10);
	    			
	    			JLabel lblShipTo = new JLabel("Ship To:");
	    			lblShipTo.setBounds(350, 59, 70, 15);
	    			panel.add(lblShipTo);
	    			
	    			textField_7 = new JTextField();
	    			textField_7.setBounds(460, 57, 114, 19);
	    			panel.add(textField_7);
	    			textField_7.setColumns(10);
	    			
	    			JLabel lblTaxid = new JLabel("Tracking-Ref");
	    			lblTaxid.setBounds(12, 191, 108, 15);
	    			panel.add(lblTaxid);
	    			
	    			textField_8 = new JTextField();
	    			textField_8.setBounds(119, 191, 177, 19);
	    			panel.add(textField_8);
	    			textField_8.setColumns(10);
	    			
	    			JLabel lblNewLabel_3 = new JLabel("Ship-By:");
	    			lblNewLabel_3.setBounds(350, 191, 70, 15);
	    			panel.add(lblNewLabel_3);
	    			
	    			Choice choice_1 = new Choice();
	    			choice_1.setBounds(460, 185, 114, 21);
	    			panel.add(choice_1);
	    			
	    			JButton btnAdd1 = new JButton("Add");
	    			btnAdd1.setBounds(26, 365, 117, 25);
	    			panel.add(btnAdd1);
	    			
	    			JButton btnRemove = new JButton("Remove");
	    			btnRemove.setBounds(200, 365, 117, 25);
	    			panel.add(btnRemove);
	    			
	    			//JButton btnEdit = new JButton("Edit");
	    			//btnEdit.setBounds(383, 363, 117, 25);
	    			//panel.add(btnEdit);
	    			
	    			JScrollPane scrollPane = new JScrollPane();
	    			scrollPane.setBounds(12, 218, 618, 135);
	    			panel.add(scrollPane);
	    			
	    			table1 = new JTable();
	    			table1.setBackground(SystemColor.control);
	    			/*table1.setModel(new DefaultTableModel(
	    				new Object[][] {
	    				},
	    				new String[] {
	    					"Quantity", "Item", "Description", "Tax", "Unit value", "Line Total", "Measure"
	    				}
	    			) {
	    				Class[] columnTypes = new Class[] {
	    					Object.class, Object.class, Object.class, Double.class, Object.class, Object.class, Object.class
	    				};
	    				public Class getColumnClass(int columnIndex) {
	    					return columnTypes[columnIndex];
	    				}
	    				boolean[] columnEditables = new boolean[] {
	    					true, true, true, false, true, true, true
	    				};
	    				public boolean isCellEditable(int row, int column) {
	    					return columnEditables[column];
	    				}
	    			});*/
	    			 Object[] columns1 = {"Quantity", "Item", "Description", "Tax", "Unit value", "Line Total"};
	    			final DefaultTableModel model1 = new DefaultTableModel();
			       model1.setColumnIdentifiers(columns1);
			       table1.setModel(model1);
	    			 try {
 	    				
 	                	  BufferedReader br1 = new BufferedReader(new FileReader("file1.csv"));
 	                	    String line = null;
 	                	   
 	                	    @SuppressWarnings("rawtypes")
 	                		Vector myVec = new Vector();
 	                	    while ((line = br1.readLine()) != null) {
 	                	    	// if(index == 0) {
 	                           //      index++;
 	                           //      continue; //skip first line
 	                           //   }
 	                	      String[] values = line.split(",");
 	                	      int i=0;
 	                	     int index=0;
 	                	    for ( String str : values) {
 	                	    	 
 	                	    	 if(index == 0) {        	    	                 	    	 
 	                	       row[i] = values;
 	                	      Object[]  row1 = (Object[])  row[i];
 	                	    	// str= myVec.add(str);
 	                	    	choice.add(str);
 	                	        //  model.addRow(row1);
 	                	    	 
 	                	    	 }
 	                	    	else{
 	                	    		 continue;
 	                	    	 }
 	                	    	index++;
 	                	    	 //  System.out.println(row1);
 	                	  }
 	                	     // i++; 
 	                	    } 
 	                	    //}
 	                	    br1.close();
 	                	  
 	                } catch (IOException ex) {
 	                    System.out.println(ex.getMessage());
 	                    ex.printStackTrace();
 	                }
            	        	
            				
            	       // }
            		//}
	    			table1	.getColumnModel().getColumn(3).setResizable(false);
	    			scrollPane.setViewportView(table1);
	    			
	    			final JTextArea textArea_3 = new JTextArea();
	    			textArea_3.setBounds(504, 397, 114, 73);
	    			panel.add(textArea_3);
	    			
	    			JLabel lblTotalPrice = new JLabel("Total Price");
	    			lblTotalPrice.setBounds(532, 375, 87, 15);
	    			
	    			 BufferedImage buttonIcon = null;
					try {
						buttonIcon = ImageIO.read(new File("contact_icons.png"));
					} catch (IOException e5) {
						// TODO Auto-generated catch block
						e5.printStackTrace();
					}
	    		        //button = new JButton(new ImageIcon(buttonIcon));
	    			JButton btnNewButton = new JButton("+");
	    			btnNewButton.setBounds(272, 5, 45, 25);
	    			panel.add(btnNewButton);
	    			btnNewButton.addActionListener(new ActionListener()
	    			{
	    				public void actionPerformed(ActionEvent e)
	    				{
	    					Stable = new JTable();
	    			        // create JFrame and JTable
	    			        JFrame frame = new JFrame();
	    			       // frame.setDefaultCloseOperation(frmStockOrder.EXIT_ON_CLOSE);
	    			        // create a table model and set a Column Identifiers to this model 
	    			      Object[] columns = {"Supplier Id", "Name", "Address", "Contact"};
	    			        final DefaultTableModel model = new DefaultTableModel();
	    			        model.setColumnIdentifiers(columns);
	    			        Stable.setModel(model);
	    			        Font font = new Font("",1,22);
	    			        
	    			        
	    			        // create JTextFields
	    			        final JTextField textId = new JTextField();
	    			        textId.setToolTipText("Enter Supplier id");
	    			        final JTextField textFname = new JTextField();
	    			        textFname.setToolTipText("Enter Name");
	    			        final JTextField textLname = new JTextField();
	    			        textLname.setToolTipText("Enter Address");
	    			        final JTextField textAge = new JTextField();
	    			        textAge.setToolTipText("Enter Contact");
	    			        
	    			        try {
	    	                	 
	    	                	  BufferedReader br = new BufferedReader(new FileReader("file1.csv"));
	    	                	    String line = null;
	    	                	   // int index=0;
	    	                	    
	    	                	    while ((line = br.readLine()) != null) {
	    	                	    	// if(index == 0) {
	    	                              //   index++;
	    	                                // continue; //skip first line
	    	                         //     }
	    	                	      String[] values = line.split(",");
	    	                	      int i=0;
	    	                	    
	    	                	    //for ( String str : values) {
	    	                	    	 
	    	                	    	             	    	                 	    	 
	    	                	       row[i] = values;
	    	                	       Object[]  row1 = (Object[])  row[i];
	    	                	    	// str= myVec.add(str);
	    	                	       
	    	                	          model.addRow(row1);
	    	                	             
	    	                	    	 
	    	                	    		  //System.out.println(row1);
	    	                	  //  }
	    	                	      i++; 
	    	                	    }
	    	                	    br.close();
	    	                	  
	    	                } catch (IOException ex) {
	    	                    System.out.println(ex.getMessage());
	    	                    ex.printStackTrace();
	    	                }
	    			        
	    			        // create JButtons
	    			       //  JButton button = new JButton(new ImageIcon(buttonIcon));
	    			        JButton btnAdd = new JButton("Add");
	    			        JButton btnDelete = new JButton("Delete");
	    			        JButton btnUpdate = new JButton("Update");     
	    			        
	    			        textId.setBounds(117, 12, 138, 25);
	    			        textFname.setBounds(117, 65, 138, 25);
	    			        textLname.setBounds(117, 123, 138, 25);
	    			        textAge.setBounds(117, 188, 138, 25);
	    			        
	    			        btnAdd.setBounds(24, 265, 100, 25);
	    			        btnUpdate.setBounds(155, 265, 100, 25);
	    			        btnDelete.setBounds(101, 319, 100, 25);
	    			        
	    			        frame.getContentPane().setLayout(null);
	    			        
	    			        // add JTextFields to the jframe
	    			        frame.getContentPane().add(textId);
	    			        frame.getContentPane().add(textFname);
	    			        frame.getContentPane().add(textLname);
	    			        frame.getContentPane().add(textAge);
	    			    
	    			        // add JButtons to the jframe
	    			        frame.getContentPane().add(btnAdd);
	    			        frame.getContentPane().add(btnDelete);
	    			        frame.getContentPane().add(btnUpdate);
	    			        
	    			        JLabel lblNewLabel = new JLabel("Supplier Id");
	    			        lblNewLabel.setBounds(24, 17, 87, 15);
	    			        frame.getContentPane().add(lblNewLabel);
	    			        
	    			        JLabel lblNewLabel_1 = new JLabel("Name");
	    			        lblNewLabel_1.setBounds(24, 70, 100, 15);
	    			        frame.getContentPane().add(lblNewLabel_1);
	    			        
	    			        JLabel lblNewLabel_2 = new JLabel("Address");
	    			        lblNewLabel_2.setBounds(24, 128, 70, 15);
	    			        frame.getContentPane().add(lblNewLabel_2);
	    			        
	    			        JLabel lblNewLabel_3 = new JLabel("Contact");
	    			        lblNewLabel_3.setBounds(24, 193, 70, 15);
	    			        frame.getContentPane().add(lblNewLabel_3);
	    			        
	    			        JScrollPane scrollPane = new JScrollPane();
	    			        scrollPane.setBounds(278, 12, 610, 348);
	    			        frame.getContentPane().add(scrollPane);
	    			        
	    			        
	    			 //   Stable.setModel(new DefaultTableModel(
	    			      //  	new Object[][] {
	    			      //  	},
	    			       // 	new String[] {
	    			        //		"Supplier Id", "Name", "Address", "Contact "
	    			       // 	}
	    			       // ));
	    			       Stable.setSize(new Dimension(600, 350));
	    			        //Stable.setPreferredSize(new Dimension(605, 350));
	    			        scrollPane.setViewportView(Stable);
	    			        
	    			        // create an array of objects to set the row data
	    			        final Object[] row = new Object[5];
	    			        
	    			        // button add row
	    			        btnAdd.addActionListener(new ActionListener(){

	    			            @Override
	    			            public void actionPerformed(ActionEvent e) {
	    			             
	    			                row[0] = textId.getText();
	    			                row[1] = textFname.getText();
	    			                row[2] = textLname.getText();
	    			                row[3] = textAge.getText();
	    			                
	    			                // add row to the model
	    			                model.addRow(row);
 // model.addRow(row); 
	    			                String t1=textId.getText();
	    	               choice.add(t1);
	    	                    	
	    	                    	BufferedWriter writer = null;
	    	                    	 OutputStreamWriter output;
	    	                    	 FileOutputStream filestream;
	    	                    	 BufferedReader br = null;
	    	                    	 
	    	                    	
	    	                DefaultTableModel dtm = (DefaultTableModel) Stable.getModel();
	    	                int nRow = dtm.getRowCount();
	    	                int nCol = dtm.getColumnCount();
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	FileWriter fw = new FileWriter("file1.csv", true);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writer = new BufferedWriter(fw);
	    	              	//   String line;
	    	              //	  int index=0;
	    	              	    
	    	              	//  while ((line = br.readLine()) == null) {
	    	              	    	
	    	              //             if(line==null){
	    	                	

	    	                    //write the header information
	    	                   StringBuffer bufferHeader = new StringBuffer();
	    	                 
	    	                   for (int j =0; j < nCol; j++) {
	    	                      bufferHeader.append(dtm.getColumnName(j));
	    	                        if (j!=nCol) bufferHeader.append(", ");
	    	                    }
	    	                    //writer.write(bufferHeader.toString() + "\r\n");

	    	                   //write row information
	    	                    for (int i = 0 ; i < nRow ; i++){
	    	                         StringBuffer buffer = new StringBuffer();
	    	                        for (int j = 0 ; j < nCol ; j++){
	    	                           buffer.append(dtm.getValueAt(i,j));
	    	                           if (j!=nCol) buffer.append(", ");
	    	                        }
	    	                        writer.write(buffer.toString() + "\r");
	    	                    }}//JOptionPane.showMessageDialog(null,	" File Saved " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e3) {
	    	        			// TODO Auto-generated catch block
	    	        			e3.printStackTrace();
	    	        		} catch (FileNotFoundException e1) {
	    	        			// TODO Auto-generated catch block
	    	        			e1.printStackTrace();
	    	        		} catch (IOException e2) {
	    	        			// TODO Auto-generated catch block
	    	        			e2.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writer.flush();
	    	        				writer.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}
	    			            }
	    	               
	    			            }
	    			        });
	    			        
	    			        // button remove row
	    			        btnDelete.addActionListener(new ActionListener(){

	    			            @Override
	    			            public void actionPerformed(ActionEvent e) {
	    			            
	    			                // i = the index of the selected row
	    			                int i = Stable.getSelectedRow();
	    			                if(i >= 0){
	    			                    // remove a row from jtable
	    			                    model.removeRow(i);
	    			                    
	    			                    choice.remove(i);
		    	                    	BufferedWriter writer = null;
		    	                    	 OutputStreamWriter output;
		    	                    	 FileOutputStream filestream;
		    	                    	 BufferedReader br = null;
		    	                    	 
		    	                    	
		    	                DefaultTableModel dtm = (DefaultTableModel) Stable.getModel();
		    	                int nRow = dtm.getRowCount();
		    	                int nCol = dtm.getColumnCount();
		    	                try {
		    	                	//  br = new BufferedReader(new FileReader("file.csv"));
		    	                	FileWriter fw = new FileWriter("file1.csv", false);
		    	                // BufferedWriter bw = new BufferedWriter(fw);
		    	                	  writer = new BufferedWriter(fw);
		    	              	//   String line;
		    	              //	  int index=0;
		    	              	    
		    	              	//  while ((line = br.readLine()) == null) {
		    	              	    	
		    	              //             if(line==null){
		    	                	

		    	                    //write the header information
		    	                   StringBuffer bufferHeader = new StringBuffer();
		    	                 
		    	                   for (int j =0; j < nCol; j++) {
		    	                      bufferHeader.append(dtm.getColumnName(j));
		    	                        if (j!=nCol) bufferHeader.append(",");
		    	                    }
		    	                    //writer.write(bufferHeader.toString() + "\r\n");

		    	                   //write row information
		    	                    for (int k = 0 ; k < nRow ; k++){
		    	                         StringBuffer buffer = new StringBuffer();
		    	                        for (int j = 0 ; j < nCol ; j++){
		    	                           buffer.append(dtm.getValueAt(k,j));
		    	                           if (j!=nCol) buffer.append(", ");
		    	                        }
		    	                        writer.write(buffer.toString() + "\r");
		    	                    }}//JOptionPane.showMessageDialog(null,	" File Saved " );}
		    	              // index++;line="ll"; }}
		    	                catch (UnsupportedEncodingException e3) {
		    	        			// TODO Auto-generated catch block
		    	        			e3.printStackTrace();
		    	        		} catch (FileNotFoundException e1) {
		    	        			// TODO Auto-generated catch block
		    	        			e1.printStackTrace();
		    	        		} catch (IOException e2) {
		    	        			// TODO Auto-generated catch block
		    	        			e2.printStackTrace();
		    	        		} finally {
		    	                      try {
		    	                    	  //br.close();
		    	        				//writer.close();
		    	        				writer.flush();
		    	        				writer.close();
		    	        			} catch (IOException e4) {
		    	        				// TODO Auto-generated catch block
		    	        				e4.printStackTrace();
		    	        			}
	    			                    
		    	        		} 
		    	               
		              	        	
	    			                }
	    			                else{
	    			                    System.out.println("Delete Error");
	    			                }
	    			            }
	    			        });
	    			        
	    			        // get selected row data From table to textfields 
			    	        Stable.addMouseListener(new MouseAdapter(){
			    	        	 @Override
			    	             public void mouseClicked(MouseEvent e){
			    	            // i = the index of the selected row
			    	            int i = Stable.getSelectedRow();
			    	            //table.changeSelection(i, i, false, false);
			    	            textId.setText(model.getValueAt(i, 0).toString());
			    	            textFname.setText(model.getValueAt(i, 1).toString());
			    	            textLname.setText(model.getValueAt(i, 2).toString());
			    	            textAge.setText(model.getValueAt(i, 3).toString());
			    	          //  textField.setText(model.getValueAt(i, 4).toString());
			    	           /// textField_1.setText(model.getValueAt(i, 5).toString());
			    	          //  textField_2.setText(model.getValueAt(i, 6).toString());
			    	          //  textField_3.setText(model.getValueAt(i, 7).toString());
			    	        }
			    	        });
	    			        
	    			        // button update row
	    			        btnUpdate.addActionListener(new ActionListener(){

	    			            @Override
	    			            public void actionPerformed(ActionEvent e) {
	    			             
	    			                // i = the index of the selected row
	    			                int i = Stable.getSelectedRow();
	    			                
	    			                if(i >= 0) 
	    			                {
	    			                   model.setValueAt(textId.getText(), i, 0);
	    			                   model.setValueAt(textFname.getText(), i, 1);
	    			                   model.setValueAt(textLname.getText(), i, 2);
	    			                   model.setValueAt(textAge.getText(), i, 3);
	    			                   

		    	                    	BufferedWriter writer = null;
		    	                    	 OutputStreamWriter output;
		    	                    	 FileOutputStream filestream;
		    	                    	 BufferedReader br = null;
		    	                    	 
		    	                    	
		    	                DefaultTableModel dtm = (DefaultTableModel) Stable.getModel();
		    	                int nRow = dtm.getRowCount();
		    	                int nCol = dtm.getColumnCount();
		    	                try {
		    	                	//  br = new BufferedReader(new FileReader("file.csv"));
		    	                	FileWriter fw = new FileWriter("file1.csv", true);
		    	                // BufferedWriter bw = new BufferedWriter(fw);
		    	                	  writer = new BufferedWriter(fw);
		    	              	//   String line;
		    	              //	  int index=0;
		    	              	    
		    	              	//  while ((line = br.readLine()) == null) {
		    	              	    	
		    	              //             if(line==null){
		    	                	

		    	                    //write the header information
		    	                	  //writer.write(textField_4.getText());
		    	                	 // writer.newLine();
		    	                	 // writer.write(number.getText());
		    	                	//  writer.newLine();
		    	                   StringBuffer bufferHeader = new StringBuffer();
		    	                 
		    	                   for (int j =0; j < nCol; j++) {
		    	                      bufferHeader.append(dtm.getColumnName(j));
		    	                        if (j!=nCol) bufferHeader.append(",");
		    	                    }
		    	                    //writer.write(bufferHeader.toString() + "\r\n");

		    	                   //write row information
		    	                    for (int l = 0 ; l < nRow ; l++){
		    	                         StringBuffer buffer = new StringBuffer();
		    	                        for (int j = 0 ; j < nCol ; j++){
		    	                           buffer.append(dtm.getValueAt(l,j));
		    	                           if (j!=nCol) buffer.append(",");
		    	                        }
		    	                        writer.write(buffer.toString() + "\r");
		    	                    }}//JOptionPane.showMessageDialog(null,	" File Saved " );}
		    	              // index++;line="ll"; }}
		    	                catch (UnsupportedEncodingException e3) {
		    	        			// TODO Auto-generated catch block
		    	        			e3.printStackTrace();
		    	        		} catch (FileNotFoundException e1) {
		    	        			// TODO Auto-generated catch block
		    	        			e1.printStackTrace();
		    	        		} catch (IOException e2) {
		    	        			// TODO Auto-generated catch block
		    	        			e2.printStackTrace();
		    	        		} finally {
		    	                      try {
		    	                    	  //br.close();
		    	        				//writer.close();
		    	        				writer.flush();
		    	        				writer.close();
		    	        			} catch (IOException e4) {
		    	        				// TODO Auto-generated catch block
		    	        				e4.printStackTrace();
		    	        			}}
		    	                try {
		     	    				
		   	                	  BufferedReader br1 = new BufferedReader(new FileReader("file1.csv"));
		   	                	    String line = null;
		   	                	   
		   	                	    @SuppressWarnings("rawtypes")
		   	                		Vector myVec = new Vector();
		   	                	    while ((line = br1.readLine()) != null) {
		   	                	    	// if(index == 0) {
		   	                           //      index++;
		   	                           //      continue; //skip first line
		   	                           //   }
		   	                	      String[] values = line.split(",");
		   	                	      int m=0;
		   	                	     int index=0;
		   	                	    for ( String str : values) {
		   	                	    	 
		   	                	    	 if(index == 0) {        	    	                 	    	 
		   	                	    //   row[m] = values;
		   	                	     // Object[]  row1 = (Object[])  row[m];
		   	                	    	// str= myVec.add(row1);
		   	                	    	choice.add(str);
		   	                	        //  model.addRow(row1);
		   	                	    	 
		   	                	    	 }
		   	                	    	else{
		   	                	    		 continue;
		   	                	    	 }
		   	                	    	index++;
		   	                	    	 //  System.out.println(row1);
		   	                	  }
		   	                	     // i++; 
		   	                	    } 
		   	                	    //}
		   	                	    br1.close();
		   	                	  
		   	                } catch (IOException ex) {
		   	                    System.out.println(ex.getMessage());
		   	                    ex.printStackTrace();
		   	                }
		              	        	  
	    			                }
	    			                else{
	    			                	 System.out.println("Update Error");
	    			                }
	    			            }
	    			        });
	    			        
	    			        frame.setSize(900,400);
	    			        frame.setLocationRelativeTo(null);
	    			        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    			        frame.setVisible(true);
	    				}
	    				}		);
	    				
	    			
					panel.add(lblTotalPrice);
	    			frmStockOrder.setVisible(true);
	    			
	    			btnAdd1.addActionListener(new ActionListener()
	    			{
	    				public void actionPerformed(ActionEvent e)
	    				{
	    					// create JFrame and JTable
	    			        frameA = new JFrame();
	    			        
	    			        // create a table model and set a Column Identifiers to this model 
	    			       // Object[] columns = {"Supplier Id", "Name", "Address", "Contact "};
	    			       // final DefaultTableModel model = new DefaultTableModel();
	    			       // model.setColumnIdentifiers(columns);
	    			        Font font = new Font("",1,22);
	    			        frameA.setVisible(true);
	    			        // create JButtons
	    			        try {
								BufferedImage buttonIcon = ImageIO.read(new File("contact_icons.png"));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	    			        
	    			        // create an array of objects to set the row data
	    			        final Object[] row = new Object[8];
	    			        
	    			        frameA.setSize(471,384);
	    			        frameA.setLocationRelativeTo(null);
	    			        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    			        
	    			        JPanel panel = new JPanel();
	    			        frameA.getContentPane().add(panel, BorderLayout.CENTER);
	    			        panel.setLayout(null);
	    			        
	    			        JLabel lblQ = new JLabel("Quantity:");
	    			        lblQ.setBounds(43, 22, 70, 15);
	    			        panel.add(lblQ);
	    			        
	    			        textFieldQ = new JTextField();
	    			        textFieldQ.setBounds(169, 20, 197, 19);
	    			        panel.add(textFieldQ);
	    			        textFieldQ.setColumns(10);
	    			        
	    			        JLabel lblItem = new JLabel("item:");
	    			        lblItem.setBounds(43, 75, 70, 15);
	    			        panel.add(lblItem);
	    			        
	    			        JLabel lblDescription = new JLabel("Description");
	    			        lblDescription.setBounds(43, 143, 81, 15);
	    			        panel.add(lblDescription);
	    			        
	    			        final JComboBox comboBox = new JComboBox();
	    			        comboBox.setBounds(169, 70, 197, 24);
	    			        panel.add(comboBox);
	    			        
	    			        final JTextArea textArea1 = new JTextArea();
	    			        textArea1.setBounds(169, 143, 197, 68);
	    			        panel.add(textArea1);
	    			        
	    			        JLabel lblNewLtaxabel = new JLabel("Tax:");
	    			        lblNewLtaxabel.setBounds(43, 231, 70, 15);
	    			        panel.add(lblNewLtaxabel);
	    			        
	    			        textFieldT = new JTextField();
	    			        textFieldT.setBounds(169, 229, 207, 19);
	    			        panel.add(textFieldT);
	    			        textFieldT.setColumns(10);
	    			        
	    			        JLabel lblUnitValue = new JLabel("Unit Value:");
	    			        lblUnitValue.setBounds(43, 268, 81, 15);
	    			        panel.add(lblUnitValue);
	    			        
	    			        textFieldU = new JTextField();
	    			        textFieldU.setBounds(169, 260, 207, 19);
	    			        panel.add(textFieldU);
	    			        textFieldU.setColumns(10);
	    			        
	    			        JButton btnCancel1 = new JButton("Cancel");
	    			        btnCancel1.setBounds(94, 319, 117, 25);
	    			        panel.add(btnCancel1);
	    			        
	    			        JButton btnOk = new JButton("OK");
	    			        btnOk.setBounds(249, 319, 117, 25);
	    			        panel.add(btnOk);
	    			     //   frameA.setVisible(true);
	    			        
	    			        comboBox.addItem("Select Item ");
	    			        try {
	     	    				
	   	                	  BufferedReader br1 = new BufferedReader(new FileReader("itemslist.csv"));
	   	                	    String line = null;
	   	                	   
	   	                	    @SuppressWarnings("rawtypes")
	   	                		Vector myVec = new Vector();
	   	                	    while ((line = br1.readLine()) != null) {
	   	                	    	// if(index == 0) {
	   	                           //      index++;
	   	                           //      continue; //skip first line
	   	                           //   }
	   	                	      String[] values = line.split(",");
	   	                	      int i=0;
	   	                	     int index=0;
	   	                	    for ( String str : values) {
	   	                	    	 
	   	                	    	 if(index == 0) {        	    	                 	    	 
	   	                	      // row[i] = values;
	   	                	     // Object  row1 = (Object)  row[i];
	   	                	    	// str= myVec.add(str);
	   	                	    	comboBox.addItem(str);
	   	                	        //  model.addRow(row1);
	   	                	    	 
	   	                	    	 }
	   	                	    	else{
	   	                	    		 continue;
	   	                	    	 }
	   	                	    	index++;
	   	                	    	 //  System.out.println(row1);
	   	                	  }
	   	                	     // i++; 
	   	                	    } 
	   	                	    //}
	   	                	    br1.close();
	   	                	  
	   	                } catch (IOException ex) {
	   	                    System.out.println(ex.getMessage());
	   	                    ex.printStackTrace();
	   	                } 
	    			        final Object findvalue=comboBox.getSelectedItem();
	    			    	comboBox.addActionListener(new ActionListener()
	    	    			{
	    	    				public void actionPerformed(ActionEvent e)
	    	    				{
	    	    					 JComboBox cb = (JComboBox)e.getSource();
	    	    				        String petName = (String)cb.getSelectedItem();
	    			      
	    			    	for(int i = 0; i < table.getRowCount(); i++){//For each row
    	            	        for(int j = 0; j < table.getColumnCount(); j++){//For each column in that row
    	            	            if(model.getValueAt(i, 0).equals(petName)){//Search the model
    	            	                //System.out.println(table.getModel().getValueAt(i, j));//Print if found string
    	            	               // System.out.println("Search found");
    	            	            	//table.changeSelection(i, j, true, false);
    	            	            	textFieldT.setText(model.getValueAt(i, 3).toString());
    	            	            	textFieldU.setText(model.getValueAt(i, 5).toString());
    	            	            	
    	            	            	textArea1.setText(model.getValueAt(i, 1).toString());
    	            	            	
    	            	              // JOptionPane.showMessageDialog(null,	" Search Item is found " );
    	            	           
    	            	            }
    	            	           
    	            	    }
    	            		
    	            	}
	    	    				}
	    	    			});
	    				
	    			    	btnOk.addActionListener(new ActionListener()
	    	    			{
	    	    				public void actionPerformed(ActionEvent e)
	    	    				{
	    	    					 age = Integer.parseInt(textFieldQ.getText().toString());
	    	 	    	    	    age1 = Integer.parseInt(textFieldU.getText().toString());
	    	 	    	    	   prod+=age*age1;
	    	 	    	    	  prod1=age*age1;
	    	    					String a=String.valueOf(prod1);
	    	    					String c=String.valueOf(prod);
	    	    	   row[0]=textFieldQ.getText();
	    	    	   row[1]=comboBox.getSelectedItem();
	    	    	   row[2]=textArea1.getText();
	    	    	   row[3]=textFieldT.getText();
	    	    	   row[4]=textFieldU.getText();
	    	    	   row[5]=a;
	    	    	   model1.addRow(row);
	    	    	   
	    	    	 // System.out.println(prod);
	    	    	  String.valueOf(prod);
	    	    	  
	    	    	  textArea_3.setText(""+c);
	    	    	   
	    	    	    }
	    	    			});
	    			    	btnCancel1.addActionListener(new ActionListener()
	    	    			{
	    	    				public void actionPerformed(ActionEvent e)
	    	    				{
	    	    					frameA.dispose();
	    	    				}
	    	    			});
	    				}
	    			});
	    			btnRecordAndPrint.addActionListener(new ActionListener(){
    		        	

    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            	BufferedWriter writers = null;
	                    	 OutputStreamWriter output;
	                    	 FileOutputStream filestream;
	                    	 BufferedReader br = null;
	                    	 
    		             	
	    	                DefaultTableModel dtms = (DefaultTableModel) table1.getModel();
	    	                int nRow = dtms.getRowCount();
	    	                int nCol = dtms.getColumnCount();
	    	                int nextValue1 = counter.getAndIncrement();
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	FileWriter fw = new FileWriter("ordereditems.csv", true);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writers = new BufferedWriter(fw);
	    	              	//   String line;
	    	              //	  int index=0;
	    	              	    
	    	              	//  while ((line = br.readLine()) == null) {
	    	              	    	
	    	              //             if(line==null){
	    	                	
	    	                	 // writers.write(choice.getSelectedItem()+",");
	    	                	  
	    	                	 // writer.write(number.getText());
	    	                	//  writer.newLine();
	    	                	 
	    	                	 // writers.write(nextValue1 +",");
	    	                   StringBuffer bufferHeader = new StringBuffer();
	    	                 
	    	                   for (int j =0; j < nCol; j++) {
	    	                      bufferHeader.append(dtms.getColumnName(j));
	    	                        if (j!=nCol) bufferHeader.append(",");
	    	                    }
	    	                   //writers.write(bufferHeader.toString() + "\r\n");

	    	                   //write row information
	    	                    for (int l = 0 ; l < nRow ; l++){
	    	                         StringBuffer buffer = new StringBuffer();
	    	                        for (int j = 0 ; j < nCol ; j++){
	    	                           buffer.append(dtms.getValueAt(l,j));
	    	                           if (j!=nCol) buffer.append(",");
	    	                        }
	    	                     ///   
	    	                        writers.write(textField_5.getText()+"-"+nextValue1 +",");
	    	                     
	    	                        writers.write(buffer.toString() + "\r");
	    	                       
	    	                    }
	    	                    //writers.write(choice.getSelectedItem());
	    	                   // writers.newLine();
	    	                	
	    	                	  
	    	                	 // writer.write(number.getText());
	    	                
	    	                   
	    	                JOptionPane.showMessageDialog(null,	" File Saved " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e3) {
	    	        			// TODO Auto-generated catch block
	    	        			e3.printStackTrace();
	    	        		} catch (FileNotFoundException e1) {
	    	        			// TODO Auto-generated catch block
	    	        			e1.printStackTrace();
	    	        		} catch (IOException e2) {
	    	        			// TODO Auto-generated catch block
	    	        			e2.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writers.flush();
	    	        				writers.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}}
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	FileWriter fw = new FileWriter("orderid.csv", true);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writers = new BufferedWriter(fw);
	    	              	
	    	                        writers.write(textField_5.getText()+"-"+nextValue1 );
	    	                     
	    	                        writers.newLine();
	    	                       
	    	                    }
	    	                    //writers.write(choice.getSelectedItem());
	    	                   // writers.newLine();
	    	                	
	    	                	  
	    	                	 // writer.write(number.getText());
	    	                
	    	                   
	    	             //JOptionPane.showMessageDialog(null,	" File Saved " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e4) {
	    	        			// TODO Auto-generated catch block
	    	        			e4.printStackTrace();
	    	        		} catch (FileNotFoundException e4) {
	    	        			// TODO Auto-generated catch block
	    	        			e4.printStackTrace();
	    	        		} catch (IOException e4) {
	    	        			// TODO Auto-generated catch block
	    	        			e4.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writers.flush();
	    	        				writers.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}}
	    	                try {
	    	                	//  br = new BufferedReader(new FileReader("file.csv"));
	    	                	FileWriter fw = new FileWriter("stock_order_print.csv", false);
	    	                // BufferedWriter bw = new BufferedWriter(fw);
	    	                	  writers = new BufferedWriter(fw);
	    	              	//   String line;
	    	              //	  int index=0;
	    	              	    
	    	              	//  while ((line = br.readLine()) == null) {
	    	              	    	
	    	              //             if(line==null){
	    	                	

	    	                    //write the header information
	    	                	 
	    	                	  
	    	                	  writers.write("ISSUE DATE:\t"+textField_5.getText());
	    	                	  writers.newLine();
	    	                	  
	    	                	 // writers.write();
	    	                	//  writers.newLine();
	    	                	  writers.newLine();
	    	                	  writers.write("RETURN DATE:\t"+textField_4.getText());
	    	                	 // writers.newLine();
	    	                	 // writers.write();
	    	                	  writers.newLine();
	    	                	  writers.newLine();
	    	                	  writers.write("BILLING ADDRESS:\t"+txtrBilladdress.getText());
	    	                	 // writers.newLine();
	    	                	 // writers.write();
	    	                	  writers.newLine();
	    	                	  writers.newLine();
	    	                	  writers.write("STOCK ORDER LIST");
	    	                	  writers.newLine();
	    	                	  
	    	                	 // writer.write(number.getText());
	    	                	//  writer.newLine();
	    	                   StringBuffer bufferHeader = new StringBuffer();
	    	                 
	    	                   for (int j =0; j < nCol; j++) {
	    	                      bufferHeader.append(dtms.getColumnName(j));
	    	                        if (j!=nCol) bufferHeader.append(",");
	    	                    }
	    	                   writers.write(bufferHeader.toString() + "\r\n");

	    	                   //write row information
	    	                    for (int l = 0 ; l < nRow ; l++){
	    	                         StringBuffer buffer = new StringBuffer();
	    	                        for (int j = 0 ; j < nCol ; j++){
	    	                           buffer.append(dtms.getValueAt(l,j));
	    	                           if (j!=nCol) buffer.append(",");
	    	                        }
	    	                        writers.write(buffer.toString() + "\r");
	    	                    }
	    	                    writers.write(" ");
	    	                    writers.newLine();
	    	                    writers.write("ORDER NOTES :\t"+textArea_1.getText());
								 writers.newLine();
			    	              
	    	                	 // writers.write();
	    	                	 // writers.newLine();  
	    	                	  writers.newLine();
	    	                	  writers.write("TOTAL PRICE:\t"+textArea_3.getText());
	    	                	 // writers.write();
	    	                	  writers.newLine();
	    	                	  writers.newLine();
	    	                	  writers.write("TRACKING ID:\t"+textField_8.getText());
	    	                	//  writers.newLine();
	    	                	                   	  
	    	                	  //writers.write(textField_8.getText());
	    	                	
	    	               JOptionPane.showMessageDialog(null,	"file saved to print :stock_order_print.csv " );}
	    	              // index++;line="ll"; }}
	    	                catch (UnsupportedEncodingException e3) {
	    	        			// TODO Auto-generated catch block
	    	        			e3.printStackTrace();
	    	        		} catch (FileNotFoundException e1) {
	    	        			// TODO Auto-generated catch block
	    	        			e1.printStackTrace();
	    	        		} catch (IOException e2) {
	    	        			// TODO Auto-generated catch block
	    	        			e2.printStackTrace();
	    	        		} finally {
	    	                      try {
	    	                    	  //br.close();
	    	        				//writer.close();
	    	        				writers.flush();
	    	        				writers.close();
	    	        			} catch (IOException e4) {
	    	        				// TODO Auto-generated catch block
	    	        				e4.printStackTrace();
	    	        			}
	    	                     
	    	                	         
	    	        		}
    		            }
	    			});
	    			btnRemove.addActionListener(new ActionListener(){
    		        	

    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            
    		                // i = the index of the selected row
    		                int i = table1.getSelectedRow();
    		                if(i >= 0){
    		                    // remove a row from table
    		                	 age = Integer.parseInt(table1.getModel().getValueAt(i, 0).toString());
    			    	    	    age1 = Integer.parseInt(table1.getModel().getValueAt(i, 4).toString());
    			    	    	 int  prod1=age*age1;
    		                //	 Hint c=Integer.parseInt(table1.getModel().getValueAt(i, 4).toString());
     		                  //  System.out.println(c);
     		                    prod-=prod1;
     		                    String.valueOf(prod);
     			    	    	  String a=String.valueOf(prod);
     			    	    	  textArea_3.setText("\n\n"+a);
    		                    model1.removeRow(i);
    		              
    		                   
    		                }
    		                else{
    		                    System.out.println("Delete Error");
    		                }
    		            }
    		        });
	    			btnCancel.addActionListener(new ActionListener()
	    			{
	    				public void actionPerformed(ActionEvent e)
	    				{
	    					frmStockOrder.dispose();
	    				}
	    			});
	    			
	    		}
	    	    if(selectedNodeName=="View Orders"){
	    	    	// create JFrame and JTable
	    	        final JFrame recframe = new JFrame();
	    	        
	    	        // create a table model and set a Column Identifiers to this model 
	    	       Object[] columns = {"order-id","Quantity", "Item", "Description", "Tax", "Unit value", "Line Total"};
	    	        final DefaultTableModel model1 = new DefaultTableModel();
	    	        model1.setColumnIdentifiers(columns);
	    	        
	    	        Font font = new Font("",1,22);
	    	        
	    	        // create JButtons
	    	       // BufferedImage buttonIcon = ImageIO.read(new File("contact_icons.png"));
	    	        
	    	        // create an array of objects to set the row data
	    	        final Object[] row = new Object[4];
	    	        
	    	        recframe.setSize(575,384);
	    	        recframe.setLocationRelativeTo(null);
	    	        
	    	        JPanel panelsv = new JPanel();
	    	        recframe.getContentPane().add(panelsv, BorderLayout.CENTER);
	    	        panelsv.setLayout(null);
	    	        
	    	        JButton btnPrint = new JButton("print");
	    	       btnPrint.setBounds(121, 319, 130, 25);
	    	        panelsv.add(btnPrint);
	    	        
	    	        final JButton btnCancelsv = new JButton("cancel");
	    	        btnCancelsv.setBounds(326, 319, 117, 25);
	    	        panelsv.add(btnCancelsv);
	    	        
	    	        JScrollPane scrollPanesv = new JScrollPane();
	    	        scrollPanesv.setBounds(12, 12, 551, 282);
	    	        panelsv.add(scrollPanesv);
	    	        
	    	        rectable = new JTable();
	    	        rectable.setModel(model1);
	    	        //.getColumn("order-id").setPreferredWidth(0);
	    	      //  rectable.getColumn("order-id").setMinWidth(0);
	    	       //rectable.getColumn("order-id").setWidth(0);
	    	       // rectable.getColumn("order-id").setMaxWidth(0);
	    	        
	    	        //final DefaultTableModel model1 = new DefaultTableModel();
	    	       // rectable.setModel(new DefaultTableModel(
	    	       // 	new Object[][] {
	    	       // 	},
	    	       // 	new String[] {
	    	       // 			"Quantity", "Item", "Description", "Tax", "Unit value", "Line Total", "Measure"
	    	       // 	}
	    	       // ));
	    	        scrollPanesv.setViewportView(rectable);
	    	        recframe.setVisible(true);
	    	        
	    	        
	    	        try {
 	    				
 	                	  BufferedReader br1 = new BufferedReader(new FileReader("ordereditems.csv"));
 	                	    String line = null;
 	                	    
 	                	   
 	                	   // @SuppressWarnings("rawtypes")
 	                		//Vector myVec = new Vector();
 	                	    while ((line = br1.readLine()) != null) {
 	                	    	
	    	                	    	// if(index == 0) {
	    	                              //   index++;
	    	                                // continue; //skip first line
	    	                         //     }
	    	                	      String[] values = line.split(",");
	    	                	      int i=1;
	    	                	    
	    	                	    //for ( String str : values) {
	    	                	    	 
	    	                	    	  
	    	                	    		 
	    	                	       row[i] = values;
	    	                	       Object[]  row1 = (Object[])  row[i];
	    	                	    	// str= myVec.add(str);
	    	                	       
	    	                	          model1.addRow(row1);
	    	                	          
	    	                	             
	    	                	    	 
	    	                	    		  //System.out.println(row1);
	    	                	  //  }
	    	                	          
	    	                	      i++; 
	    	                	    }
	    	                	    
 	                	     // i++; 
 	                	    
 	                	    //}
 	                	    br1.close();
 	                	  
 	                } catch (IOException ex) {
 	                    System.out.println(ex.getMessage());
 	                    ex.printStackTrace();
 	                }
	    	        btnCancelsv.addActionListener(new ActionListener(){

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	recframe.dispose();
			            }
	    	        });
	    	        btnPrint.addActionListener(new ActionListener() {
	    	            public void actionPerformed(ActionEvent evt) {
	    	            	
	    	            	BufferedWriter writer = null;
	    	            	 OutputStreamWriter output;
	    	            	 FileOutputStream filestream;
	    	            	 BufferedReader br = null;
	    	            	 
	    	            	
	    	        DefaultTableModel dtm = (DefaultTableModel) rectable.getModel();
	    	        int nRow = dtm.getRowCount();
	    	        int nCol = dtm.getColumnCount();
	    	        try {
	    	        	//  br = new BufferedReader(new FileReader("file.csv"));
	    	        	FileWriter fw = new FileWriter("orderstocklist.csv", true);
	    	        // BufferedWriter bw = new BufferedWriter(fw);
	    	        	  writer = new BufferedWriter(fw);
	    	      	//   String line;
	    	      //	  int index=0;
	    	      	    
	    	      	//  while ((line = br.readLine()) == null) {
	    	      	    	
	    	      //             if(line==null){
	    	        	

	    	            //write the header information
	    	           StringBuffer bufferHeader = new StringBuffer();
	    	         
	    	           for (int j =0; j < nCol; j++) {
	    	              bufferHeader.append(dtm.getColumnName(j));
	    	                if (j!=nCol) bufferHeader.append(", ");
	    	            }
	    	           writer.write(bufferHeader.toString() + "\r\n");

	    	           //write row information
	    	            for (int i = 0 ; i < nRow ; i++){
	    	                 StringBuffer buffer = new StringBuffer();
	    	                for (int j = 0 ; j < nCol ; j++){
	    	                   buffer.append(dtm.getValueAt(i,j));
	    	                   if (j!=nCol) buffer.append(", ");
	    	                }
	    	                writer.write(buffer.toString() + "\r");
	    	            }JOptionPane.showMessageDialog(null,"File Saved to print : orderstocklist.csv");}
	    	      // index++;line="ll"; }}
	    	        catch (UnsupportedEncodingException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			} catch (FileNotFoundException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			} finally {
	    	              try {
	    	            	  //br.close();
	    					//writer.close();
	    					writer.flush();
	    					writer.close();
	    				} catch (IOException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    	              btnCancelsv.addActionListener(new ActionListener(){

	  						@Override
	  						public void actionPerformed(ActionEvent e) {
	  							recframe.dispose();
	  							
	  						}
	      	            	  
	      	              }
	      	              ); 
	    	        }
	    	       
	    	            }
	    	        });
	    	    }
	    	    if(selectedNodeName=="Receive Stock"){
	    	    	 // create JFrame and JTable
	    	        final JFrame recframe = new JFrame();
	    	        
	    	       
	    	        // create an array of objects to set the row data
	    	        final Object[] row = new Object[10];
	    	        
	    	        recframe.setSize(666,384);
	    	        recframe.setLocationRelativeTo(null);
	    	        
	    	        JPanel panel = new JPanel();
	    	        recframe.getContentPane().add(panel, BorderLayout.CENTER);
	    	        panel.setLayout(null);
	    	        
	    	        JButton btnPrint = new JButton("Partial Received");
	    	        btnPrint.setBounds(375, 319, 150, 25);
	    	        panel.add(btnPrint);
	    	        
	    	        JButton btnCancel = new JButton("Cancel");
	    	        btnCancel.setBounds(537, 319, 117, 25);
	    	        panel.add(btnCancel);
	    	        
	    	        JButton btnOk = new JButton("Select");
	    	        btnOk.setBounds(340, 65, 117, 25);
	    	        panel.add(btnOk);
	    	        
	    	        JButton btnReceived = new JButton("Fully Received");
	    	        btnReceived.setBounds(200, 319, 150, 25);
	    	        panel.add(btnReceived);
	    	        
	    	        JScrollPane scrollPane = new JScrollPane();
	    	        scrollPane.setBounds(12, 102, 642, 178);
	    	        panel.add(scrollPane);
	    	        
	    	        rectable1 = new JTable();
	    	        final Object[] columns = {"order-id","Quantity", "Item", "Description", "Tax", "Unit value", "Line Total"};
	    	        final DefaultTableModel modelrec = new DefaultTableModel();
	    	        modelrec.setColumnIdentifiers(columns);
	    	        scrollPane.setViewportView(rectable1);
	    	        rectable1.setModel(modelrec);
	    	        
	    	       
	    	        
	    	        JLabel lblPurchaseOrder = new JLabel("Purchase Order:");
	    	        lblPurchaseOrder.setBounds(12, 12, 161, 15);
	    	        panel.add(lblPurchaseOrder);

	    	        final JComboBox comboBox = new JComboBox();
	    	        comboBox.setBounds(157, 7, 217, 24);
	    	        panel.add(comboBox);
	    	      
	    	      
	    	       
	    	      JButton btnAdd1 = new JButton("Add");
	    	      btnAdd1.setBounds(22, 282, 81, 25);
	    	      //  panel.add(btnAdd1);
	    	        
	    	        JButton btndel= new JButton("Delete");
	    	        btndel.setBounds(128, 282, 81, 25);
	    	        panel.add(btndel);
	    	        
	    	       JButton btnEdit = new JButton("Edit");
	    	     //   btnEdit.setBounds(237, 282, 81, 25);
	    	     //   panel.add(btnEdit);
	    	        final JTextField textFieldr = new JTextField();
	    	        final JTextField  textField_1r= new JTextField();
	    	        final JTextField textField_2r = new JTextField();
	    	        final JTextField textField_3r = new JTextField();
	    	        final JTextField textField_4r = new JTextField();
	    	        final JTextField textField_5r = new JTextField();
			        // create JTextFields
			        final JTextField textIdr = new JTextField();
			      //  textIdr.setToolTipText("Enter Item");
			        final JTextField textFnamer = new JTextField();
			       // textFnamer.setToolTipText("Enter Description");
			        final JTextField textLnamer = new JTextField();
			      //  textLnamer.setToolTipText("Enter Tax");
			        final JTextField textAger = new JTextField();
			       // textAger.setToolTipText("Enter Category");
			        
			        
	    	       
	    	        recframe.setVisible(true);
	    	        comboBox.addItem("please select order id");
	    	        try {
 	    				
	                	  BufferedReader br1 = new BufferedReader(new FileReader("orderid.csv"));
	                	    String line = null;
	                	    
	                	   
	                	   // @SuppressWarnings("rawtypes")
	                		//Vector myVec = new Vector();
	                	    while ((line = br1.readLine()) != null) {
	                	    	
	    	                	    	// if(index == 0) {
	    	                              //   index++;
	    	                                // continue; //skip first line
	    	                         //     }
	    	                	      String[] values = line.split(",");
	    	                	      int i=1;
	    	                	    
	    	                	    //for ( String str : values) {
	    	                	    	 
	    	                	    	  
	    	                	    		 
	    	                	       row[i] = values;
	    	                	       Object[]  row1 = (Object[])  row[i];
	    	                	    	// str= myVec.add(str);
	    	                	      Object item = comboBox.getItemAt(0);
	    	                	      
	    	                	       
	    	                	       
	    	 	                	    	 comboBox.addItem(row1[0]);
	    	 	                	  
	    	                	   //      
	    	                	    	 
	    	                	    		 // System.out.println(row1[0]);
	    	                	  //  }
	    	                	          
	    	                	      i++; 
	    	                	    }
	    	                	    
	                	     // i++; 
	                	    
	                	    //}
	                	    br1.close();
	                	   
	                	 
	                	  
	                } catch (IOException ex) {
	                    System.out.println(ex.getMessage());
	                    ex.printStackTrace();
	                }
	    	        
	    	        btnOk.addActionListener(new ActionListener(){

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	if(rectable1.getRowCount()==0){
			            	//	rectable1.removeRowSelectionInterval(0, rectable1.getRowCount()-1);
			            	
			            	   try {
			            		 //  rectable1.removeRowSelectionInterval(0, rectable1.getRowCount()-1);
			 	                	  BufferedReader br1 = new BufferedReader(new FileReader("ordereditems.csv"));
			 	                	    String line = null;
			 	                	    
			 	                	   
			 	                	   // @SuppressWarnings("rawtypes")
			 	                		//Vector myVec = new Vector();
			 	                	    while ((line = br1.readLine()) != null) {
			 	                	    	
				    	                	    	// if(index == 0) {
				    	                              //   index++;
				    	                                // continue; //skip first line
				    	                         //     }
				    	                	      String[] values = line.split(",");
				    	                	      int i=1;
				    	                	    
				    	                	    //for ( String str : values) {
				    	                	    	 
				    	                	    	  
				    	                	    		 
				    	                	       row[i] = values;
				    	                	       Object[]  row1 = (Object[])  row[i];
				    	                	    	// str= myVec.add(str);
				    	                	      if(row1[0].equals(comboBox.getSelectedItem())){
				    	                	       
				    	                	       modelrec.addRow(row1);}
				    	                	       else{
				    	                	   	   continue;
				    	                	      }
				    	                	   //      
				    	                	    	 
				    	                	    		 // System.out.println(row1[0]);
				    	                	  //  }
				    	                	          
				    	                	      i++; 
				    	                	    }
				    	                	    
			 	                	     // i++; 
			 	                	    
			 	                	    //}
			 	                	    br1.close();
			 	                	  
			 	                } catch (IOException ex) {
			 	                    System.out.println(ex.getMessage());
			 	                    ex.printStackTrace();
			 	                }
			            	}
			            	else{
			            		modelrec.getDataVector().removeAllElements();
			            	   try {
			            		  // rectable1.removeRowSelectionInterval(0, rectable1.getRowCount()-1);
			 	                	  BufferedReader br1 = new BufferedReader(new FileReader("ordereditems.csv"));
			 	                	    String line = null;
			 	                	    
			 	                	   
			 	                	   // @SuppressWarnings("rawtypes")
			 	                		//Vector myVec = new Vector();
			 	                	    while ((line = br1.readLine()) != null) {
			 	                	    	
				    	                	    	// if(index == 0) {
				    	                              //   index++;
				    	                                // continue; //skip first line
				    	                         //     }
				    	                	      String[] values = line.split(",");
				    	                	      int i=1;
				    	                	    
				    	                	    //for ( String str : values) {
				    	                	    	 
				    	                	    	  
				    	                	    		 
				    	                	       row[i] = values;
				    	                	       Object[]  row1 = (Object[])  row[i];
				    	                	    	// str= myVec.add(str);
				    	                	      if(row1[0].equals(comboBox.getSelectedItem())){
				    	                	       
				    	                	       modelrec.addRow(row1);}
				    	                	       else{
				    	                	   	   continue;
				    	                	      }
				    	                	   //      
				    	                	    	 
				    	                	    		 // System.out.println(row1[0]);
				    	                	  //  }
				    	                	          
				    	                	      i++; 
				    	                	    }
				    	                	    
			 	                	     // i++; 
			 	                	    
			 	                	    //}
			 	                	    br1.close();
			 	                	  
			 	                } catch (IOException ex) {
			 	                    System.out.println(ex.getMessage());
			 	                    ex.printStackTrace();
			 	                }
			            	}
			            }
			            
	    	        });
	    	       
	    	        btnCancel.addActionListener(new ActionListener(){

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	recframe.dispose();
			            }
	    	        });
	    	       
	    	        btnReceived.addActionListener(new ActionListener(){

			            @Override
			            public void actionPerformed(ActionEvent e) {

	    	            	BufferedWriter writer = null;
	    	            	 OutputStreamWriter output;
	    	            	 FileOutputStream filestream;
	    	            	 BufferedReader br = null;
	    	            	 
	    	            	
	    	        DefaultTableModel dtm = (DefaultTableModel) rectable1.getModel();
	    	        int nRow = dtm.getRowCount();
	    	        int nCol = dtm.getColumnCount();
	    	       
	    	       
	    	        int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
	    	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    	        if (response == JOptionPane.NO_OPTION) {
	    	        	System.out.println("No button clicked");
	    	        }
	    	        else if (response == JOptionPane.CLOSED_OPTION) {
	    	            System.out.println("JOptionPane closed");
	    	          }
	    	        else if (response == JOptionPane.YES_OPTION) {
	    	        	 
		    	        try {
		    	        	//  br = new BufferedReader(new FileReader("file.csv"));
		    	        	FileWriter fw = new FileWriter("orderid.csv", false);
		    	        // BufferedWriter bw = new BufferedWriter(fw);
		    	        	  writer = new BufferedWriter(fw);
		    	      	//   String line;
		    	      //	  int index=0;
		    	      	    
		    	      	//  while ((line = br.readLine()) == null) {
		    	      	    	
		    	      //             if(line==null){
		    	        	

		    	            //write the header information
		    	        	   
		    	        	  
		    	        	for(int i=1;i<comboBox.getItemCount();i++)
		    	        		if(comboBox.getItemAt(i)==comboBox.getSelectedItem())
		    	        	 		    	        	   
		    	        	    	continue;
		    	        		else{
		    	        			
		    	        			writer.write( comboBox.getItemAt(i).toString());
		    	        			 writer.newLine();
		    	        		}
		                	  
		                	 // writers.write();
		                	//  writers.newLine();
		                	 // writer.newLine();
		                	//  writer.write("Purchase Order id\t"+comboBox.getSelectedItem());
		                	 // writers.newLine();
		                	 // writers.write();
		                	 
		                	//  writer.newLine();
		                	  
		                	 
		    	          JOptionPane.showMessageDialog(null,"Item Fully Received" );}	
		    	        catch (UnsupportedEncodingException e1) {
		    				// TODO Auto-generated catch block
		    				e1.printStackTrace();
		    			} catch (FileNotFoundException e1) {
		    				// TODO Auto-generated catch block
		    				e1.printStackTrace();
		    			} catch (IOException e1) {
		    				// TODO Auto-generated catch block
		    				e1.printStackTrace();
		    			} finally {
		    	              try {
		    	            	  //br.close();
		    					//writer.close();
		    					writer.flush();
		    					writer.close();
		    				} catch (IOException e1) {
		    					// TODO Auto-generated catch block
		    					e1.printStackTrace();
		    				}
		    			}
		    	    	
	        try {
	        	//  br = new BufferedReader(new FileReader("file.csv"));
	        	FileWriter fw = new FileWriter("ReceivedStock.csv", false);
	        // BufferedWriter bw = new BufferedWriter(fw);
	        	  writer = new BufferedWriter(fw);
	      	//   String line;
	      //	  int index=0;
	      	    
	      	//  while ((line = br.readLine()) == null) {
	      	    	
	      //             if(line==null){
	        	

	            //write the header information
	        	   
	        	  
	        	
           	  
           	 // writers.write();
           	//  writers.newLine();
           	  writer.newLine();
           	  writer.write("Purchase Order id\t"+comboBox.getSelectedItem());
           	 // writers.newLine();
           	 // writers.write();
           	  writer.newLine();
           	  writer.newLine();
           	 
	           StringBuffer bufferHeader = new StringBuffer();
	         
	           for (int j =0; j < nCol; j++) {
	              bufferHeader.append(dtm.getColumnName(j));
	                if (j!=nCol) bufferHeader.append(", ");
	            }
	           writer.write(bufferHeader.toString() + "\r\n");

	           //write row information
	            for (int i = 0 ; i < nRow ; i++){
	                 StringBuffer buffer = new StringBuffer();
	                for (int j = 0 ; j < nCol ; j++){
	                   buffer.append(dtm.getValueAt(i,j));
	                   if (j!=nCol) buffer.append(",");
	                }
	                writer.write(buffer.toString() + "\r");
	            }JOptionPane.showMessageDialog(null,"File Saved to print : ReceivedStock.csv" );}	
	        catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
	              try {
	            	  //br.close();
					//writer.close();
					writer.flush();
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            	
			}   	}
			            }
	    	        });
	    	        
	    	        btndel.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							   // i = the index of the selected row
			                int i = rectable1.getSelectedRow();
			                if(i >= 0){
			                    // remove a row from jtable
			                    modelrec.removeRow(i);
			                }
			                else{
			                    System.out.println("Delete Error");
			                }
							
						}
	    	        	
	    	        });
	    	        btnPrint.addActionListener(new ActionListener() {
	    	            public void actionPerformed(ActionEvent e) {
	    	            	 JDialog.setDefaultLookAndFeelDecorated(true);
	    		    	        int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
	    		    	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    		    	        if (response == JOptionPane.NO_OPTION) {
	    		    	        	System.out.println("No button clicked");
	    		    	        }
	    		    	        else if (response == JOptionPane.CLOSED_OPTION) {
	    		    	            System.out.println("JOptionPane closed");
	    		    	          }
	    		    	        else if (response == JOptionPane.YES_OPTION) {
	    		    	        	 
	    	            	
	    	            	BufferedWriter writer = null;
	    	            	 OutputStreamWriter output;
	    	            	 FileOutputStream filestream;
	    	            	 BufferedReader br = null;
	    	            	 
	    	            	
	    	        DefaultTableModel dtm = (DefaultTableModel) rectable1.getModel();
	    	        int nRow = dtm.getRowCount();
	    	        int nCol = dtm.getColumnCount();
	    	        
	    	        try {
	    	        	//  br = new BufferedReader(new FileReader("file.csv"));
	    	        	FileWriter fw = new FileWriter("ReceivedStock.csv", false);
	    	        // BufferedWriter bw = new BufferedWriter(fw);
	    	        	  writer = new BufferedWriter(fw);
	    	      	//   String line;
	    	      //	  int index=0;
	    	      	    
	    	      	//  while ((line = br.readLine()) == null) {
	    	      	    	
	    	      //             if(line==null){
	    	        	

	    	            //write the header information
	    	        	   
	    	        	  
	    	        	
	                	  
	                	 // writers.write();
	                	//  writers.newLine();
	                	  writer.newLine();
	                	  writer.write("Purchase Order id\t"+comboBox.getSelectedItem());
	                	 // writers.newLine();
	                	 // writers.write();
	                	  writer.newLine();
	                	  writer.newLine();
	                	 
	    	           StringBuffer bufferHeader = new StringBuffer();
	    	         
	    	           for (int j =0; j < nCol; j++) {
	    	              bufferHeader.append(dtm.getColumnName(j));
	    	                if (j!=nCol) bufferHeader.append(", ");
	    	            }
	    	           writer.write(bufferHeader.toString() + "\r\n");

	    	           //write row information
	    	            for (int i = 0 ; i < nRow ; i++){
	    	                 StringBuffer buffer = new StringBuffer();
	    	                for (int j = 0 ; j < nCol ; j++){
	    	                   buffer.append(dtm.getValueAt(i,j));
	    	                   if (j!=nCol) buffer.append(", ");
	    	                }
	    	                writer.write(buffer.toString() + "\r");
	    	            }JOptionPane.showMessageDialog(null,"File Saved to print : ReceivedStock.csv" );}	
	    	        catch (UnsupportedEncodingException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			} catch (FileNotFoundException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			} catch (IOException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			} finally {
	    	              try {
	    	            	  //br.close();
	    					//writer.close();
	    					writer.flush();
	    					writer.close();
	    				} catch (IOException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    	            	
	    	            	
	    			}	}
	    	            }
	    	        });
	    	       
	    	        btnEdit.addActionListener(new ActionListener()
	    	        {

						@Override
						public void actionPerformed(ActionEvent e) {
							 // create JFrame and JTable
					        final JFrame rec1frame = new JFrame();
					        
					        // create a table model and set a Column Identifiers to this model 
					     //   Object[] columns = {"Supplier Id", "Name", "Address", "Contact "};
					     //   final DefaultTableModel model = new DefaultTableModel();
					     //   model.setColumnIdentifiers(columns);
					       
					        Font font = new Font("",1,22);
					        
					       
					        
					        // create JButtons
					       // BufferedImage buttonIcon = ImageIO.read(new File("contact_icons.png"));
					       // button = new JButton(new ImageIcon(buttonIcon));
					        
					        JButton btnNewButton = new JButton("Cancel");
					        btnNewButton.setBounds(351, 301, 117, 25);
					        rec1frame.getContentPane().add(btnNewButton);
					        JButton btnupd = new JButton("Update");
					        JButton btnAddrec = new JButton("Add");
					        rec1frame.getContentPane().add(btnAddrec);
					        btnAddrec.setBounds(130, 301, 100, 25);
					        
					        textIdr.setBounds(117, 12, 138, 25);
					        textFnamer.setBounds(117, 65, 138, 25);
					        textLnamer.setBounds(117, 123, 138, 25);
					        textAger.setBounds(117, 188, 138, 25);
					        
					        btnupd.setBounds(241, 301, 100, 25);
					        
					        rec1frame.getContentPane().setLayout(null);
					        
					        // add JTextFields to the jframe
					        rec1frame.getContentPane().add(textIdr);
					        rec1frame.getContentPane().add(textFnamer);
					        rec1frame.getContentPane().add(textLnamer);
					        rec1frame.getContentPane().add(textAger);
					    
					        // add JButtons to the jframe
					        rec1frame.getContentPane().add(btnupd);
					        
					        JLabel lblNewLabel = new JLabel("Item");
					        lblNewLabel.setBounds(24, 17, 87, 15);
					        rec1frame.getContentPane().add(lblNewLabel);
					        
					        JLabel lblNewLabel_1 = new JLabel("Description");
					        lblNewLabel_1.setBounds(24, 70, 100, 15);
					        rec1frame.getContentPane().add(lblNewLabel_1);
					        
					        JLabel lblNewLabel_2 = new JLabel("Location");
					        lblNewLabel_2.setBounds(24, 128, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_2);
					        
					        JLabel lblNewLabel_3 = new JLabel("Order Qty");
					        lblNewLabel_3.setBounds(24, 193, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_3);
					        
					        JLabel lblNewLabel_4 = new JLabel("Unit Cost");
					        lblNewLabel_4.setBounds(299, 17, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_4);
					        
					        JLabel lblNewLabel_5 = new JLabel("Stock Qty");
					        lblNewLabel_5.setBounds(299, 70, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_5);
					        
					        JLabel lblNewLabel_6 = new JLabel("Warn Qty");
					        lblNewLabel_6.setBounds(299, 128, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_6);
					        
					        JLabel lblNewLabel_7 = new JLabel("ideal Qty");
					        lblNewLabel_7.setBounds(299, 193, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_7);
					        
					        //textFieldr = new JTextField();
					        textFieldr.setBounds(399, 12, 138, 25);
					        rec1frame.getContentPane().add(textFieldr);
					        textFieldr.setColumns(10);
					        
					       // textField_1r = new JTextField();
					        textField_1r.setBounds(399, 68, 138, 22);
					        rec1frame.getContentPane().add(textField_1r);
					        textField_1r.setColumns(10);
					        
					       // textField_2r = new JTextField();
					        textField_2r.setBounds(399, 126, 138, 22);
					        rec1frame.getContentPane().add(textField_2r);
					        textField_2r.setColumns(10);
					        
					       // textField_3r = new JTextField();
					        textField_3r.setBounds(399, 191, 138, 22);
					        rec1frame.getContentPane().add(textField_3r);
					        textField_3r.setColumns(10);
					        
					        JLabel lblNewLabel_8 = new JLabel("Recv Qty");
					        lblNewLabel_8.setBounds(24, 253, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_8);
					        
					       // textField_4r = new JTextField();
					        textField_4r.setBounds(117, 251, 138, 25);
					        rec1frame.getContentPane().add(textField_4r);
					        textField_4r.setColumns(10);
					        
					        JLabel lblNewLabel_9 = new JLabel("Line Total");
					        lblNewLabel_9.setBounds(299, 253, 70, 15);
					        rec1frame.getContentPane().add(lblNewLabel_9);
					        
					       // textField_5r = new JTextField();
					        textField_5r.setBounds(399, 251, 138, 25);
					        rec1frame.getContentPane().add(textField_5r);
					        textField_5r.setColumns(10);
					        
					        // create an array of objects to set the row data
					        final Object[] row = new Object[10];
					        rectable1.addMouseListener(new MouseAdapter(){
			    	        	@Override
			    	        	public void mouseClicked(MouseEvent e){
			    	        		  // i = the index of the selected row
			    	                int i = rectable1.getSelectedRow();
			    	                
			    	                textIdr.setText(modelrec.getValueAt(i, 0).toString());
			    	                textFnamer.setText(modelrec.getValueAt(i, 1).toString());
			    	                textLnamer.setText(modelrec.getValueAt(i, 2).toString());
			    	                textAger.setText(modelrec.getValueAt(i, 3).toString());
			    	                textFieldr.setText(modelrec.getValueAt(i, 4).toString());
			    	                textField_1r.setText(modelrec.getValueAt(i, 5).toString());
			    	                textField_2r.setText(modelrec.getValueAt(i, 6).toString());
			    	                textField_3r.setText(modelrec.getValueAt(i, 7).toString());
			    	                textField_4r.setText(modelrec.getValueAt(i, 8).toString());
			    	                textField_5r.setText(modelrec.getValueAt(i, 9).toString());
			    	        	}
			    	        	
			    	        });
					        
					        
					        // button add row
					        btnupd.addActionListener(new ActionListener(){

					            @Override
					            public void actionPerformed(ActionEvent e) {

					                // i = the index of the selected row
					                int i = rectable1.getSelectedRow();
					                
					                if(i >= 0) 
					                {
					                   modelrec.setValueAt(textIdr.getText(), i, 0);
					                   modelrec.setValueAt(textFnamer.getText(), i, 1);
					                   modelrec.setValueAt(textLnamer.getText(), i, 2);
					                   modelrec.setValueAt(textAger.getText(), i, 3);
					                   modelrec.setValueAt(textFieldr.getText(), i, 5);
					                   modelrec.setValueAt(textField_1r.getText(), i, 6);
					                   modelrec.setValueAt(textField_2r.getText(), i, 7);
					                   modelrec.setValueAt(textField_3r.getText(), i, 8);
					                   modelrec.setValueAt(textField_4r.getText(), i, 4);
					                   modelrec.setValueAt(textField_5r.getText(), i, 9);
					                }
					                else{
					                	 System.out.println("Update Error");
					                }
					            }
					        });
					        btnNewButton.addActionListener(new ActionListener(){

					            @Override
					            public void actionPerformed(ActionEvent e) {
					            	rec1frame.dispose();
					            }
			    	        });
					        
					        rec1frame.setSize(577,394);
					        rec1frame.setLocationRelativeTo(null);
					       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        rec1frame.setVisible(true);
							
						}
	    	        	
	    	        });
	    	        // button add row
	    	        btnAdd1.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							 // create JFrame and JTable
					        final JFrame recframe = new JFrame();
					        
					        // create a table model and set a Column Identifiers to this model 
					     //   Object[] columns = {"Supplier Id", "Name", "Address", "Contact "};
					     //   final DefaultTableModel model = new DefaultTableModel();
					     //   model.setColumnIdentifiers(columns);
					       
					        Font font = new Font("",1,22);
					        
					       
					        
					        // create JButtons
					       // BufferedImage buttonIcon = ImageIO.read(new File("contact_icons.png"));
					       // button = new JButton(new ImageIcon(buttonIcon));
					        
					        JButton btncan = new JButton("Cancel");
					        btncan.setBounds(351, 301, 117, 25);
					        recframe.getContentPane().add(btncan);
					        JButton btnAddrec = new JButton("Add");
					        JButton btnupd = new JButton("Update");
					        recframe.getContentPane().add(btnupd);
					        btnupd.setBounds(241, 301, 100, 25);
					        textIdr.setBounds(117, 12, 138, 25);
					        textFnamer.setBounds(117, 65, 138, 25);
					        textLnamer.setBounds(117, 123, 138, 25);
					        textAger.setBounds(117, 188, 138, 25);
					        
					        btnAddrec.setBounds(130, 301, 100, 25);
					        
					        recframe.getContentPane().setLayout(null);
					        
					        // add JTextFields to the jframe
					        recframe.getContentPane().add(textIdr);
					        recframe.getContentPane().add(textFnamer);
					        recframe.getContentPane().add(textLnamer);
					        recframe.getContentPane().add(textAger);
					    
					        // add JButtons to the jframe
					        recframe.getContentPane().add(btnAddrec);
					        
					        JLabel lblNewLabel = new JLabel("Item");
					        lblNewLabel.setBounds(24, 17, 87, 15);
					        recframe.getContentPane().add(lblNewLabel);
					        
					        JLabel lblNewLabel_1 = new JLabel("Description");
					        lblNewLabel_1.setBounds(24, 70, 100, 15);
					        recframe.getContentPane().add(lblNewLabel_1);
					        
					        JLabel lblNewLabel_2 = new JLabel("Location");
					        lblNewLabel_2.setBounds(24, 128, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_2);
					        
					        JLabel lblNewLabel_3 = new JLabel("Order Qty");
					        lblNewLabel_3.setBounds(24, 193, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_3);
					        
					        JLabel lblNewLabel_4 = new JLabel("Unit Cost");
					        lblNewLabel_4.setBounds(299, 17, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_4);
					        
					        JLabel lblNewLabel_5 = new JLabel("Stock Qty");
					        lblNewLabel_5.setBounds(299, 70, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_5);
					        
					        JLabel lblNewLabel_6 = new JLabel("Warn Qty");
					        lblNewLabel_6.setBounds(299, 128, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_6);
					        
					        JLabel lblNewLabel_7 = new JLabel("ideal Qty");
					        lblNewLabel_7.setBounds(299, 193, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_7);
					        
					       // textFieldr = new JTextField();
					        textFieldr.setBounds(399, 12, 138, 25);
					        recframe.getContentPane().add(textFieldr);
					        textFieldr.setColumns(10);
					        
					      //  textField_1r = new JTextField();
					        textField_1r.setBounds(399, 68, 138, 22);
					        recframe.getContentPane().add(textField_1r);
					        textField_1r.setColumns(10);
					        
					      //  textField_2r = new JTextField();
					        textField_2r.setBounds(399, 126, 138, 22);
					        recframe.getContentPane().add(textField_2r);
					        textField_2r.setColumns(10);
					        
					       // textField_3r = new JTextField();
					        textField_3r.setBounds(399, 191, 138, 22);
					        recframe.getContentPane().add(textField_3r);
					        textField_3r.setColumns(10);
					        
					        JLabel lblNewLabel_8 = new JLabel("Recv Qty");
					        lblNewLabel_8.setBounds(24, 253, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_8);
					        
					       // textField_4r = new JTextField();
					        textField_4r.setBounds(117, 251, 138, 25);
					        recframe.getContentPane().add(textField_4r);
					        textField_4r.setColumns(10);
					        
					        JLabel lblNewLabel_9 = new JLabel("Line Total");
					        lblNewLabel_9.setBounds(299, 253, 70, 15);
					        recframe.getContentPane().add(lblNewLabel_9);
					        
					        //textField_5r = new JTextField();
					        textField_5r.setBounds(399, 251, 138, 25);
					        recframe.getContentPane().add(textField_5r);
					        textField_5r.setColumns(10);
					        
					        // create an array of objects to set the row data
					        final Object[] row = new Object[10];
					        textIdr.setText("");
	    	                textFnamer.setText("");
	    	                textLnamer.setText("");
	    	                textAger.setText("");
	    	                textFieldr.setText("");
	    	                textField_1r.setText("");
	    	                textField_2r.setText("");
	    	                textField_3r.setText("");
	    	                textField_4r.setText("");
	    	                textField_5r.setText("");
					        
					        // button add row
					        btnAddrec.addActionListener(new ActionListener(){

					            @Override
					            public void actionPerformed(ActionEvent e) {
					             
					                row[0] = textIdr.getText();
					                row[1] = textFnamer.getText();
					                row[2] = textLnamer.getText();
					                row[3] = textAger.getText();
					                row[5] = textFieldr.getText();
					                row[6] = textField_1r.getText();
					                row[7] = textField_2r.getText();
					                row[8] = textField_3r.getText();
					                row[4] = textField_4r.getText();
					                row[9] = textField_5r.getText();
					                
					                // add row to the model
					                modelrec.addRow(row);
					            }
					        });
					        btncan.addActionListener(new ActionListener(){

					            @Override
					            public void actionPerformed(ActionEvent e) {
					            	recframe.dispose();
					            }
			    	        });
			    	       
					        
					        recframe.setSize(577,394);
					        recframe.setLocationRelativeTo(null);
					       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        recframe.setVisible(true);
					        
						}
	    	        });
	    	       
	    	        
	    	    }
	    	    }
	    	    
	    	 
		});

		frmAsianPaints.setExtendedState(frmAsianPaints.MAXIMIZED_BOTH); 
		//1.setSize(500,500);
        frmAsianPaints.setDefaultCloseOperation(frmAsianPaints.EXIT_ON_CLOSE);
        frmAsianPaints.setVisible(true);
        
	}

	public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);

        for(int i=0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i,j).toString()+"\t");
            }
            out.write("\n");
        }
        out.close();
        JOptionPane.showMessageDialog(null,	"Saved to  " + file);
    }
	public static int nextValue() {
	    return counter.getAndIncrement();
	  }
}
