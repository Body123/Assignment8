package controls;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import MailSever.App;
import MailSever.IFolder;
import MailSever.Tools;
import library.doubleLinkedList;

public class contactForm extends javax.swing.JFrame {
	public String mailName="";
	App appObj=new App();
    public contactForm() {
        initComponents();
    }
    public contactForm(String contact) {
        initComponents();
        this.mailName=contact;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtContact = new JTextBox(20);
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnBack = new JMyButton();
        btnRefresh = new JMyButton();
        btnAdd = new JMyButton();
        btnDeleted = new JMyButton();
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Contacts File");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contact :");

        tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnBackActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDeleted.setText("Delete Selected");
        btnDeleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btnBack)
                        .addGap(41, 41, 41)
                        .addComponent(btnDeleted)
                        .addGap(37, 37, 37)
                        .addComponent(btnRefresh))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnAdd))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRefresh)
                    .addComponent(btnDeleted))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {                                 
        
    }                                

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(appObj.checkNewContact(txtContact.getText())) {
    		if(appObj.checkPreviousAdded(mailName, txtContact.getText())) {
    			JOptionPane.showMessageDialog(null, "Added Prevoius ");
    		}else {
        		JOptionPane.showMessageDialog(null, "Added");
        		String newPath = "data_base//" + mailName + "//contacts//" + txtContact.getText() + "//";
                File email = new File(newPath);
                email.mkdir();
   			}
    	}else {
    		JOptionPane.showMessageDialog(null, "there is no user with this mail");
    	}
    }                                      

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                        
        // TODO add your handling code here:
        this.dispose();
    	Tools.openForm(new MainForm(this.mailName));
    }                                       

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        // TODO add your handling code here:
        IFolder folders=new IFolder();
    	doubleLinkedList dl=new doubleLinkedList();
    	doubleLinkedList dlFinal=new doubleLinkedList();
    	dl=folders.Names("data_base//"+mailName+"//contacts//");
    	for(int i=0;i<dl.size();i++) {
    		if(dl.get(i).equals("index.txt")) {
    			continue;
    			
    		}else {
    			dlFinal.add(dl.get(i));
    		}
    	}
        DefaultTableModel model= (DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
    	model.setRowCount(dlFinal.size());
        for(int x=0;x<dlFinal.size();x++) {
        	Object [] ob=new Object[1];
        	ob[0]=dlFinal.get(x);
        	model.setValueAt(ob[0], x, 0);
        }
    }                                 

    private void btnDeletedActionPerformed(java.awt.event.ActionEvent evt) {    
    	
    	int row=tbl.getSelectedRow();
    	String value=(String) tbl.getValueAt(row, 0);
    	String newPath = "data_base//" + mailName + "//contacts//" + value + "//";
        File email = new File(newPath);
        email.delete();
		JOptionPane.showMessageDialog(null, "deleted");

    }                                          

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
    	Tools.openForm(new contactForm(this.mailName));
    }                                          

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
            java.util.logging.Logger.getLogger(contactForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(contactForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(contactForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(contactForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new contactForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleted;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTable tbl;
    // End of variables declaration                   
}