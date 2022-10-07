import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class tianjiayonnnghu extends javax.swing.JFrame {

	/** Creates new form tianjiayonnnghu */
	public tianjiayonnnghu() {
		initComponents();
	}


	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		btn_clear = new javax.swing.JButton();
		btn_zhi = new javax.swing.JButton();
		jf_zh = new javax.swing.JTextField();
		jf_czy = new javax.swing.JTextField();
		jf_mm = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u5220\u9664\u7528\u6237");
		setAlwaysOnTop(true);
		getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("\u8d26   \u53f7\uff1a");
		getContentPane().add(
				jLabel1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1,
						-1));

		jLabel2.setText("\u5bc6   \u7801\uff1a");
		getContentPane().add(
				jLabel2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1,
						30));

		jLabel3.setText("\u64cd\u4f5c\u5458\uff1a");
		getContentPane().add(
				jLabel3,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1,
						-1));

		btn_clear.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btn_clear.setText("\u6e05    \u7a7a");
		btn_clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_clearActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_clear,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1,
						-1));

		btn_zhi.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btn_zhi.setText("\u6267\u884c\u64cd\u4f5c");
		btn_zhi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_zhiActionPerformed(evt);
			}
		});
		getContentPane().add(
				btn_zhi,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1,
						-1));

		jf_zh.setColumns(20);
		jf_zh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		getContentPane().add(
				jf_zh,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1,
						-1));

		jf_czy.setColumns(20);
		getContentPane().add(
				jf_czy,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1,
						-1));

		jf_mm.setColumns(20);
		jf_mm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		getContentPane().add(
				jf_mm,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1,
						-1));
		this.setTitle("����û�");
		this.setPreferredSize(new Dimension(500,350));
		this.setBounds(480, 140, 500, 350);
		this.setResizable(false);
		pack();
	}

	private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {
		//���
		jf_zh.setText("");
		jf_czy.setText("");
		jf_mm.setText("");
		jf_zh.requestFocus();
	}

	void btn_zhiActionPerformed(java.awt.event.ActionEvent evt) {
		//�����û���Ϣ
		int s=JOptionPane.showConfirmDialog(this,"ȷ�������û���");
		if(s==JOptionPane.YES_OPTION){
			String zh=jf_zh.getText();
			String mm=String.valueOf(jf_mm.getPassword());
			String czy=jf_czy.getText();
			if(zh.equals("")){
				if(mm.equals("")){
					if(czy.equals("")){
						JOptionPane.showMessageDialog(this, "�˺ţ�����Ͳ���Ա����Ϊ��");
					}
					else{
						JOptionPane.showMessageDialog(this, "�˺ź����벻��Ϊ��");
					}
				}else if(czy.equals("")){
					if(mm.equals("")){
						JOptionPane.showMessageDialog(this, "�˺ţ�����Ͳ���Ա����Ϊ��");
					}else{
						JOptionPane.showMessageDialog(this, "�˺źͲ���Ա����Ϊ��");
					}
				}else{
					JOptionPane.showMessageDialog(this, "�˺Ų���Ϊ��");
				}
			}else if(mm.equals("")){
				if(czy.equals("")){
					JOptionPane.showMessageDialog(this, "����Ͳ���Ա����Ϊ��");
				}else{
					JOptionPane.showMessageDialog(this, "���벻��Ϊ��");
				}
			}else if(czy.equals("")){
				JOptionPane.showMessageDialog(this, "����Ա����Ϊ��");
			}else {
				try {
					connection con1=new connection();
					con=con1.getcon();
					sta=con.createStatement();
					String sql1="select * from user where �˺�='"+zh+"'";
					rs=sta.executeQuery(sql1);
					if(!rs.next()){
						String sql="INSERT INTO user values('"+zh+"','"+mm+"','"+czy+"')";
						int c=sta.executeUpdate(sql);
						JOptionPane.showMessageDialog(this,c==1?"����ɹ�":"����ʧ��");
					}else
						JOptionPane.showMessageDialog(this, "�˺��Ѵ���");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new tianjiayonnnghu().setVisible(true);
			}
		});
	}

	private javax.swing.JButton btn_clear;
	private javax.swing.JButton btn_zhi;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPasswordField jf_mm;
	private javax.swing.JTextField jf_zh;
	private javax.swing.JTextField jf_czy;
	private Connection con;
	private java.sql.Statement sta;
	private ResultSet rs;
}