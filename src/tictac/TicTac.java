package tictac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTac {

	int boardWidth = 600;
	int boardHeight = 650;
	JFrame frame = new JFrame();
	JPanel boardPanel = new JPanel();
	JButton[][] board = new JButton[3][3];
	String playerX = "X";
	String playerO = "O";
	String currentPlayer = playerX;
	JLabel textLable = new JLabel();
	JPanel textPanel = new JPanel();
	boolean gameOver = false;

	TicTac() {
		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		boardPanel.setLayout(new GridLayout(3, 3));
		boardPanel.setBackground(Color.blue);
		frame.add(boardPanel);
		textLable.setBackground(Color.gray);
		textLable.setText("hello");
		textLable.setFont(new Font("Arial", Font.BOLD, 70));
		textLable.setHorizontalAlignment(JLabel.CENTER);
		textLable.setOpaque(true);
		textPanel.setLayout(new BorderLayout());
		textPanel.add(textLable);
		frame.add(textPanel, BorderLayout.NORTH);

		for (JButton[] i : board) {
			for (JButton j : i) {
				JButton jb = new JButton();
				j = jb;
				boardPanel.add(jb);
				jb.setForeground(Color.black);
				jb.setFont(new Font("Arial", Font.BOLD, 50));
//				jb.setText(currentPlayer);

				jb.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (gameOver)
							return;
						JButton b = (JButton) e.getSource();
						if (b.getText() == "") {
							b.setText(currentPlayer);

							//checkWinner();
							if (!gameOver) {
								currentPlayer = currentPlayer == playerX ? playerO : playerX;
								textLable.setText(currentPlayer + " Turn");
							}

						}

					}
				});
			}
		}

	}

	void checkWinner() {
		// horizontal
		for (int i = 0; i < 3; i++) {

			if (board[i][0].getText() == "")
				continue;

			if (board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()) {
				gameOver = true;
				return;
			}

		}
	}

}
