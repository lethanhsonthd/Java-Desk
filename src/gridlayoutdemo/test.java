/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridlayoutdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author son
 */
public class test extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public test() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package gridlayoutdemo ;

    import java.awt.Desktop ;
    import java.awt.event.ActionEvent ;
    import java.awt.event.ActionListener ;
    import java.util.Vector ;
    import javax.swing.JButton ;
    import javax.swing.JFrame ;
    import javax.swing.JOptionPane ;

    /**
     *
     * @author son
     */
    public class GridLayout extends javax.swing.JFrame {

        public int col = 3, row = 3;

        /**
         * Creates new form GridLayout
         */
        public GridLayout() {
            initComponents();
            setLayoutAndAddButton(row, col);
        }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setPreferredSize(new java.awt.Dimension(367, 367));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GridLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GridLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GridLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GridLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

        private void setLayoutAndAddButton(int row, int col) {
            panel.setLayout(new java.awt.GridLayout(row, col));
            for (int i = 1; i < row * col; i++) {
                MyButton t = new MyButton(i + "");
                t.addActionListener(t);
                panel.add(t);
            }
            MyButton t = new MyButton("");
            t.addActionListener(t);
            panel.add(t);
            randomGame();
        }

        private void randomGame() {
            int currentIndex = -9999;
            int[] rd = {1, -1, -col, +col};
            for (int loop = 0; loop < 1000; loop++) {
                for (int i = 0; i < row * col; i++) {
                    JButton temp = (JButton) panel.getComponent(i);
                    if (temp.getText().equals("")) {
                        currentIndex = i;
                        break;
                    }
                }
                int randomDirect = (int) (Math.round(Math.random() * 10000) % 4);
                if (canSwap(currentIndex, currentIndex + rd[randomDirect])) {
                    swap(currentIndex, currentIndex + rd[randomDirect]);
                }
            }
        }

        private void swap(int firstIndex, int secondIndex) {
            if (firstIndex == secondIndex) {
                return;
            }
            if (firstIndex > secondIndex) {
                int temp = firstIndex;
                firstIndex = secondIndex;
                secondIndex = temp;
            }
            MyButton first = (MyButton) panel.getComponent(firstIndex);
            MyButton second = (MyButton) panel.getComponent(secondIndex);
            panel.remove(first);
            panel.remove(second);
            panel.add(second, firstIndex);
            panel.add(first, secondIndex);
            panel.updateUI();
        }

        private boolean canSwap(int firstIndex, int secondIndex) {
            if (firstIndex < 0 || firstIndex >= row * col || secondIndex < 0 || secondIndex >= row * col) {
                return false;
            }
            if (Math.abs(firstIndex - secondIndex) == 1 && checkInline(firstIndex, secondIndex)) {
                return true;
            }
            if (Math.abs(firstIndex - secondIndex) == col) {
                return true;
            }
            return false;
        }

        private boolean checkInline(int firstIndex, int secondIndex) {
            if (firstIndex > secondIndex) {
                int temp = firstIndex;
                firstIndex = secondIndex;
                secondIndex = temp;
            }
            for (int i = 0; i <= 1000; i++) {
                int lower = i * col;
                int upper = i * col + col - 1;
                if (lower <= firstIndex && secondIndex <= upper) {
                    return true;
                }
            }
            return false;
        }

        private boolean isWin() {
            for (int i = 1; i < row * col - 1; i++) {
                try {
                    MyButton t1 = (MyButton) panel.getComponent(i);
                    MyButton t0 = (MyButton) panel.getComponent(i - 1);
                    if (Integer.parseInt(t1.getText()) != Integer.parseInt(t0.getText()) + 1) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }

        class MyButton extends JButton implements ActionListener {

            public MyButton(String text) {
                super(text);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int currentIndex = -9999;
                for (int i = 0; i < row * col; i++) {
                    JButton temp = (JButton) panel.getComponent(i);
                    if (temp.getText().equals(this.getText())) {
                        currentIndex = i;
                        break;
                    }
                }
                for (int i = 0; i < row * col; i++) {
                    JButton temp = (JButton) panel.getComponent(i);
                    if (temp.getText().equals("")) {
                        if (canSwap(i, currentIndex)) {
                            swap(i, currentIndex);
                            if (isWin()) {
                                JOptionPane.showMessageDialog(null, "Congratulation!");
                                break;
                            }
                            break;
                        }
                    }
                }
            }

        }
    }
}