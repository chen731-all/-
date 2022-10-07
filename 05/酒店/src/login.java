import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;


public class login extends javax.swing.JFrame {

	/** Creates new form login */
	public login() {
		initComponents();
	}

	
	private void initComponents() {

		jlt = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jl1 = new javax.swing.JLabel();
		jl2 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();
		jTextField1 = new javax.swing.JTextField();
		btn1 = new javax.swing.JButton();
		btn2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u9152\u5e97\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
		setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
		setMinimumSize(new java.awt.Dimension(920, 690));
		getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		jlt.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/picture/icon.jpg"))); // NOI18N
		getContentPane().add(
				jlt,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000,
						300));

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 36));
		jLabel1.setText("\u9152\u5e97\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
		getContentPane().add(
				jLabel1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310,
						300, -1));

		jl1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jl1.setText("\u767b\u5f55\uff1a");
		getContentPane().add(
				jl1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1,
						-1));

		jl2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jl2.setText("\u5bc6\u7801\uff1a");
		getContentPane().add(
				jl2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1,
						-1));

		jPasswordField1.setColumns(20);
		getContentPane().add(
				jPasswordField1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440,
						190, -1));

		jTextField1.setColumns(20);
		getContentPane().add(
				jTextField1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400,
						190, -1));

		btn1.setText("\u767b\u5f55");
		btn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String s=jTextField1.getText();
				String s1=new String(jPasswordField1.getPassword());
				if(s.equals("")&&s1.equals("")){
					JOptionPane.showMessageDialog(null, "你输入的信息不完整!!!\n请输入管理员账号和密码!!!");
				}else{
					try {
						connection con1=new connection();
						con=con1.getcon();
						sta=con.createStatement();
						String sql="select * from user where 账号='"+s+"' and 密码='"+s1+"'";
						rs=sta.executeQuery(sql);
						if(rs.next()){
							caidan m=new caidan();
							m.setVisible(true)	;
						}else{
							JOptionPane.showMessageDialog(null, "你输入的用户名和密码不正确，请重新输入！");
							jTextField1.setText("");
							jPasswordField1.setText("");
							jTextField1.requestFocus();
						  }

						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		getContentPane().add(
				btn1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, -1,
						-1));

		btn2.setText("\u9000\u51fa");
		btn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		getContentPane().add(
				btn2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, -1,
						-1));
		this.setResizable(false);
		this.setBounds(480, 140, 920, 690);
		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new login().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btn1;
	private javax.swing.JButton btn2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JLabel jl1;
	private javax.swing.JLabel jl2;
	private javax.swing.JLabel jlt;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;

	
	

}