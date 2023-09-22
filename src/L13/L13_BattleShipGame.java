package L13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class L13_BattleShipGame {
    private static char EMPTY = '-';
    private static char MISS = '*';
    private static char HIT = 'x';
    private static char TARGET = 'T';
    private static char[][] board;
    private static JButton[][] buttons;
    private static int hits = 0;
    private static int totalTargetCells = 0;
    private static boolean showTargets = false;

    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Введите размер поля (минимум 5):"));
        size = Math.max(5, size);
        int numShips = Integer.parseInt(JOptionPane.showInputDialog("Введите количество кораблей:"));

        board = new char[size][size];
        buttons = new JButton[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }

        Random random = new Random();
        for (int i = 0; i < numShips; i++) {
            int shipSize = random.nextInt(3) + 2;
            totalTargetCells += shipSize;
            setTarget(board, shipSize, random);
        }

        JFrame frame = new JFrame("Морской бой");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton showButton = new JButton("Показать корабли");
        showButton.addActionListener(e -> {
            showTargets = true;
            refreshBoard();
        });
        showButton.setPreferredSize(new Dimension(40, 40));  // Установка размера кнопки

        JButton hideButton = new JButton("Скрыть корабли");
        hideButton.addActionListener(e -> {
            showTargets = false;
            refreshBoard();
        });
        hideButton.setPreferredSize(new Dimension(40, 40));  // Установка размера кнопки

        gbc.weightx = 1;  // Устанавливаем пропорции для компонентов
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;  // Заполняем доступное пространство

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                gbc.gridx = j;
                gbc.gridy = i;
                if (i == 0 && j == 0) {
                    frame.add(new JLabel(""), gbc);
                } else if (i == 0) {
                    frame.add(new JLabel(String.valueOf(j), SwingConstants.CENTER), gbc);
                } else if (j == 0) {
                    frame.add(new JLabel(String.valueOf(i), SwingConstants.CENTER), gbc);
                } else {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(40, 40));  // Установка размера кнопки
                    button.addActionListener(new ButtonClickListener(i - 1, j - 1));
                    frame.add(button, gbc);
                    buttons[i - 1][j - 1] = button;
                }
            }
        }

        // добавление кнопок
        gbc.gridy = size + 1;
        gbc.gridx = size - 1;
        frame.add(showButton, gbc);

        gbc.gridx = size;
        frame.add(hideButton, gbc);

        frame.pack(); // упаковка фрейма перед отображением
        frame.setLocationRelativeTo(null); // центрирование фрейма на экране
        frame.setVisible(true);
    }

    private static void refreshBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char cell = board[i][j];
                if (cell == TARGET && showTargets) {
                    buttons[i][j].setBackground(Color.GREEN);
                } else if (cell == HIT) {
                    buttons[i][j].setBackground(Color.RED);
                } else if (cell == MISS) {
                    buttons[i][j].setBackground(Color.YELLOW);
                } else {
                    buttons[i][j].setBackground(null);
                }
            }
        }
    }

    private static boolean canPlaceShip(char[][] board, int row, int col, boolean horizontal, int size) {
        for (int i = -1; i <= size; i++) {
            for (int j = -1; j <= 1; j++) {
                int x = horizontal ? row + j : row + i;
                int y = horizontal ? col + i : col + j;

                if (x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == TARGET) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void setTarget(char[][] board, int size, Random random) {
        boolean horizontal = random.nextBoolean();
        int row, col;
        int attempts = 100;  // Максимальное количество попыток

        while (attempts-- > 0) {
            if (horizontal) {
                row = random.nextInt(board.length);
                col = random.nextInt(board.length - size + 1);
                if (canPlaceShip(board, row, col, true, size)) {
                    for (int i = 0; i < size; i++) {
                        board[row][col + i] = TARGET;
                    }
                    break;
                }
            } else {
                row = random.nextInt(board.length - size + 1);
                col = random.nextInt(board.length);
                if (canPlaceShip(board, row, col, false, size)) {
                    for (int i = 0; i < size; i++) {
                        board[row + i][col] = TARGET;
                    }
                    break;
                }
            }
        }

        if (attempts <= 0) {
            System.out.println("Не удалось разместить все корабли. Попробуйте уменьшить их количество или увеличить размер поля.");
        }
    }

    static class ButtonClickListener implements ActionListener {
        int row, col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (board[row][col] == TARGET) {
                board[row][col] = HIT;
                hits++;
                if (hits == totalTargetCells) {
                    JOptionPane.showMessageDialog(null, "Вы выиграли!");
                }
            } else if (board[row][col] == EMPTY) {
                board[row][col] = MISS;
            }
            refreshBoard();
        }
    }
}
