import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
public class HackTool extends JFrame {
    private JTabbedPane jtp;
    private JPanel crypto,stego,cipherType;
    
    public JComboBox jcb;
    public JTextField key,n,p,q;
    public JButton encb,decb,checkCipher;
    public JTextArea in,out,cipher,phash;
    public HackTool() {
        setTitle("HackTool v1.0");
        setSize(1000,600);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
        
        cryptoTab();
        stegoTab();
        cipherTypeTab();
        
        jtp = new JTabbedPane();
        jtp.addTab("Crypto",crypto);
        jtp.addTab("Stego",stego);
        jtp.addTab("CipherType",cipherType);
        mainPanel.add(jtp,BorderLayout.CENTER);
    }
    public void cryptoTab() {
        JPanel opt1,opt2,opt3,opt4,opt5,optPanel;
        optPanel = new JPanel(new GridLayout(5,1));
        JLabel opt = new JLabel("Choose Cipher:");
        opt1 = new JPanel(new FlowLayout());
        jcb = new JComboBox();
        jcb.addItem("Select");
        jcb.addItem("CaeserShift");
        jcb.addItem("MorseCode");
        jcb.addItem("Atbash");
        jcb.addItem("RSA");
        jcb.addItem("HillCipher");
        jcb.addItem("XORCipher");
	System.out.println(jcb.getSelectedItem().toString());
        jcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                enableOptions();  
            }
        });
        opt1.add(opt);
        opt1.add(jcb);
        optPanel.add(opt1);
        
        opt2 = new JPanel(new FlowLayout());
        JLabel kl = new JLabel("Key:");
        key = new JTextField(10);
        key.setToolTipText("Caeser/RSA-d/RSA-c/");
        key.setEditable(false);
        
        opt3 = new JPanel(new FlowLayout());
        JLabel nl = new JLabel("n = ");
        n = new JTextField(10);
        n.setToolTipText("RSA-n");
        n.setEditable(false);
        n.setBounds(50,250,100,20);
        
        opt4 = new JPanel(new FlowLayout());
        JLabel pl = new JLabel("p = ");
        p = new JTextField(10);
        p.setToolTipText("RSA-p");
        p.setEditable(false);
        
        opt5 = new JPanel(new FlowLayout());
        JLabel ql = new JLabel("q = ");
        q = new JTextField(10);
        q.setToolTipText("RSA-q");
        q.setEditable(false);
        
        opt2.add(kl);
        opt2.add(key);
        opt3.add(nl);
        opt3.add(n);
        opt4.add(pl);
        opt4.add(p);
        opt5.add(ql);
        opt5.add(q);
        optPanel.add(opt2);
        optPanel.add(opt3);
        optPanel.add(opt4);
        optPanel.add(opt5);
        
        //display panel
        JPanel input,output,enc,dec,dispPanel;
        
        dispPanel = new JPanel(new FlowLayout());
        input = new JPanel(new FlowLayout());
        JLabel pt = new JLabel("Plain Text:");
        in = new JTextArea(10,50);
        in.setEditable(true);
        in.setLineWrap(true);
        in.setFont(new Font("TimeNewRoman",Font.BOLD,10));
        JScrollPane sb = new JScrollPane(in,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        input.add(pt);
        input.add(sb);
        dispPanel.add(input);
        
        enc = new JPanel(new FlowLayout());
        encb = new JButton("Encrypt");
        encb.setMnemonic(KeyEvent.VK_E);
        encb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String pt = in.getText();
                String cm = jcb.getSelectedItem().toString();
                int shift = 0;
                if(cm.equals("CaeserShift")) {
                    try {
                        shift = Integer.parseInt(key.getText());
                        CaesarCipher cc = new CaesarCipher();
                        out.setText(cc.decrypt(shift,pt));
                    }
                    catch(Exception e) {
                        JOptionPane.showMessageDialog(HackTool.this,"Error: Invalid Key given.");
                    }
                }
                if(cm.equals("MorseCode")) {
                    MorseCode mc = new MorseCode();
                    out.setText(mc.toMorse(pt));
                }
                //implement all ciphers enc here
                if(cm.equals("Atbash")) {
                    
                }
                
            }
        });
        enc.add(encb);
        dispPanel.add(enc);
        
        output = new JPanel(new FlowLayout());
        JLabel ct = new JLabel("CipherText:");
        out = new JTextArea(10,50);
        out.setEditable(true);
        out.setLineWrap(true);
        out.setFont(new Font("TimeNewRoman",Font.BOLD,10));
        JScrollPane sb1 = new JScrollPane(out,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        output.add(ct);
        output.add(sb1);
        dispPanel.add(output);
        
        dec = new JPanel(new FlowLayout());       
        decb = new JButton("Decrypt");
        decb.setMnemonic(KeyEvent.VK_D);
        decb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String ct = out.getText();
                String cm = jcb.getSelectedItem().toString();
                int shift = 0;
                if(ct.length() > 0 && cm.equals("Select")) {
                    JOptionPane.showMessageDialog(HackTool.this,"Warning: Please select cipher");
                }
                if(cm.equals("CaeserShift")) {
                    try {
                        shift = Integer.parseInt(key.getText());
                        CaesarCipher cc = new CaesarCipher();
                        in.setText(cc.decrypt(shift,ct));
                    }
                    catch(Exception e) {
                        JOptionPane.showMessageDialog(HackTool.this,"Error: Invalid Key given.");
                    }
                }
                if(cm.equals("MorseCode")) {
                    MorseCode mc = new MorseCode();
                    in.setText(mc.toPlain(ct));
                }
                //implement all ciphers dec here
                if(cm.equals("Atbash")) {
                    
                }
                
            }
        });
        dec.add(decb);
        dispPanel.add(dec);
        
        crypto = new JPanel(new BorderLayout());
        crypto.add(optPanel,BorderLayout.WEST);
        crypto.add(dispPanel,BorderLayout.CENTER);
        
        //footer
        footer(crypto);
    }
    public void stegoTab() {
        
    }
    public void cipherTypeTab() {
        JPanel com1,com2,com3,tc;
        
        tc = new JPanel(new GridLayout(3,1));
        com1 = new JPanel(new FlowLayout());
        JLabel ct = new JLabel("Cipher Text:");
        cipher = new JTextArea(10,50);
        cipher.setEditable(true);
        cipher.setLineWrap(false);
        cipher.setFont(new Font("TimeNewRoman",Font.BOLD,10));
        JScrollPane sp = new JScrollPane(cipher,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        com1.add(ct);
        com1.add(sp);
        tc.add(com1);
        
        
        com2 = new JPanel(new FlowLayout());
        checkCipher = new JButton("Get-Cipher-Type");
        checkCipher.setMnemonic(KeyEvent.VK_C);
        checkCipher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String ctxt = cipher.getText().toString();
                try {
                    Process p = Runtime.getRuntime().exec("python hashdetect.py "+ctxt);
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String cmet="",line;
                    while((line=br.readLine()) != null) {
                        cmet += line+"\n";
                    }
                    phash.setText(cmet);
                }
                catch(Exception e) {
                    JOptionPane.showMessageDialog(HackTool.this,"Error occured.");
                }
            }
        });
        com2.add(checkCipher);
        tc.add(com2);
        
        com3 = new JPanel(new FlowLayout());
        JLabel hash = new JLabel("Hashes :");
        phash = new JTextArea(10,50);
        phash.setLineWrap(true);
        phash.setFont(new Font("TimeNewRoman",Font.BOLD,10));
        JScrollPane sp1 = new JScrollPane(phash,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        com3.add(hash);
        com3.add(sp1);
        tc.add(com3);
        
        cipherType = new JPanel(new BorderLayout());
        cipherType.add(tc);
        
        //footer
        footer(cipherType);
    }
    
    //util methods
    public void enableOptions() {
        String cipher = jcb.getSelectedItem().toString();
        if(cipher.equals("CaeserShift")) {
            key.setEditable(true);
            n.setEditable(false);
            p.setEditable(false);
            q.setEditable(false);
            n.setText(null);
            p.setText(null);
            q.setText(null);
            key.setText(null);
        }
        if(cipher.equals("Atbash")) {
            key.setEditable(false);
            n.setEditable(false);
            p.setEditable(false);
            q.setEditable(false);
            n.setText(null);
            p.setText(null);
            q.setText(null);
            key.setText(null);
        }
        if(cipher.equals("MorseCode")) {
            key.setEditable(false);
            n.setEditable(false);
            p.setEditable(false);
            q.setEditable(false);
            n.setText(null);
            p.setText(null);
            q.setText(null);
            key.setText(null);
        }
        if(cipher.equals("RSA")) {
            key.setEditable(true);
            n.setEditable(true);
            p.setEditable(true);
            q.setEditable(true);
            key.setText(null);
            n.setText(null);
            p.setText(null);
            q.setText(null);
        }
    }
    public void footer(JPanel obj) {
        JPanel footer = new JPanel(new FlowLayout());
        JLabel fText = new JLabel("copy rights - x65@r3b00+");
        footer.add(fText);
        obj.add(footer,BorderLayout.SOUTH);        
    }
    public static void main(String []args) {
        HackTool ht = new HackTool();
        ht.setVisible(true);
        ht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
