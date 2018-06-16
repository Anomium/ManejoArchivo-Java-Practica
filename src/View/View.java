package View;

import Controller.GestionArchivo;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class View extends javax.swing.JFrame {
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] bytesImg;
    GestionArchivo gestion = new GestionArchivo();
    public View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_AbrirArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lb_Imagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Texto = new javax.swing.JTextArea();
        btn_GuardarImagen = new javax.swing.JButton();
        btn_GuardarTexto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_AbrirArchivo.setText("Abrir Archivo");
        btn_AbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AbrirArchivoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lb_Imagen);

        txt_Texto.setColumns(20);
        txt_Texto.setRows(5);
        jScrollPane2.setViewportView(txt_Texto);

        btn_GuardarImagen.setText("Guardar Imagen");
        btn_GuardarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarImagenActionPerformed(evt);
            }
        });

        btn_GuardarTexto.setText("Guardar Texto");
        btn_GuardarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_GuardarImagen)
                        .addGap(75, 75, 75)
                        .addComponent(btn_AbrirArchivo)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_GuardarTexto)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_GuardarImagen)
                    .addComponent(btn_AbrirArchivo)
                    .addComponent(btn_GuardarTexto))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AbrirArchivoActionPerformed
        if (seleccionado.showDialog(this, "Abrir archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    String contenido = gestion.AbrirTexto(archivo);
                    txt_Texto.setText(contenido);
                } else {
                    if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png") || archivo.getName().endsWith("gif")) {
                        bytesImg = gestion.AbrirImagen(archivo);
                        lb_Imagen.setIcon(new ImageIcon(bytesImg));
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo admitido");
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_AbrirArchivoActionPerformed

    private void btn_GuardarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarImagenActionPerformed
        if (seleccionado.showDialog(this, "Guardar Imagen") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png") || archivo.getName().endsWith("gif")) {
                String respuesta = gestion.GuardarImagen(archivo, bytesImg);
                if (respuesta != null) {
                    JOptionPane.showMessageDialog(null, respuesta);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar imagen");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La imagen se debe guardar en formato de imagen");
            }
        }
    }//GEN-LAST:event_btn_GuardarImagenActionPerformed

    private void btn_GuardarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarTextoActionPerformed
        if (seleccionado.showDialog(this, "Guardar Texto") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                String contenido = txt_Texto.getText();
                String respuesta = gestion.GuardarArchivo(archivo, contenido);
                if (respuesta != null) {
                    JOptionPane.showMessageDialog(null, respuesta);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar texto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El texto se debe guardar en un formato de texto");
            }
        }
    }//GEN-LAST:event_btn_GuardarTextoActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AbrirArchivo;
    private javax.swing.JButton btn_GuardarImagen;
    private javax.swing.JButton btn_GuardarTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_Imagen;
    private javax.swing.JTextArea txt_Texto;
    // End of variables declaration//GEN-END:variables
}
