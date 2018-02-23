

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.CardLayout;

//import org.apache.commons.lang.StringUtils;
//import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class mainGUI extends JFrame {

	private JPanel contentPane, card;
	private JTextField valueTextField;
	private JRadioButton rdbtnNewRadioButton;	
	private JRadioButton rdbtnNewRadioButton_2;
	private JButton btnNewButton,btnNewButton_1;
	private JButton delete;
	private JButton SellButton;
	private JButton update;
	private JButton btnLogin;
	private JTextField textField_1;
	JComboBox comboBox;
	JComboBox comboBox_2;
	JComboBox[] comboBox_A=new JComboBox[3];
	JComboBox comboBox_3;
	JComboBox comboBox_7;
	JComboBox comboBox_1;
	JComboBox comboBox_6;
	JComboBox comboBox_8;
	CardLayout layout=new CardLayout();
	private JTextField textField_2;
	JTextArea Carlist ;
	JTextArea updateList ;
	
	JTabbedPane tabbedPane;
	CarDB z;
	
	private String userName="";
	private String passWord="";
	
	private JTextField carIDtextField;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField Phone;
	private JTextField carIDtext;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					mainGUI frame = new mainGUI();
					frame.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainGUI() 
	{
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("1479111383_red_64.png"));
		setForeground(Color.GREEN);
		setTitle("DealerApp");
		
		initComponents();
		createEvents();
		
				
	}

	
	
	private void initComponents() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1052, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		contentPane.add(tabbedPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("LOGIN", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.add(panel_10, BorderLayout.CENTER);
		
		JLabel lblNewLabel_8 = new JLabel("User Name :");
		panel_10.add(lblNewLabel_8);
		
		textField = new JTextField();
		panel_10.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		panel_10.add(lblNewLabel_9);
		
		textField_3 = new JTextField();
		panel_10.add(textField_3);
		textField_3.setColumns(10);
		
		btnLogin = new JButton("Login");
		panel_10.add(btnLogin);
		
		JLabel lblEnterUserName = new JLabel("  Enter the User Name and Password of your Database,  if  password is not required   leave it blank     ");
		lblEnterUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblEnterUserName, BorderLayout.NORTH);
		lblEnterUserName.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_10 = new JLabel("Made By Abderrazzak");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_10, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("INVENTORY", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		panel.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		tabbedPane_1.addTab("FIND A CAR", null, panel_3, null);
		
		ButtonGroup group=new ButtonGroup();
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.ORANGE);
		panel_3.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblFindCars = new JLabel("Find cars");
		panel_7.add(lblFindCars);
		
		rdbtnNewRadioButton = new JRadioButton("By Make");
		panel_7.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_2 = new JRadioButton("By Year");
		panel_7.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_2);
		
		
		valueTextField = new JTextField();
		panel_7.add(valueTextField);
		valueTextField.setColumns(10);
		
		btnNewButton = new JButton("OK");
		panel_7.add(btnNewButton);
		
		 Carlist = new JTextArea();
		 Carlist.setEditable(false);
		panel_3.add(Carlist, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.PINK);
		tabbedPane_1.addTab("ALL", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.NORTH);
		
		update = new JButton("Update LIST");
		
		panel_8.add(update);
		
		updateList = new JTextArea();
		updateList.setColumns(10);
		updateList.setEditable(false);
		panel_4.add(updateList, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Remove Car", null, panel_6, null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Car ID");
		panel_6.add(lblNewLabel_1);
		
		carIDtextField = new JTextField();
		panel_6.add(carIDtextField);
		carIDtextField.setColumns(10);
		
		delete = new JButton("OK");
		
		panel_6.add(delete);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("SELL", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Enter Customer Information ");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_7, BorderLayout.NORTH);
		
		JPanel firstname = new JPanel();
		firstname.setBackground(Color.LIGHT_GRAY);
		panel_1.add(firstname, BorderLayout.CENTER);
		firstname.setLayout(new GridLayout(7, 2, 0, 25));
		
		JLabel lblNewLabel_3 = new JLabel("First Name  ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.add(lblNewLabel_3);
		
		firstNameText = new JTextField();
		firstNameText.setHorizontalAlignment(SwingConstants.LEFT);
		firstname.add(firstNameText);
		firstNameText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name  ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.add(lblNewLabel_4);
		
		lastNameText = new JTextField();
		firstname.add(lastNameText);
		lastNameText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number  ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.add(lblNewLabel_5);
		
		Phone = new JTextField();
		firstname.add(Phone);
		Phone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Car ID Sold  ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.add(lblNewLabel_6);
		
		carIDtext = new JTextField();
		firstname.add(carIDtext);
		carIDtext.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11, BorderLayout.SOUTH);
		
		SellButton = new JButton("OK");
		
		panel_11.add(SellButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.BLACK);
		tabbedPane.addTab("ADD CAR", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel car = new JPanel();
		car.setBackground(Color.ORANGE);
		FlowLayout fl_car = (FlowLayout) car.getLayout();
		fl_car.setAlignment(FlowLayout.LEFT);
		panel_2.add(car, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Choose a Car :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		car.add(lblNewLabel);
		
		comboBox = new JComboBox();
		
		car.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chevrolet", "Dodge", "Ford"}));
		
		card = new JPanel();
		car.add(card);
		card.setLayout(layout);
		
		comboBox_A[0] = new JComboBox();
		comboBox_A[0].setModel(new DefaultComboBoxModel(new String[] {"Cruze", "Malibu", "Impala"}));
		card.add(comboBox_A[0], "name_264420111655968");
		
		comboBox_A[1] = new JComboBox();
		comboBox_A[1].setModel(new DefaultComboBoxModel(new String[] {"Avenger", "Charger", "Challenger"}));
		card.add(comboBox_A[1], "name_264424551196957");
		
		comboBox_A[2] = new JComboBox();
		comboBox_A[2] .setModel(new DefaultComboBoxModel(new String[] {"Focus", "Fusion", "Fiesta"}));
		card.add(comboBox_A[2] , "name_264431035823570");
		
		
		//card.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox_A[0] , comboBox_A[1] , comboBox_A[2] }));
		
		JLabel lblYear = new JLabel("Year : ");
		car.add(lblYear);
		
		comboBox_2 = new JComboBox();
		car.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"}));
		
		JLabel lblDriveTrain = new JLabel("Drive Train : ");
		car.add(lblDriveTrain);
		
		comboBox_1 = new JComboBox();
		car.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"FWD", "RWD", "AWD"}));
		
		JLabel lblFuel = new JLabel("Fuel : ");
		car.add(lblFuel);
		
		comboBox_3 = new JComboBox();
		car.add(comboBox_3);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Gas", "Diesel"}));
		
		JLabel lblTransmission = new JLabel("Transmission : ");
		car.add(lblTransmission);
		
		comboBox_8 = new JComboBox();
		car.add(comboBox_8);
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automatic", "CVT"}));
		
		JLabel lblColor = new JLabel("Color : ");
		car.add(lblColor);
		
		comboBox_7 = new JComboBox();
		car.add(comboBox_7);
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Blue", "White", "Black", "Red", "Green"}));
		
		JPanel price = new JPanel();
		price.setBackground(Color.ORANGE);
		panel_2.add(price);
		price.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMileage = new JLabel("Mileage : ");
		price.add(lblMileage);
		
		textField_2 = new JTextField();
		price.add(textField_2);
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Set Price");
		price.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		price.add(textField_1);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("Ok");
		price.add(btnNewButton_1);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.NORTH);
		
		
	}
	
	private void createEvents() 
	{
		//======================Find car
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//CarDB z= new CarDB(userName,passWord);
				Carlist.setText("");
				
				int size = 0;
				try {
					size = z.getCars().size();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					for(int i=0; i<size; i++)
					{
						
						int id = 0;
						String make = null;
						String model = null;
						String color = null;
						int years = 0;
						String fuel = null;
						String drive = null;
						String tr = null;
						double pr = 0;
						int mileage = 0;
						boolean sold = false;
						try {
							id = z.getCars().get(i).getID();
							 make=z.getCars().get(i).getMake();
							 model=z.getCars().get(i).getModel();
							 color=z.getCars().get(i).getColor();
							 years=z.getCars().get(i).getyear();
							 fuel=z.getCars().get(i).getFuel();
							 drive=z.getCars().get(i).getDriveTrain();
							 tr =z.getCars().get(i).getTransmission();
							 pr=z.getCars().get(i).getPrice();
							 mileage=z.getCars().get(i).getMileage();
							 sold=z.getCars().get(i).getSold();
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(rdbtnNewRadioButton.isSelected())
						if((valueTextField.getText().equals(make))&&(sold!=true))
						{
							String str= id+"      "+make+"     "+model+"      "+color+ "  "
									+ "     "+years+"     "+fuel+ "     "+ drive+"      "+tr+"     "+ pr+"     "+mileage+"\n";
								
								
								Carlist.append(str);	
					
						}
						
						if(rdbtnNewRadioButton_2.isSelected())
							if((Integer.parseInt(valueTextField.getText())==years)&&(sold!=true))
							{
								String str= id+"      "+make+"     "+model+"      "+color+ "  "
										+ "     "+years+"     "+fuel+ "     "+ drive+"      "+tr+"     "+ pr+"     "+mileage+"\n";														
									Carlist.append(str);							
							}					
					}			
			}
		});
		
		//======================Add car
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CarDB z= new CarDB(userName,passWord);
				String make=(String)comboBox.getSelectedItem();
				String model=(String)comboBox_A[comboBox.getSelectedIndex()].getSelectedItem();
				
				String fuel=(String)comboBox_3.getSelectedItem();
				String color=(String)comboBox_7.getSelectedItem();
				String DrTrain=(String)comboBox_1.getSelectedItem();
				String trans=(String)comboBox_8.getSelectedItem();
				int mileage;
				double price;
				int year;
				
				
				try
				{
				 mileage=Integer.parseInt(textField_2.getText());
				 price=Double.parseDouble(textField_1.getText());
				 year=Integer.parseInt((String)comboBox_2.getSelectedItem());
				}
				catch(NumberFormatException nfe)  
				{
				JOptionPane.showMessageDialog(null, "Input must be a number");
		  		  return;
				}
				
				
				
				
				try {
					z.addCar(make, model, year, fuel, color, DrTrain, trans, mileage, price);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textField_1.setText("0");
				textField_2.setText("0");
				
				
			}
		});
		
		//----------------------------
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //z= new CarDB(userName,passWord);
				
				try {
					z.removeCar(Integer.parseInt(carIDtextField.getText()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		///////////////////////////////////////////////////////////////
		SellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//CarDB z= new CarDB(userName,passWord);
				
				System.out.println("test.....");
				
				
				int id=0;
				String f=firstNameText.getText();
				String l=lastNameText.getText();
				int phone=0;
				try
				{
				 id=Integer.parseInt(carIDtext.getText());
				 phone=Integer.parseInt(Phone.getText());
				}
				catch(NumberFormatException nfe) 
				{
					JOptionPane.showMessageDialog(null, "Input must be a number");
			  		  return;
				}
				
				
				
				
				
				int k=0;
				try {
					 k=z.changeSold(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(k!=0)
				{
					try {
						z.sell(id, f, l, phone);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "The Car has been sold!");
				}
				
				else
					JOptionPane.showMessageDialog(null, "This Car ID is not found !");
				
			}
		});
		////////////////////////////////////////////updtae/////////
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CarDB z= new CarDB(userName,passWord);
				updateList.setText("");
					
					int size=0;
					try {
						size = z.getCars().size();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}							
					for(int i=0; i<size; i++)
					{
						
						int id = 0;
						String make = null;
						String model = null;
						String color = null;
						int years = 0;
						String fuel = null;
						String drive = null;
						String tr = null;
						double pr = 0;
						int mileage = 0;
						boolean sold = false;
					
							try {
								id = z.getCars().get(i).getID();
							make=z.getCars().get(i).getMake();
							 model=z.getCars().get(i).getModel();
							 color=z.getCars().get(i).getColor();
							 years=z.getCars().get(i).getyear();////
							 fuel=z.getCars().get(i).getFuel();
							 drive=z.getCars().get(i).getDriveTrain();///
							 tr =z.getCars().get(i).getTransmission();
							 pr=z.getCars().get(i).getPrice();
							 mileage=z.getCars().get(i).getMileage();
							 sold=z.getCars().get(i).getSold();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}							 
							 String str= id+"      "+make+"     "+model+"      "+color+ "  "
										+ "     "+years+"     "+fuel+ "     "+ drive+"      "+tr+"     "+ pr+"     "+mileage+"\n";		
							 
							 if((sold!=true))
							updateList.append(str);	
							
					}			
			}
		});
		
		
		
		
		//==========================combobox
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				layout.first(card);
				for(int i=0; i<comboBox.getSelectedIndex();i++)
				{
					layout.next(card);
				}
				
								
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				userName=textField.getText();
				passWord=textField_3.getText();
				
				z= new CarDB(userName,passWord);
				
				if(z.status)
				{
				tabbedPane.setEnabled(true);
				btnLogin.setEnabled(false);
				JOptionPane.showMessageDialog(null,"Database connected" );
				}
				
				else
					JOptionPane.showMessageDialog(null, "Wrong user name and PassWord!");
				
				textField.setText("");
				textField_3.setText("");				
			}
		});
		
	}


	
	
	

}
