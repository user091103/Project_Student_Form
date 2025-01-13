package controller;

import Swing.PanelBorder;
import Swing.PanelGradiente;
import Swing.PanelSlide;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;
import view.Register;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        Login login = new Login();
        Register register = new Register();
        slide.setAnimate(10);
        slide.init(login, register);
        login.addEventRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //  Show register form
                slide.show(1);
            }
        });
        register.addEventBackLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                slide.show(0);

            }
        });

        register.backLoginBT(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                slide.show(0);

            }
        });
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelRight = new javax.swing.JPanel();
        panelGradiente = new Swing.PanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        addressInfoLabel1 = new javax.swing.JLabel();
        addressInfoLabel2 = new javax.swing.JLabel();
        emailInfoLabel = new javax.swing.JLabel();
        labelLeft = new javax.swing.JPanel();
        panelBorder2 = new Swing.PanelBorder();
        slide = new Swing.PanelSlide();
        exitBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(154, 182, 207));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        labelRight.setBackground(new java.awt.Color(69, 103, 134));
        labelRight.setPreferredSize(new java.awt.Dimension(400, 500));

        panelGradiente.setColorPrimario(new java.awt.Color(154, 182, 207));
        panelGradiente.setColorSecundario(new java.awt.Color(69, 103, 134));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\ProjectCSE203\\src\\Icon\\eiu_moddle.png")); // NOI18N
        panelGradiente.add(jLabel1);
        jLabel1.setBounds(60, 180, 290, 70);

        addressInfoLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        addressInfoLabel1.setForeground(new java.awt.Color(255, 255, 255));
        addressInfoLabel1.setText("Địa chỉ: Đường Nam Kỳ Khởi Nghĩa, ");
        panelGradiente.add(addressInfoLabel1);
        addressInfoLabel1.setBounds(100, 400, 210, 18);

        addressInfoLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        addressInfoLabel2.setForeground(new java.awt.Color(255, 255, 255));
        addressInfoLabel2.setText("Phường Hòa Phú, Thành phố mới Bình Dương, Tỉnh Bình Dương.");
        panelGradiente.add(addressInfoLabel2);
        addressInfoLabel2.setBounds(20, 420, 360, 18);

        emailInfoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailInfoLabel.setText("Email: moodle@eiu.edu.vn");
        panelGradiente.add(emailInfoLabel);
        emailInfoLabel.setBounds(110, 470, 190, 20);

        javax.swing.GroupLayout labelRightLayout = new javax.swing.GroupLayout(labelRight);
        labelRight.setLayout(labelRightLayout);
        labelRightLayout.setHorizontalGroup(
            labelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        labelRightLayout.setVerticalGroup(
            labelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        jPanel1.add(labelRight);
        labelRight.setBounds(0, 0, 400, 500);

        labelLeft.setBackground(new java.awt.Color(154, 182, 207));
        labelLeft.setPreferredSize(new java.awt.Dimension(400, 500));

        panelBorder2.setMinimumSize(new java.awt.Dimension(300, 400));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        panelBorder2.add(slide);
        slide.setBounds(10, 10, 280, 410);

        javax.swing.GroupLayout labelLeftLayout = new javax.swing.GroupLayout(labelLeft);
        labelLeft.setLayout(labelLeftLayout);
        labelLeftLayout.setHorizontalGroup(
            labelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelLeftLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        labelLeftLayout.setVerticalGroup(
            labelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1.add(labelLeft);
        labelLeft.setBounds(400, 30, 400, 500);

        exitBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exitBT.setForeground(new java.awt.Color(0, 58, 98));
        exitBT.setContentAreaFilled(false);
        exitBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTActionPerformed(evt);
            }
        });
        jPanel1.add(exitBT);
        exitBT.setBounds(750, 10, 40, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTActionPerformed
        dispose();
        this.setVisible(false);
    }//GEN-LAST:event_exitBTActionPerformed
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressInfoLabel1;
    private javax.swing.JLabel addressInfoLabel2;
    private javax.swing.JLabel emailInfoLabel;
    private javax.swing.JButton exitBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel labelLeft;
    private javax.swing.JPanel labelRight;
    private Swing.PanelBorder panelBorder2;
    private Swing.PanelGradiente panelGradiente;
    private Swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
