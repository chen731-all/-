import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;

import com.eltima.components.ui.DatePicker;

public class tuifang extends JFrame{

	public tuifang() {
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
	
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel6 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		textforegift = new javax.swing.JTextField();
		jPanel10 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		texttotal = new javax.swing.JTextField();
		jPanel8 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		textaccount = new javax.swing.JTextField();
		jPanel7 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		textprice = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		textnote = new javax.swing.JTextArea();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		comroomid = new javax.swing.JComboBox();
		jPanel5 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		textname = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		textintime = new javax.swing.JTextField();
		jPanel11 = new javax.swing.JPanel();
		bsave = new javax.swing.JButton();
		bcancel = new javax.swing.JButton();
		datepick1 = getDatePicker();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("退房登记结算");
		jPanel1
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("退房登记"));
		jPanel1.setLayout(new java.awt.BorderLayout());
		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("缴费结算"));
		jPanel2.setLayout(new java.awt.GridLayout(1, 2));
		jPanel6.setLayout(new java.awt.GridLayout(3, 1));
		jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel5.setText("押金");
		jPanel9.add(jLabel5);
		textforegift.setColumns(13);
		jPanel9.add(textforegift);
		jPanel6.add(jPanel9);
		jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,
				20, 5));
		jLabel6.setText("总计");
		jPanel10.add(jLabel6);
		texttotal.setColumns(13);
		jPanel10.add(texttotal);
		jPanel6.add(jPanel10);
		jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel7.setText("合计");
		jPanel8.add(jLabel7);
		textaccount.setColumns(13);
		jPanel8.add(textaccount);
		jPanel6.add(jPanel8);
		jPanel2.add(jPanel6);
		jLabel8.setText("房间价格");
		jPanel7.add(jLabel8);
		textprice.setColumns(13);
		jPanel7.add(textprice);
		jLabel9.setText("备注");
		jPanel10.add(jLabel9);
		textnote.setColumns(13);
		textnote.setRows(5);
		jScrollPane1.setViewportView(textnote);
		jPanel7.add(jScrollPane1);
		jPanel2.add(jPanel7);
		jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);
		jPanel3.setLayout(new java.awt.GridLayout(2, 1));
		jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel1.setText("\u7ed3\u8d26\u65e5\u671f");
		jPanel4.add(jLabel1);
		jPanel4.add(datepick1);
		jLabel2.setText("房间号");
		jPanel4.add(jLabel2);
		comroomid.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
		comroomid.setPreferredSize(new java.awt.Dimension(150, 23));
		jPanel4.add(comroomid);
		comroomid.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				 String roomid=comroomid.getSelectedItem().toString();
				  try{
					  connection con1=new connection();
					  con=con1.getcon();
					  sta=con.createStatement();
					  String sql="SELECT guest.姓名,guest.入住时间, guest.押金,guest.ID,room.价格  FROM room INNER JOIN guest ON room.房间号 = guest.房间号 " 
						+"where room.房间号='"+roomid+"'";
					  ResultSet rs=sta.executeQuery(sql);
					  SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
					  if(rs.next()){ 
						textname.setText(rs.getString(1));			
						textintime.setText(simpleFormat.format(rs.getDate(2)));
						int foregift=rs.getInt(3);
						textforegift.setText(foregift+"");
						inid=rs.getInt(4);
						int price=rs.getInt(5);
						textprice.setText(price+"");
						//计算时间	
						 try{
						   Date fromDate = simpleFormat.parse(textintime.getText());  
						   Date toDate = simpleFormat.parse(datepick1.getText());  

						   long from1 = fromDate.getTime();
						   long to1 = toDate.getTime();  
						   int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
						   int hours = (int) ((to1 - from1) / (1000 * 60 * 60));
						   if(days==0 && hours<24)
							   days=1;
						   sum=days*price;
						   texttotal.setText(sum+"");
						   account=sum-foregift;
						   textaccount.setText(account+"");
						   
						 }catch(ParseException e1){
							System.out.println(e1); 
						 }	 
					 }		 
				  }catch(SQLException e1){
						System.out.println(e1);
				  }	
			}
		});
		jPanel3.add(jPanel4);
		jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel3.setText("\u65c5\u5ba2\u59d3\u540d");
		jPanel5.add(jLabel3);
		textname.setColumns(13);
		jPanel5.add(textname);
		jLabel4.setText("\u5165\u4f4f\u65f6\u95f4");
		jPanel5.add(jLabel4);
		textintime.setColumns(13);
		jPanel5.add(textintime);
		jPanel3.add(jPanel5);
		jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);
		jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER,
				35, 5));
		bsave.setText("\u4fdd\u5b58");
	    jPanel11.add(bsave);
	    bsave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//退房
				SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				SimpleDateFormat sft = new SimpleDateFormat("yyyyMMddhhmmss");
				Date now=new Date();
				String outId=sft.format(now);
				int inId=inid;
				String outTime=simpleFormat.format(datepick1.getValue());
				String roomid=comroomid.getSelectedItem().toString();	
				String note=textnote.getText();
				boolean delmark=false;
					try{ 
						connection con1=new connection();
						con=con1.getcon();
						 Statement sta=con.createStatement();
						 String sql="insert into checkout values('"+outId+"',"+
						 		inId+",'"+outTime+"','"+sum+"','"+account+"','"+note+"')";
						 int c=sta.executeUpdate(sql);
							 JOptionPane.showMessageDialog(null,c==1?"退房成功，谢谢你的光临！":"退房失败");
						 sql="update room set 能否入住=1 where 房间号='"+comroomid.getSelectedItem()+"'";
						 sta.executeUpdate(sql);
						 sql="delete from guest where 房间号='"+roomid+"'";
						 sta.executeUpdate(sql);
						}catch(SQLException e1){
							System.out.println(e1);
						}
			}
		});
		bcancel.setText("清空");
		bcancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textname.setText("");
				textaccount.setText("");
				textforegift.setText("");
				textnote.setText("");
				texttotal.setText("");
				textprice.setText("");
				textintime.setText("");
			}
		});
		jPanel11.add(bcancel);
		jPanel1.add(jPanel11, java.awt.BorderLayout.SOUTH);
		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		try{
			connection con1=new connection();
			con=con1.getcon();
			sta=con.createStatement();
			 String sql="select * from guest  order by 房间号";				 
			 ResultSet rs=sta.executeQuery(sql);
			 String roomid;
			 while(rs.next()){
				roomid=rs.getString("房间号"); 
				comroomid.addItem(roomid);
			 }		
			}catch(Exception e1){
				e1.printStackTrace();
			}		
	   
		this.setPreferredSize(new Dimension(550,350));
		this.setBounds(480, 140, 550, 350);
		this.setResizable(false);
		pack();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new tuifang().setVisible(true);
			}
		});
	}

	private javax.swing.JButton bcancel;
	private javax.swing.JButton bsave;
	private javax.swing.JComboBox comroomid;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	//private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField textaccount;
	private javax.swing.JTextField textforegift;
	private javax.swing.JTextField textintime;
	private javax.swing.JTextField textname;
	private javax.swing.JTextArea textnote;
	private javax.swing.JTextField textprice;
	private javax.swing.JTextField texttotal;
	private DatePicker datepick1;
	private int sum,account, inid;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;
	

}