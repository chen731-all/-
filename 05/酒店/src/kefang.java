import java.awt.Dimension;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class kefang extends JFrame implements ActionListener{

	public kefang() {
		initComponents();
	}

	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jPanel2 = new javax.swing.JPanel();
		badd = new javax.swing.JButton();
		bedit = new javax.swing.JButton();
		bdel = new javax.swing.JButton();
		bprevious = new javax.swing.JButton();
		bnext=new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		textroomid = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		comroomtype = new javax.swing.JComboBox();
		jPanel5 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		comroomfloor = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		compersonnum = new javax.swing.JComboBox();
		jPanel6 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		comprice = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		checkflag = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel7.setText("\u5907\u6ce8    ");
		jPanel1.add(jLabel7);
		jTextArea1.setColumns(40);
		jTextArea1.setRows(10);
		jScrollPane1.setViewportView(jTextArea1);
		jPanel1.add(jScrollPane1);
		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER,
				30, 5));
		badd.setText("\u6dfb\u52a0");
		jPanel2.add(badd);
		badd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//添加
				if(badd.getText().equals("添加")){
					   textroomid.setText("");
					   comroomtype.setSelectedIndex(0);
					   comroomfloor.setSelectedIndex(0);
					   compersonnum.setSelectedIndex(0);
					   comprice.setSelectedIndex(0);
				       jTextArea1.setText("");
					   checkflag.setSelected(true);
					   badd.setText("确定");
					}else{
						try{
							connection con1=new connection();
							con=con1.getcon();
							sta=con.createStatement();
						  String roomid,roomtype,roomfloor,note;
						  int personnum,price;
						  roomid=textroomid.getText();
						  roomtype=comroomtype.getSelectedItem().toString();
						  roomfloor=comroomfloor.getSelectedItem().toString();
					      personnum=Integer.parseInt(compersonnum.getSelectedItem().toString().charAt(0)+"");
						  price=Integer.parseInt(comprice.getSelectedItem().toString());
						  note=jTextArea1.getText();
					      int flag;
					      if(checkflag.isSelected())
					    	  flag=1;
					      else
					    	  flag=0;
						  String sql="insert into room values('"+roomid+"','"+roomtype+"',"+personnum+","+price+","+flag+",'"+note+"','"+roomfloor+"')";
						  int c=sta.executeUpdate(sql);
						 JOptionPane.showMessageDialog(null,c==1?"房间信息添加成功！":"添加失败");
						}catch(SQLException e1){	
							e1.printStackTrace();
					    }	
					}
			}
		});
		bedit.setText("\u4fee\u6539");
		bprevious.setText("上一个");
		jPanel2.add(bprevious);
		bprevious.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//上一条 
				String roomid=textroomid.getText(); 
				String sql;
				if(!roomid.equals("")){
				  try{
					  connection con1=new connection();
						con=con1.getcon();
						sta=con.createStatement();
					  String roomtype,roomfloor,note;
					  int personnum,price;
					  int flag;	
					  sql="select * from room where 房间号<'"+roomid+"' order by 房间号 desc";
					  rs=sta.executeQuery(sql);
					  if(rs.next()){
						  textroomid.setText(rs.getString("房间号"));
					      comroomtype.setSelectedItem(rs.getString("房间类型"));
					      comroomfloor.setSelectedItem(rs.getString("楼层"));
				          compersonnum.setSelectedIndex(rs.getInt("人数")-1);    
					      comprice.setSelectedItem(rs.getString("价格"));
					      jTextArea1.setText(rs.getString("备注"));
				          if(rs.getInt("能否入住")==1)
					        checkflag.setSelected(true);
				          else
				            checkflag.setSelected(false); 
				      }
					  	   			  				  
			   }catch(SQLException e1){
				 e1.printStackTrace();
			   }
			} else
				  showfirst();			
				  
			}
		});
		bnext.setText("下一个");
		jPanel2.add(bnext);
		bnext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//下一条  
				String roomid=textroomid.getText(); 
				String sql;
				if(!roomid.equals("")){
				  try{
					  connection con1=new connection();
						con=con1.getcon();
						sta=con.createStatement();
					  String roomtype,roomfloor,note;
					  int personnum,price;
					  int flag;
					  sql="select * from room where 房间号>'"+roomid+"' order by 房间号 asc";
					  rs=sta.executeQuery(sql);
					  if(rs.next()){
						  textroomid.setText(rs.getString("房间号"));
					      comroomtype.setSelectedItem(rs.getString("房间类型"));
					      comroomfloor.setSelectedItem(rs.getString("楼层"));
				          compersonnum.setSelectedIndex(rs.getInt("人数")-1);    
					      comprice.setSelectedItem(rs.getString("价格"));
					      jTextArea1.setText(rs.getString("备注"));
					      if(rs.getInt("能否入住")==1)
						        checkflag.setSelected(true);
					          else
					            checkflag.setSelected(false); 
				      }
					  	   			  				  
			   }catch(SQLException e1){
				   e1.printStackTrace();
				}
			}else
				 showend();			
			}
		});
		jPanel2.add(bedit);
		bedit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//修改
				String roomid=textroomid.getText(); 
				if(!roomid.equals("")){//当前房间号不为空
				  try{
					  connection con1=new connection();
						con=con1.getcon();
						sta=con.createStatement();
					  String roomtype,roomfloor,note;
					  int personnum,price;
					  int rflag;
					  if(checkflag.isSelected())
					      rflag=1;
				      else
				          rflag=0; 
					  roomtype=comroomtype.getSelectedItem().toString();
					  roomfloor=comroomfloor.getSelectedItem().toString();
				      personnum=Integer.parseInt(compersonnum.getSelectedItem().toString().charAt(0)+"");
					  price=Integer.parseInt(comprice.getSelectedItem().toString());
					  note=jTextArea1.getText();			
					  String sql="update room set 房间号='"+roomtype+"',楼层='"+roomfloor+"',人数="+personnum+",价格="+price+",备注='"+note+"',能否入住="+rflag+" where 房间号='"+roomid+"'";			  			  
					  System.out.println(sql);
					  int c=sta.executeUpdate(sql);
					  JOptionPane.showMessageDialog(null,c==1?"数据修改成功！":"修改失败");
					  con.close();   			  				  
			   }catch(SQLException e1){
				  e1.printStackTrace();
				}
			  }
			}
		});
		bdel.setText("\u5220\u9664");
		jPanel2.add(bdel);	
		bdel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//删除
				String roomid=textroomid.getText(); 
				String sql;
				if(!roomid.equals("")){//当前房间号不为空
				   try{
					   connection con1=new connection();
						con=con1.getcon();
						sta=con.createStatement();		  
						
						sql="delete from room where 房间号='"+roomid+"'";
						int c =sta.executeUpdate(sql);
						   JOptionPane.showMessageDialog(null,c==1?"数据删除完毕！":"删除失败");
						   showend();	
						con.close();
					}catch(SQLException e1){
						  e1.printStackTrace();
					 }
					}	
			}
		});
		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
		jPanel3.setLayout(new java.awt.GridLayout(3, 1));
		jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel1.setText("\u623f\u95f4\u53f7  ");
		jPanel4.add(jLabel1);
		textroomid.setColumns(10);
		jPanel4.add(textroomid);
		jLabel2.setText("\u623f\u95f4\u7c7b\u578b");
		jPanel4.add(jLabel2);
		comroomtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"单人间", "标准间", "三人间", "豪华间" }));
		comroomtype.setPreferredSize(new java.awt.Dimension(120, 23));
		jPanel4.add(comroomtype);
		jPanel3.add(jPanel4);
		jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel3.setText("\u697c\u5c42    ");
		jPanel5.add(jLabel3);
		comroomfloor.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "一楼", "二楼", "三楼", "四楼", "五楼"}));
		comroomfloor.setPreferredSize(new java.awt.Dimension(120, 23));
		jPanel5.add(comroomfloor);
		jLabel4.setText("\u53ef\u4f4f\u4eba\u6570");
		jPanel5.add(jLabel4);
		compersonnum.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "1人", "2人", "3人", "4人" }));
		compersonnum.setPreferredSize(new java.awt.Dimension(120, 23));
		jPanel5.add(compersonnum);
		jPanel3.add(jPanel5);
		jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20,
				5));
		jLabel5.setText("\u4ef7\u683c    ");
		jPanel6.add(jLabel5);
		comprice.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"200", "400", "600", "800","1000" }));
		comprice.setPreferredSize(new java.awt.Dimension(120, 23));
		jPanel6.add(comprice);
		jLabel6.setText("\u623f\u95f4\u72b6\u6001");
		jPanel6.add(jLabel6);
		checkflag.setText("\u7a7a\u623f");
		jPanel6.add(checkflag);
		jPanel3.add(jPanel6);
		getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);
		this.setTitle("酒店客房");
		showfirst();
		bprevious.addActionListener(this);
		bnext.addActionListener(this);
		this.setPreferredSize(new Dimension(500,450));
		this.setBounds(480, 140, 500, 450);
		this.setResizable(false);
		pack();
	}
	public void showfirst(){
		try{
			connection con1=new connection();
			con=con1.getcon();
			sta=con.createStatement();
		      String sql="select * from room  order by 房间号 asc "; 
			  ResultSet rs=sta.executeQuery(sql);
			  String id="";
			  if(rs.next())
			    id=rs.getString("房间号");
			  sql="select * from room where 房间号='"+id+"'";
			  rs=sta.executeQuery(sql);
			  if(rs.next()){
			    textroomid.setText(rs.getString("房间号"));
		        comroomtype.setSelectedItem(rs.getString("房间类型"));
		        comroomfloor.setSelectedItem(rs.getString("楼层"));
		        compersonnum.setSelectedIndex(rs.getInt("人数")-1);    
			    comprice.setSelectedItem(rs.getString("价格"));
		        jTextArea1.setText(rs.getString("备注"));
	           if(rs.getInt("能否入住")==1)
		        checkflag.setSelected(true);
	           else
	            checkflag.setSelected(false);
			  }	  	
		    }catch(Exception e2){
		    	e2.printStackTrace();
		    }
	}
	public void showend(){
		try{
			connection con1=new connection();
			con=con1.getcon();
			sta=con.createStatement();
		      String sql="select * from room  order by 房间号 desc "; 
			  ResultSet rs=sta.executeQuery(sql);
			  String id="";
			  if(rs.next())
			    id=rs.getString("房间号");
			  sql="select * from Room where roomId='"+id+"'";
			  rs=sta.executeQuery(sql);
			  if(rs.next()){
			    textroomid.setText(rs.getString("房间号"));
		        comroomtype.setSelectedItem(rs.getString("房屋类型"));
		        comroomfloor.setSelectedItem(rs.getString("楼层"));
		        compersonnum.setSelectedIndex(rs.getInt("人数")-1);    
			    comprice.setSelectedItem(rs.getString("价格"));
		        jTextArea1.setText(rs.getString("备注"));
	           if(rs.getInt("能否入住")==1)
		        checkflag.setSelected(true);
	           else
	            checkflag.setSelected(false);
			  }	  	
		   }catch(SQLException e2){
		    	e2.printStackTrace();
		    }
	}
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new kefang().setVisible(true);
			}
		});
	}

	private javax.swing.JButton badd;
	private javax.swing.JButton bdel;
	private javax.swing.JButton bedit;
	private javax.swing.JButton bprevious,bnext;
	private javax.swing.JCheckBox checkflag;
	private javax.swing.JComboBox compersonnum;
	private javax.swing.JComboBox comprice;
	private javax.swing.JComboBox comroomfloor;
	private javax.swing.JComboBox comroomtype;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField textroomid;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;
	
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==bnext){
				
		}		

	}
}