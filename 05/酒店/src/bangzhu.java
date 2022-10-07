import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class bangzhu extends javax.swing.JFrame {

	public bangzhu() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		btn_q = new javax.swing.JButton();
		btn_t = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u5e2e\u52a9");
		getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("\u7528  \u6237  \u540d\uff1a");
		getContentPane().add(
				jLabel1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1,
						-1));

		jTextField1.setColumns(10);
		getContentPane().add(
				jTextField1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 180,
						-1));

		jLabel2.setText("\u9047\u5230\u95ee\u9898\uff1a");
		getContentPane().add(
				jLabel2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1,
						-1));

		jTextArea1.setColumns(10);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		getContentPane().add(
				jScrollPane1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180,
						-1));

		btn_q.setText("\u6e05\u7a7a");
		btn_q.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_qActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_q,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1,
						-1));

		btn_t.setText("\u63d0\u4ea4");
		btn_t.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_tActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_t,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1,
						-1));
		this.setPreferredSize(new Dimension(400,300));
		this.setBounds(480, 140, 400, 300);
		this.setResizable(false);
		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void btn_tActionPerformed(java.awt.event.ActionEvent evt) {
		String s=jTextField1.getText();
		String s1=jTextArea1.getText();
		if(s.equals("")){
			JOptionPane.showMessageDialog(this, "用户名不能为空！！！");
		}else if(s1.equals("")){
			JOptionPane.showMessageDialog(this, "遇到的问题不能为空！！！");
		}else{
			try {
				connection con1=new connection();
				con=con1.getcon();
				sta=con.createStatement();
				String sql="INSERT INTO wen values('"+s+"','"+s1+"')";
				int c=sta.executeUpdate(sql);
				JOptionPane.showMessageDialog(this,c==1?"插入成功":"插入失败");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void btn_qActionPerformed(java.awt.event.ActionEvent evt) {
		jTextField1.setText("");
		jTextArea1.setText("");
		jTextField1.requestFocus();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new bangzhu().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btn_q;
	private javax.swing.JButton btn_t;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;

}