package jframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EndMenu {

	public EndMenu() {
	run();
	}

	public void endFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton btn1 = new JButton("종료하기");

		panel.setLayout(new BorderLayout());
		panel.add(btn1, BorderLayout.CENTER);
		frame.add(panel);
		// 버튼 액션리스너를 이용해서 run()을 호출합니다.
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		frame.setTitle("종료");
		frame.setVisible(true);
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public void run() {
		// 이 메서드는 "종료 버튼"을 누르면 나타나는 결과를 구현한 메서드입니다.
		JFrame frame = new JFrame();

		int result = JOptionPane.showConfirmDialog(frame, "정말 종료하시겠습니까?");

		if (result == 0) {
			System.exit(0);
		} else if (result == 1 || result == 2) {
			System.out.println("게임화면으로 돌아갑니다.");
		}
	}
}
