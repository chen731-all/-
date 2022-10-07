import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class caidan extends javax.swing.JFrame {

	public caidan() {
		initComponents();
	}

	
	private void initComponents() {

		xiugai = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		yvding = new javax.swing.JMenu();
		banliyvding = new javax.swing.JMenuItem();
		chaxun = new javax.swing.JMenu();
		keren = new javax.swing.JMenuItem();
		kefang = new javax.swing.JMenuItem();
		qiantai = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		user = new javax.swing.JMenu();
		tianjiayonghu = new javax.swing.JMenuItem();
		shanchuyonghu = new javax.swing.JMenuItem();
		
		bangzhu = new javax.swing.JMenu();
		shixingbangzhu = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
		getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		xiugai.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/picture/icon1.jpg"))); // NOI18N
		getContentPane().add(
				xiugai,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -80,
						1000, 800));

		yvding.setText("\u9884\u5b9a");
		yvding.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));

		

		jMenuBar1.add(yvding);

		chaxun.setText("\u67e5\u8be2");

		keren.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		keren.setText("\u5ba2\u4eba\u4fe1\u606f(未实现)");
		keren.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//kerenActionPerformed(evt);
			}
		});
		chaxun.add(keren);

		kefang.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		kefang.setText("\u5ba2\u623f\u4fe1\u606f");
		kefang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				kefangActionPerformed(evt);
			}
		});
		chaxun.add(kefang);
		chaxun.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));

		jMenuBar1.add(chaxun);

		qiantai.setText("\u524d\u53f0");

		jMenuItem1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jMenuItem1.setText("\u5165\u4f4f");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		qiantai.add(jMenuItem1);
		qiantai.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		
		jMenuItem2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jMenuItem2.setText("\u9000\u623f");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		qiantai.add(jMenuItem2);


		jMenuBar1.add(qiantai);

		user.setText("\u7528\u6237\u7ba1\u7406");

		tianjiayonghu.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		tianjiayonghu.setText("\u6dfb\u52a0\u7528\u6237");
		tianjiayonghu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tianjiayonghuActionPerformed(evt);
			}
		});
		user.add(tianjiayonghu);

		shanchuyonghu.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		shanchuyonghu.setText("删除和修改用户");
		shanchuyonghu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				shanchuyonghuActionPerformed(evt);
			}
		});
		user.add(shanchuyonghu);
		
		user.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		
		jMenuBar1.add(user);

		bangzhu.setText("\u5e2e\u52a9");
		bangzhu.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		
		shixingbangzhu.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		shixingbangzhu.setText("\u5e2e\u52a9");
		shixingbangzhu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				shixingbangzhuActionPerformed(evt);
			}
		});
		bangzhu.add(shixingbangzhu);

		jMenuBar1.add(bangzhu);

		setJMenuBar(jMenuBar1);
		this.setPreferredSize(new Dimension(1000,700));
		this.setBounds(480, 140, 1000, 700);
		this.setResizable(false);
		pack();
	}

	private void shanchuyonghuActionPerformed(java.awt.event.ActionEvent evt) {
		//删除用户
		shanchuyonghu y=new shanchuyonghu();
		y.setVisible(true);
	}

	private void tianjiayonghuActionPerformed(java.awt.event.ActionEvent evt) {
		//添加用户
		tianjiayonnnghu y=new tianjiayonnnghu();
		y.setVisible(true);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		//退房
		tuifang y=new tuifang();
		y.setVisible(true);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		//入住
		ruzhu y=new ruzhu();
		y.setVisible(true);
	}

	private void shixingbangzhuActionPerformed(java.awt.event.ActionEvent evt) {
		//帮助
		bangzhu y = new bangzhu();
		y.setVisible(true);
	}

	private void kefangActionPerformed(java.awt.event.ActionEvent evt) {
		//客房
		kefang y=new kefang();
		y.setVisible(true);
	}

	private void kerenActionPerformed(java.awt.event.ActionEvent evt) {
		//客人
		//keren kr=new keren();
		//kr.setVisible(true);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new caidan().setVisible(true);
			}
		});
	}

	private javax.swing.JMenu bangzhu;
	private javax.swing.JMenuItem banliyvding;
	private javax.swing.JMenu chaxun;
	private javax.swing.JLabel xiugai;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem kefang;
	private javax.swing.JMenuItem keren;
	private javax.swing.JMenu qiantai;
	private javax.swing.JMenuItem shanchuyonghu;
	private javax.swing.JMenuItem shixingbangzhu;
	private javax.swing.JMenuItem tianjiayonghu;
	private javax.swing.JMenu user;
	private javax.swing.JMenu yvding;

}