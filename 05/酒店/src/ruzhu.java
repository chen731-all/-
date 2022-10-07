import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.*;
import javax.swing.*;

import com.eltima.components.ui.DatePicker;


public class ruzhu extends JFrame implements ActionListener {
	public ruzhu() {
		initComponents();
	}
	private static DatePicker getDatePicker() {
        final DatePicker datepick;
        String DefaultFormat = "yyyy/MM/dd HH:mm:ss";
        Date date = new Date();
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(146, 24);
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        datepick.setTimePanleVisible(true);
        return datepick;
    }
	
    public void showemptyrooms(){
    	//展示房间情况
    	Object[] rowData;
    	try{
    		connection con1=new connection();
		    con=con1.getcon();
		    sta=con.createStatement();
	        String sql="select * from room  order by 房间号"; 
		    rs=sta.executeQuery(sql);
		    int num=0;
		    while(rs.next()){
		    	rowData=new Object[7];
		    	rowData[0]=rs.getString("房间号");
		    	rowData[1]=rs.getString("房间类型");	
		    	rowData[2]=rs.getString("价格");
		    	rowData[3]=rs.getInt("人数"); 
		    	rowData[4]=rs.getString("备注");
		    	if(rs.getInt("能否入住")==1)
		    		flag="空房";
		    	else
		    		flag="已入住";
		    	rowData[5]=flag;
		    	model.insertRow(num, rowData);
		    	num++;
		    }		  
	    }catch(Exception e2){
	    	e2.printStackTrace();
	    }
    }
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		textroomid = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		textroomprice = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		textname = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		rbmale = new javax.swing.JRadioButton();
		rbfemale = new javax.swing.JRadioButton();
		jPanel7 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		comcerttype = new javax.swing.JComboBox();
		jLabel9 = new javax.swing.JLabel();
		textcertnum = new javax.swing.JTextField();
		jPanel8 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		textcertaddress = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		textphone = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		textforegift = new javax.swing.JTextField();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		textoperator = new javax.swing.JTextField();
		bregister = new javax.swing.JButton();
		bsave = new javax.swing.JButton();
		bcancel = new javax.swing.JButton();
        datepick1 = getDatePicker();
        datepick2 = getDatePicker();
       
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jPanel1.setSize(new java.awt.Dimension(700, 300));
		jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,
				15, 5));
		model=new javax.swing.table.DefaultTableModel(
				new Object[][] {}, 
				new String[] {"房间号","房间类型","价格","人数","备注","是否空房"});
		jTable1.setModel(model);
		TableColumn column = null;  
        int colunms = jTable1.getColumnCount();  
        for(int i = 0; i < colunms; i++)  
        {  
            column = jTable1.getColumnModel().getColumn(i);
            column.setWidth(100);
        }
        jTable1.setPreferredScrollableViewportSize(new Dimension(700, 300));
		jScrollPane1.setViewportView(jTable1);
		jPanel1.add(jScrollPane1);
		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		//框
		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("旅客入住登记"));
		jPanel2.setLayout(new java.awt.GridLayout(5, 1));
		jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel2.setText("\u623f\u95f4\u53f7    ");
		jPanel4.add(jLabel2);
		textroomid.setColumns(13);
		jPanel4.add(textroomid);
		
		jLabel3.setText("\u623f\u95f4\u4ef7\u683c");
		jPanel4.add(jLabel3);
		textroomprice.setColumns(13);
		jPanel4.add(textroomprice);
		jPanel2.add(jPanel4);
		jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,5));
		jLabel4.setText("\u5165\u4f4f\u65f6\u95f4");
		jPanel5.add(jLabel4); 
		jPanel5.add(datepick1);
		jLabel5.setText("\u79bb\u5f00\u65f6\u95f4");
		jPanel5.add(jLabel5);
		jPanel5.add(datepick2);
		jPanel2.add(jPanel5);
		jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,5));
		jLabel6.setText("\u65c5\u5ba2\u59d3\u540d");
		jPanel6.add(jLabel6);
		textname.setColumns(13);
		jPanel6.add(textname);
		jLabel7.setText("\u65c5\u5ba2\u6027\u522b");
		jPanel6.add(jLabel7);
		rbmale.setText("男");
		rbmale.setSelected(true);
		jPanel6.add(rbmale);
		rbfemale.setText("女");
		jPanel6.add(rbfemale);
		
		jPanel2.add(jPanel6);
		jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,5));
		jLabel8.setText("\u8bc1\u4ef6\u7c7b\u578b");
		jPanel7.add(jLabel8);
		comcerttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"居民身份证", "护照", "港澳台通行证"}));
		comcerttype.setPreferredSize(new java.awt.Dimension(150, 23));
		jPanel7.add(comcerttype);
		jLabel9.setText("\u8bc1\u4ef6\u53f7\u7801");
		jPanel7.add(jLabel9);
		textcertnum.setColumns(13);
		jPanel7.add(textcertnum);
		jPanel2.add(jPanel7);
		jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,5));
		jLabel10.setText("\u8bc1\u4ef6\u5730\u5740");
		jPanel8.add(jLabel10);
		textcertaddress.setColumns(13);
		jPanel8.add(textcertaddress);
		jLabel11.setText("\u8054\u7cfb\u7535\u8bdd");
		jPanel8.add(jLabel11);
		textphone.setColumns(13);
		jPanel8.add(textphone);
		jLabel12.setText("\u9884\u6536\u62bc\u91d1");
		jPanel8.add(jLabel12);
		textforegift.setColumns(13);
		jPanel8.add(textforegift);
		jPanel2.add(jPanel8);
		getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);
		jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER,
				20, 5));
		jLabel1.setText("\u64cd\u4f5c\u5458");
		jPanel3.add(jLabel1);
		textoperator.setColumns(13);
		jPanel3.add(textoperator);
		bregister.setText("\u767b\u8bb0");
		jPanel3.add(bregister);
		bregister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane.showMessageDialog(null,"必须填写完整，否则报错");
				  String roomId= textroomid.getText().trim();//去除空格		
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");		       	 
				  String inTime="",outTime="";		     
		             inTime=sdf.format(datepick1.getValue());
		             outTime=sdf.format(datepick2.getValue());
				  int foregift=Integer.parseInt(textforegift.getText());
				  String clientName=textname.getText();
				  int sex=1;
			      if(rbfemale.isSelected())
			    	sex=0;
				  String phone=textphone.getText();
				  String certType=comcerttype.getSelectedItem().toString(); 
				  String certId=textcertnum.getText();
				  String address=textcertaddress.getText();
				  String operator=textoperator.getText();
					try{
						connection con1=new connection();
						con=con1.getcon();
						sta=con.createStatement();
						String sql="insert into guest(房间号,押金,入住时间,离开时间,姓名,性别,电话,证件类型,证件号,地址,操作员) " +
						"values('"+roomId+"',"+foregift+",'"+inTime+"','"+outTime+"','"+clientName+"',"+sex+",'"+phone+"','"+
						        certType+"','"+certId+"','"+address+"','"+operator+"')";			
						 int c=sta.executeUpdate(sql);
						 JOptionPane.showMessageDialog(null,c==1?"入住信息已登记，欢迎入住我们的酒店！":"登记失败");
						 sql="update room set 能否入住=0 where 房间号='"+roomId+"'";
						 sta.executeUpdate(sql);
						}catch(SQLException e1){
							e1.printStackTrace();
						}
			}
		});
		bcancel.setText("清空");
		jPanel3.add(bcancel);
		bcancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textname.setText("");
				textcertaddress.setText("");
				textcertnum.setText("");
				textforegift.setText("");
				textoperator.setText("");
				textphone.setText("");
				textroomid.setText("");
				textroomprice.setText("");
				textroomid.requestFocus();
			}
		});
		getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);
        this.setTitle("入住登记");
        showemptyrooms();
		this.setPreferredSize(new Dimension(750,500));
		this.setBounds(480, 140,750,500);
		this.setResizable(false);
		rbfemale.addActionListener(this);
		rbmale.addActionListener(this);
		pack();
	}
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ruzhu().setVisible(true);
			}
		});
	}

	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JComboBox comcerttype;
	private javax.swing.JButton bregister;
	private javax.swing.JButton bsave;
	private javax.swing.JButton bcancel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JRadioButton rbfemale;
	private javax.swing.JRadioButton rbmale;
	private javax.swing.JTextField textcertaddress;
	private javax.swing.JTextField textcertnum;
	private javax.swing.JTextField textforegift;
	private javax.swing.JTextField textname;
	private javax.swing.JTextField textoperator;
	private javax.swing.JTextField textphone;
	private javax.swing.JTextField textroomid;
	private javax.swing.JTextField textroomprice;
	private DefaultTableModel model;
	private String flag;
	DatePicker datepick1,datepick2;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rbfemale)
			rbmale.setSelected(false);
		if(e.getSource()==rbmale)
			rbfemale.setSelected(false);
		
	}
	
	
}