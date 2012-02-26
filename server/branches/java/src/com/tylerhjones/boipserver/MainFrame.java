/*
 *
 *  BarcodeOverIP-Server (Java) Version 0.3.x
 *  Copyright (C) 2012, Tyler H. Jones (me@tylerjones.me)
 *  http://tbsf.me/boip
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Filename: MainFrame.java
 *  Package Name: com.tylerhjones.boipserver
 *  Created By: Tyler H. Jones on Feb 25, 2012, 10:40:16 AM
 *
 *  Description: TODO
 *
 */

package com.tylerhjones.boipserver;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.jar.JarFile;
import javax.swing.JOptionPane;
import java.awt.Robot;

//Main class
public class MainFrame extends javax.swing.JFrame {

    private String TAG = "MainFrame";

    private ServerCore CORE;

    private Hashtable OrigSets = new Hashtable(4);
    private Settings SET = new Settings();

    private TrayIcon SysTrayIcon;

    public static JarFile jar;
    public static String basePath = "";
    public static InetAddress localAddr;

    private Toolkit toolkit;
    private MediaTracker tracker;

    public void setCore(ServerCore c) {
        CORE = c;
    }

    /** Creates new form MainFrame */
    public MainFrame(ServerCore c) {
        CORE = c;
        initComponents();
         //Save the current settings to a dictionary so we can compare them later
        OrigSets.put("host", new String(SET.getHost()));
        OrigSets.put("port", new Integer(SET.getPort()));
        OrigSets.put("pass", new String(SET.getPass()));
        OrigSets.put("newl", new Boolean(SET.getAppendNL()));

        //txtHost.setText(OrigSets.get("host").toString());
        txtPassword.setText(OrigSets.get("pass").toString());
        txtPort.setText(OrigSets.get("port").toString());
        chkAppendNL.setSelected(Boolean.valueOf(OrigSets.get("newl").toString()));

        String ip = this.FindSystemIP();
        if(ip.equals("NO")) {
            int n = JOptionPane.showConfirmDialog(this, "The IP address of the current system could not be determined. Either there is no network connection or you need to set the IP manually.", "Can't Determine IP Address", JOptionPane.OK_OPTION);
            chkAutoSet.setSelected(false);
            lblHostTitle.enable(true);
            //txtHost.enable(true);
            lblPortTitle.enable(true);
            txtPort.enable(true);
        } else {
            lblHostTitle.enable(false);
            //txtHost.enable(false);
            lblPortTitle.enable(false);
            txtPort.enable(false);
            SET.setHost(ip);
            SET.setPort(41788);
            lblHost.setText("Host/IP = " + ip);
            lblPort.setText("Port # = 41788");
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnApply = new javax.swing.JButton();
        btnToggleServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAbout = new javax.swing.JButton();
        chkAppendNL = new javax.swing.JCheckBox();
        frameAdvanced = new javax.swing.JPanel();
        txtHost = new javax.swing.JTextField();
        lblHostTitle = new javax.swing.JLabel();
        lblPortTitle = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        chkAutoSet = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        lblLastClient = new javax.swing.JLabel();
        lblHost = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();

        setTitle("BarcodeOverIP-Server 0.3.1 Beta - Settings");
        setAlwaysOnTop(true);
        setName("MainWindow"); // NOI18N
        setResizable(false);

        btnExit.setText("Exit");
        btnExit.setToolTipText("Exit the server application and close all connections.");
        btnExit.setMaximumSize(new java.awt.Dimension(85, 29));
        btnExit.setMinimumSize(new java.awt.Dimension(65, 29));
        btnExit.setPreferredSize(new java.awt.Dimension(85, 29));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnOk.setText("OK");
        btnOk.setMaximumSize(new java.awt.Dimension(85, 29));
        btnOk.setMinimumSize(new java.awt.Dimension(65, 29));
        btnOk.setPreferredSize(new java.awt.Dimension(85, 29));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnApply.setText("Apply");
        btnApply.setToolTipText("Save changes to server configuraton");
        btnApply.setMaximumSize(new java.awt.Dimension(85, 29));
        btnApply.setMinimumSize(new java.awt.Dimension(65, 29));
        btnApply.setPreferredSize(new java.awt.Dimension(85, 29));
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnToggleServer.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        btnToggleServer.setText("Activate Server");
        btnToggleServer.setMaximumSize(new java.awt.Dimension(402, 29));
        btnToggleServer.setMinimumSize(new java.awt.Dimension(402, 29));
        btnToggleServer.setPreferredSize(new java.awt.Dimension(402, 29));
        btnToggleServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleServerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jLabel1.setText("<html>\nEnter the following values into your mobile device (follow the steps your device gives you) to connect to this computer to start scanning barcodes! It's that easy!<br>\n<br> - If the big button below says \"Activate\", you need press it to activate the listening server before you can start sending barcodes.\n</html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setFocusable(false);
        jLabel1.setMaximumSize(new java.awt.Dimension(402, 45));
        jLabel1.setMinimumSize(new java.awt.Dimension(402, 45));
        jLabel1.setPreferredSize(new java.awt.Dimension(402, 45));

        jLabel4.setLabelFor(txtPassword);
        jLabel4.setText("Password (Optional):");
        jLabel4.setFocusable(false);

        txtPassword.setToolTipText("Set a password to limit access to the server. Make blank to remove the password requirement.");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnAbout.setText("About");
        btnAbout.setMaximumSize(new java.awt.Dimension(85, 29));
        btnAbout.setMinimumSize(new java.awt.Dimension(65, 29));
        btnAbout.setPreferredSize(new java.awt.Dimension(85, 29));
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        chkAppendNL.setSelected(true);
        chkAppendNL.setText("Append a cairrage return (enter) to end of rec'd barcode.");
        chkAppendNL.setToolTipText("Adds a simulated press of the enter key after the barcode is typed. Defualt is TRUE.");

        frameAdvanced.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Advanced Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        frameAdvanced.setEnabled(false);
        frameAdvanced.setFocusable(false);
        frameAdvanced.setName("Advanced Settings"); // NOI18N

        txtHost.setText("0.0.0.0");
        txtHost.setToolTipText("Default = 0.0.0.0 (All interfaces)");

        lblHostTitle.setLabelFor(txtHost);
        lblHostTitle.setText("Host/IP:");
        lblHostTitle.setEnabled(false);
        lblHostTitle.setFocusable(false);

        lblPortTitle.setLabelFor(lblPortTitle);
        lblPortTitle.setText("Port:");
        lblPortTitle.setEnabled(false);
        lblPortTitle.setFocusable(false);

        txtPort.setText("41788");
        txtPort.setToolTipText("Default = 41788");
        txtPort.setEnabled(false);

        javax.swing.GroupLayout frameAdvancedLayout = new javax.swing.GroupLayout(frameAdvanced);
        frameAdvanced.setLayout(frameAdvancedLayout);
        frameAdvancedLayout.setHorizontalGroup(
            frameAdvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameAdvancedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHostTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPortTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        frameAdvancedLayout.setVerticalGroup(
            frameAdvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameAdvancedLayout.createSequentialGroup()
                .addGroup(frameAdvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHostTitle)
                    .addComponent(lblPortTitle)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chkAutoSet.setSelected(true);
        chkAutoSet.setText("Automatically determine server IP & port number");
        chkAutoSet.setToolTipText("BoIP will look at you system's nerwork configuration and assign a port and an IP to listen for connections on.");
        chkAutoSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutoSetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel2.setLabelFor(lblLastClient);
        jLabel2.setText("Last Client:");
        jLabel2.setToolTipText("(IP, UPC, When (Min/Hrs))");

        lblLastClient.setLabelFor(btnExit);
        lblLastClient.setText("NONE!");

        lblHost.setFont(new java.awt.Font("DejaVu Sans", 1, 24));
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHost.setText("Host/IP = 0.0.0.0");

        lblPort.setFont(new java.awt.Font("DejaVu Sans", 1, 24));
        lblPort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPort.setText("Port # = 41788");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLastClient, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(frameAdvanced, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkAutoSet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(chkAppendNL, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(btnToggleServer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPort, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHost, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHost, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPort, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAutoSet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnToggleServer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addComponent(chkAppendNL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frameAdvanced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblLastClient))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnToggleServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleServerActionPerformed
        if(btnToggleServer.getText().equals("Activate Server")) {
            setServerState(true);
            btnToggleServer.setText("Deactivate Server");
            LogI(TAG, "Activated the server.");
            return;
        } else {
            setServerState(false);
            btnToggleServer.setText("Activate Server");
            LogI(TAG, "Deactivated the server.");
            return;
        }
    }//GEN-LAST:event_btnToggleServerActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm quit", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        txtHost.requestFocusInWindow();
        KeypressEmulator KE = new KeypressEmulator();
        //txt.enable(true);
       // txtHost.requestFocusInWindow();
        System.out.println("KeyPress Returned: " + KE.typeString(txtPassword.getText(), SET.getAppendNL()));
        //this.saveChanges();
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        KeypressEmulator KE = new KeypressEmulator();
        txtHost.enable(true);
        txtHost.requestFocusInWindow();
        KE.typeString(txtPassword.getText(), SET.getAppendNL());
        //this.saveChanges();
        //this.hide();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        //TODO: Add an about dialog with some info in it here...
    }//GEN-LAST:event_btnAboutActionPerformed

    private void chkAutoSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAutoSetActionPerformed
        if(chkAutoSet.isSelected()) {
            lblHostTitle.enable(false);
            txtHost.enable(false);
            lblPortTitle.enable(false);
            txtPort.enable(false);
        } else {
            lblHostTitle.enable(true);
            txtHost.enable(true);
            lblPortTitle.enable(true);
            txtPort.enable(true);
        }
    }//GEN-LAST:event_chkAutoSetActionPerformed


    public void setTrayIcon(TrayIcon ico) {
        SysTrayIcon = ico;
    }

    private String FindSystemIP() {
        String sHost = "";
	try {
            localAddr = InetAddress.getLocalHost();
            if (localAddr.isLoopbackAddress()) {
                localAddr = getLocalHost_nix();
            }
            sHost = localAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            System.out.println("Error finding local IP.");
            return "NO";
        }
        return sHost;
    }

    //*********************************************
    // Check if any settings are different and then save them if the user wishes to

    private boolean checkForChanges() {
        boolean changed = false;
        if(!chkAutoSet.isSelected()) {
            if(!txtHost.getText().trim().equals(OrigSets.get("host").toString().trim())) { changed = true; }
            if(!txtPort.getText().trim().equals(OrigSets.get("port").toString().trim())) { changed = true; }
        }
        if(!txtPassword.getText().trim().equals(OrigSets.get("pass").toString().trim())) { changed = true; }
        if(chkAppendNL.isSelected() != Boolean.valueOf(OrigSets.get("newl").toString().trim())) { changed = true; }
        return changed;
    }

    private String validateValues() {
        if(!chkAutoSet.isSelected()) {
            if(txtHost.getText().trim().length() < 1 || txtHost.getText().trim().equals("") || txtHost.getText().trim() == null) {
                return "Invalid or empty Host/IP Address!";
            }
            if(txtPort.getText().trim().length() < 1 || txtPort.getText().trim().equals("") || txtPort.getText().trim() == null) {
                txtPort.setText("41788");
            } else {
                boolean validport = false;
                try {
                    int i = Integer.parseInt(txtPort.getText());
                    if(i < 65535 && i > 1023) {
                        validport = true;
                    } else {
                        return "Given port is out of range. Must be: <65535 and >1023!";
                    }
                } catch(NumberFormatException nme) {
                    validport = false;
                }
                if(!validport) { return "Given port value is not a valid number!"; }
            }
        }
        if(txtPassword.getText().trim().length() > 32) { return "Given password is too long! Must be <32 characters long!"; }
        return "OK"; //All is ok
    }

    private boolean saveChanges() {
        if(!checkForChanges()) { return true; }
        String validres = validateValues();
        if(!validres.equals("OK")) {
            int n = JOptionPane.showConfirmDialog(this, validres, "Invalid Value!", JOptionPane.OK_OPTION);
            return false;
        }
        if(!chkAutoSet.isSelected()) {
            SET.setHost(txtHost.getText().trim());
            SET.setPort(Integer.valueOf(txtPort.getText().trim()));
        }
        SET.setAppendNL(chkAppendNL.isSelected());
        SET.setPass(txtPassword.getText().trim());
        LogI(TAG, "Changes successfully saved!");

        lblHost.setText("Host/IP = " + SET.getHost());
        lblPort.setText("Port # = " + SET.getPort());

        //Start and stop the server to force it to take the changes
        setServerState(false);
        setServerState(true);

        return true;
    }

    private boolean setServerState(boolean val) {  // TRUE = Active
        if(val) {
            CORE.ActivateServer();
            SysTrayIcon.setToolTip("BarcodeOverIP " + Settings.VERSION + " - Active");
        } else {
            CORE.DeactivateServer();
            SysTrayIcon.setToolTip("BarcodeOverIP " + Settings.VERSION + " - Active");
        }
        return val;
    }

    public void LogD(String tag, String info) { Log(tag, info, 0); }
    public void LogI(String tag, String info) { Log(tag, info, 1); }
    public void LogW(String tag, String info) { Log(tag, info, 2); }
    public void LogE(String tag, String info) { Log(tag, info, 3); }
    public void LogF(String tag, String info) { Log(tag, info, 4); }

    public void Log(String tag, String info, int level) { //Levels: 0 = debug, 1 = info, 2 = warning, 3 = error, 4 = fatal
        String a = "";
        if(level == 2) { a = "WARN: "; }
        if(level == 3) { a = "*ERR*: "; }
        if(level == 4) { a = "**FATAL**: "; }
        System.out.println(a + tag + " -- " + info);
    }

    	public static InetAddress getLocalHost_nix() throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		if(!localHost.isLoopbackAddress()) return localHost;
		InetAddress[] addrs = getAllLocalUsingNetworkInterface_nix();
		for(int i=0; i<addrs.length; i++) {
			//Check for "." to ensure IPv4
			if(!addrs[i].isLoopbackAddress() && addrs[i].getHostAddress().contains(".")) return addrs[i];
		}
		return localHost;
	}

	public static InetAddress[] getAllLocal_nix() throws UnknownHostException {
		InetAddress[] iAddresses = InetAddress.getAllByName("127.0.0.1");
		if(iAddresses.length != 1) return iAddresses;
		if(!iAddresses[0].isLoopbackAddress()) return iAddresses;
		return getAllLocalUsingNetworkInterface_nix();
	}
	
	private static InetAddress[] getAllLocalUsingNetworkInterface_nix() throws UnknownHostException {
		ArrayList addresses = new ArrayList();
		Enumeration e = null;
		try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException ex) {
			throw new UnknownHostException("127.0.0.1");
		}
		while(e.hasMoreElements()) {
			NetworkInterface ni = (NetworkInterface)e.nextElement();
			for(Enumeration e2 = ni.getInetAddresses(); e2.hasMoreElements();) {
				addresses.add(e2.nextElement());
			}
		}
		InetAddress[] iAddresses = new InetAddress[addresses.size()];
		for(int i=0; i<iAddresses.length; i++) {
			iAddresses[i] = (InetAddress)addresses.get(i);
		}
		return iAddresses;
	}


        	public Image getImage(String sImage) {
		Image imReturn = null;
		try {
			if (jar == null) {
				imReturn = this.toolkit.createImage(this.getClass().getClassLoader().getResource(sImage));
			} else {
				//
				BufferedInputStream bis = new BufferedInputStream(jar.getInputStream(jar.getEntry(sImage)));
				ByteArrayOutputStream buffer=new ByteArrayOutputStream(4096);
				int b;
				while((b=bis.read())!=-1) {
					buffer.write(b);
				}
				byte[] imageBuffer=buffer.toByteArray();
				imReturn = this.toolkit.createImage(imageBuffer);
				bis.close();
				buffer.close();
			}
		} catch (IOException ex) {

		}
		return imReturn;
	}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnToggleServer;
    private javax.swing.JCheckBox chkAppendNL;
    private javax.swing.JCheckBox chkAutoSet;
    private javax.swing.JPanel frameAdvanced;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblHostTitle;
    private javax.swing.JLabel lblLastClient;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblPortTitle;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

}