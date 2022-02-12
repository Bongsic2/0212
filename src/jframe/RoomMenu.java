package jframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RoomMenu {

	public RoomMenu() {
		run();
	}

	public void menu() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton btn = new JButton("메뉴");

		panel.setLayout(new BorderLayout());
		panel.add(btn);

		// 버튼 액션리스너를 이용해 run()을 호출합니다.
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		frame.add(panel);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public void run() {
		// run() 메서드가 실행되면 "대기방으로" 로 돌아가게 됩니다.
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "대기방으로 돌아갑니다!");
		// 이제 대기방으로 돌아갑니다.
	}
}
