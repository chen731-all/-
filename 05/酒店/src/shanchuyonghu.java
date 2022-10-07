import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class shanchuyonghu extends javax.swing.JFrame {

	
	public shanchuyonghu() {
		initComponents();
	}

	
	
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jf_yhm = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jf_czy = new javax.swing.JTextField();
		jf_mm = new javax.swing.JPasswordField();
		btn_q = new javax.swing.JButton();
		btn_delete = new javax.swing.JButton();
		btn_alter = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u5220\u9664\u548c\u4fee\u6539\u7528\u6237");
		getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("\u7528\u6237\u540d\uff1a");
		getContentPane().add(
				jLabel1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1,
						-1));

		jLabel2.setText("\u5bc6    \u7801\uff1a");
		getContentPane().add(
				jLabel2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1,
						-1));

		jf_yhm.setColumns(20);
		jf_yhm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		getContentPane().add(
				jf_yhm,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1,
						-1));

		jLabel3.setText("\u64cd\u4f5c\u5458\uff1a");
		getContentPane().add(
				jLabel3,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1,
						-1));

		jf_czy.setColumns(20);
		jf_czy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		getContentPane().add(
				jf_czy,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1,
						-1));

		jf_mm.setColumns(20);
		jf_mm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		getContentPane().add(
				jf_mm,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1,
						-1));

		btn_q.setText("\u6e05\u7a7a");
		btn_q.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_qActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_q,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1,
						-1));

		btn_delete.setText("\u5220\u9664");
		btn_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_deleteActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_delete,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1,
						-1));

		btn_alter.setText("\u4fee\u6539");
		btn_alter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_alterActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_alter,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1,
						-1));
		this.setPreferredSize(new Dimension(450,300));
		this.setBounds(480, 140, 450, 300);
		this.setResizable(false);
		pack();
	}

	private void btn_alterActionPerformed(java.awt.event.ActionEvent evt) {
		//修改用户
		int s=JOptionPane.showConfirmDialog(this,"确定修改用户？");
		if(s==JOptionPane.YES_OPTION){
			String zh=jf_yhm.getText();
			String mm=String.valueOf(jf_mm.getPassword());
			String czy=jf_czy.getText();
			if(zh.equals("")){
				if(mm.equals("")){
					if(czy.equals("")){
						JOptionPane.showMessageDialog(this, "账号，密码和操作员不能为空");
					}
					else{
						JOptionPane.showMessageDialog(this, "账号和密码不能为空");
					}
				}else if(czy.equals("")){
					if(mm.equals("")){
						JOptionPane.showMessageDialog(this, "账号，密码和操作员不能为空");
					}else{
						JOptionPane.showMessageDialog(this, "账号和操作员不能为空");
					}
				}else{
					JOptionPane.showMessageDialog(this, "账号不能为空");
				}
			}else if(mm.equals("")){
				if(czy.equals("")){
					JOptionPane.showMessageDialog(this, "密码和操作员不能为空");
				}else{
					JOptionPane.showMessageDialog(this, "密码不能为空");
				}
			}else if(czy.equals("")){
				JOptionPane.showMessageDialog(this, "操作员不能为空");
			}else{
				try {
					connection con1=new connection();
					con=con1.getcon();
					sta=con.createStatement();
					String sql1="select * from user where 账号='"+zh+"'";
					rs=sta.executeQuery(sql1);
					if(rs.next()){
						String sql="update user set 密码='"+mm+"',操作员='"+czy+"' where 账号='"+zh+"'";
						int c=sta.executeUpdate(sql);
						JOptionPane.showMessageDialog(this,c==1?"修改成功":"修改失败");
					}else
						JOptionPane.showMessageDialog(this, "账号不存在");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {
		//删除用户
		int s=JOptionPane.showConfirmDialog(this,"确定删除用户？");
		if(s==JOptionPane.YES_OPTION){
			String s1=jf_yhm.getText();
			String czy=jf_czy.getText();
			if(s1.equals("")){
				JOptionPane.showMessageDialog(this, "账号不能为空");
			}else if(czy.equals("")){
				JOptionPane.showMessageDialog(this, "操作员不能为空");
			}else{
				try {
					connection con1=new connection();
					con=con1.getcon();
					sta=con.createStatement();
					String sql1="select * from user where 账号='"+s1+"'";
					rs=sta.executeQuery(sql1);
					if(rs.next()){
						String sql="delete from user where 账号='"+s1+"'";
						int c=sta.executeUpdate(sql);
						JOptionPane.showMessageDialog(this,c==1?"删除成功":"删除失败");
					}else
						JOptionPane.showMessageDialog(this, "账号不存在");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	void btn_qActionPerformed(java.awt.event.ActionEvent evt) {
		//清空
		jf_yhm.setText("");
		jf_mm.setText("");
		jf_czy.setText("");
		jf_yhm.requestFocus();
	}
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new shanchuyonghu().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btn_alter;
	private javax.swing.JButton btn_delete;
	private javax.swing.JButton btn_q;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JTextField jf_czy;
	private javax.swing.JPasswordField jf_mm;
	private javax.swing.JTextField jf_yhm;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;
	// End of variables declaration//GEN-END:variables

}