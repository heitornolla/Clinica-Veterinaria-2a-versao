/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Especie;
import model.EspecieDAO;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author Naty
 */
public class Busca extends javax.swing.JFrame {

    /**
     * Creates new form Cadastrar
     */
    public Busca() {
        initComponents();
        this.myInitComponents();
        initDocumentListenerField1AllTables();
    }
    
    int janelaAtual = 0;
    
    private void myInitComponents() {
        initTable();
        initTable2();
        initTable3();
        initTable4();
        initTable5();
        initWindowChangeListener();
       
        TableColumn colunaId = jTable1.getColumnModel().getColumn(0);
        colunaId.setPreferredWidth(30);
        colunaId.setMaxWidth(30);
        colunaId.setMinWidth(30);
        setLocationRelativeTo(null);
    }
    
    private void initWindowChangeListener() {
        jTabbedPane1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                janelaAtual = jTabbedPane1.getSelectedIndex();
                System.out.println("Usuário está na aba: " + janelaAtual);
            }
        });
    }
    
    private void initTable() {
        Controller.setTableModel(jTable1, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
        TableColumn colunaId = jTable1.getColumnModel().getColumn(0);
        colunaId.setPreferredWidth(30);
        colunaId.setMaxWidth(30);
        colunaId.setMinWidth(30);
    }
    
    private void initTable2() {
        Controller.setTableModel(jTable2, new AnimalTableModel(AnimalDAO.getInstance().retrieveAll()));
        TableColumn colunaId = jTable2.getColumnModel().getColumn(0);
        colunaId.setPreferredWidth(30);
        colunaId.setMaxWidth(30);
        colunaId.setMinWidth(30);
    }
    
    private void initTable3() {
        Controller.setTableModel(jTable3, new VetTableModel(VeterinarioDAO.getInstance().retrieveAll()));
        TableColumn colunaId = jTable3.getColumnModel().getColumn(0);
        colunaId.setPreferredWidth(30);
        colunaId.setMaxWidth(30);
        colunaId.setMinWidth(30);
    }
    
    private void initTable4() {
        Controller.setTableModel(jTable4, new EspecieTableModel(EspecieDAO.getInstance().retrieveAll()));
        TableColumn colunaId = jTable4.getColumnModel().getColumn(0);
        colunaId.setPreferredWidth(30);
        colunaId.setMaxWidth(30);
        colunaId.setMinWidth(30);
    }
    
    private void initTable5() {
        Controller.setTableModel(jTable5, new ConsultaTableModel(ConsultaDAO.getInstance().retrieveAll()));
        TableColumn colunaId = jTable5.getColumnModel().getColumn(0);
        colunaId.setPreferredWidth(30);
        colunaId.setMaxWidth(30);
        colunaId.setMinWidth(30);
    }
    
    private void initDocumentListenerField1AllTables() {
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateText1AllTables();
            }

            public void changedUpdate(DocumentEvent e) {
                updateText1AllTables();
            }

            public void removeUpdate(DocumentEvent e) {
                updateText1AllTables();
            }
        });
    }
    
    private void updateText1AllTables() {
        if(janelaAtual == 0) {
            String texto = jTextField1.getText();
            if (!texto.isEmpty()) {
                Controller.setTableModel(jTable1, new ClienteTableModel(ClienteDAO.getInstance().
                            retrieveBySimilarName(texto)));
                    System.out.println(texto);
            } else {
                Controller.setTableModel(jTable1, new ClienteTableModel(ClienteDAO.getInstance().
                            retrieveAll()));
            }
        }
        
        if(janelaAtual == 1) {
            String texto = jTextField1.getText();
            if (!texto.isEmpty()) {
                Controller.setTableModel(jTable2, new AnimalTableModel(AnimalDAO.getInstance().
                            retrieveBySimilarName(texto)));
                    System.out.println(texto);
            } else {
                Controller.setTableModel(jTable2, new AnimalTableModel(AnimalDAO.getInstance().
                            retrieveAll()));
            }
        }
        
        if(janelaAtual == 2) {
            String texto = jTextField1.getText();
            if (!texto.isEmpty()) {
                Controller.setTableModel(jTable3, new VetTableModel(VeterinarioDAO.getInstance().
                            retrieveBySimilarName(texto)));
                    System.out.println(texto);
            } else {
                Controller.setTableModel(jTable3, new VetTableModel(VeterinarioDAO.getInstance().
                            retrieveAll()));
            }
        }
        
        if(janelaAtual == 3) {
            String texto = jTextField1.getText();
            if (!texto.isEmpty()) {
                Controller.setTableModel(jTable4, new EspecieTableModel(EspecieDAO.getInstance().
                            retrieveBySimilarName(texto)));
                    System.out.println(texto);
            } else {
                Controller.setTableModel(jTable4, new EspecieTableModel(EspecieDAO.getInstance().
                            retrieveAll()));
            }
        }
        
        if(janelaAtual == 4) {
            String texto = jTextField1.getText();
            if (!texto.isEmpty()) {
                Controller.setTableModel(jTable5, new ConsultaTableModel(ConsultaDAO.getInstance().
                            retrieveByOwnerName(texto)));
                    System.out.println(texto);
            } else {
                Controller.setTableModel(jTable5, new ConsultaTableModel(ConsultaDAO.getInstance().
                            retrieveAll()));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busca:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        jTable1.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereço", "Telefone", "CEP", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Cliente", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Ano Nasc", "Sexo", "Espécie", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Animal", jScrollPane2);

        jTable3.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "E-mail", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("Veterinário", jScrollPane3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane1.addTab("Espécies", jScrollPane4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Animal", "Cliente", "Data", "Horário", "Veterinário", "Comentário", "Status"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jTabbedPane1.addTab("Consultas", jScrollPane5);

        jButton2.setText("Deletar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(237, 237, 237)
                .addComponent(jButton3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Clínica_Veterinária().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (janelaAtual == 0) {
            int idCliente = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            Cliente cliDeletado = ClienteDAO.getInstance().retrieveById(idCliente);
            List<Animal> animais = AnimalDAO.getInstance().retrieveByClientId(idCliente);
            
            for (Animal animal : animais) {
                List<Consulta> consultas = ConsultaDAO.getInstance().retrieveOngoingByAnimalId(animal.getId());
                if (!consultas.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "O cliente ainda tem consultas agendadas",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if(!animais.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cliente deletado!\n"
                        + "Os animais vinculados a esse cliente também serão deletados.\n",
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
                for (Animal animal : animais) {
                    AnimalDAO.getInstance().delete(animal);
                }
                ClienteDAO.getInstance().delete(cliDeletado);
                this.myInitComponents();
            }
            
            if(animais.isEmpty()) {
                ClienteDAO.getInstance().delete(cliDeletado);
                this.myInitComponents();
            }
        }
        
        if (janelaAtual == 1) {
            int idAnimal = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            Animal animalDeletado = AnimalDAO.getInstance().retrieveById(idAnimal);
            List<Consulta> consultas = ConsultaDAO.getInstance().retrieveOngoingByAnimalId(idAnimal);
            if(!consultas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O animal ainda fará consultas!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                AnimalDAO.getInstance().delete(animalDeletado);
                this.myInitComponents();
            }
        }
        
        if (janelaAtual == 2) {
            int idVet = (int) jTable3.getValueAt(jTable3.getSelectedRow(), 0); 
            Veterinario vetDeletado = VeterinarioDAO.getInstance().retrieveById(idVet);
            List<Consulta> consultas = ConsultaDAO.getInstance().retrieveByOngoingAndVetId(idVet);
            if(!consultas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O veterinário ainda fará consultas!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                VeterinarioDAO.getInstance().delete(vetDeletado);
                this.myInitComponents();
            }
        }
        
        if (janelaAtual == 3) {
            int idEspecie = (int) jTable4.getValueAt(jTable4.getSelectedRow(), 0);
            Especie especieDeletada = EspecieDAO.getInstance().retrieveById(idEspecie);
            List<Animal> animaisEspecie = AnimalDAO.getInstance().retrieveBySpecieId(idEspecie);
            if(!animaisEspecie.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O veterinário ainda fará consultas!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                EspecieDAO.getInstance().delete(especieDeletada);
                this.myInitComponents();
            }
        }
        
        if (janelaAtual == 4) {
            int idConsulta = (int) jTable5.getValueAt(jTable5.getSelectedRow(), 0);
            Consulta aDeletar = ConsultaDAO.getInstance().retrieveById(idConsulta);
            ConsultaDAO.getInstance().delete(aDeletar);
            this.myInitComponents();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busca().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
