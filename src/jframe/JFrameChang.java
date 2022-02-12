package jframe;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameChang extends JFrame {
	JButton roomBtn, EndBtn;
	Container c = getContentPane();

	public JFrameChang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200, 720);
		setVisible(true);
		c.setLayout(null);

		roomBtn = new JButton("대기창");
		roomBtn.setSize(200, 200);
		roomBtn.setLocation(500, 500);

		c.add(roomBtn);
	}

}
