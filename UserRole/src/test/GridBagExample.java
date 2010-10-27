package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GridBagExample extends JFrame{
	 
	 private Dimension DLG_DIMENSION = new Dimension(300, 400);
	 public GridBagExample(){
	  super();
	  setTitle("清风手作GridBagLayout例子");
	  setSize(DLG_DIMENSION);
	  setResizable(false);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLocation(getMidDimesion(DLG_DIMENSION));
	  try {
	   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	  } catch (ClassNotFoundException e) {
	   e.printStackTrace();
	  } catch (InstantiationException e) {
	   e.printStackTrace();
	  } catch (IllegalAccessException e) {
	   e.printStackTrace();
	  } catch (UnsupportedLookAndFeelException e) {
	   e.printStackTrace();
	  }
	  initComponents();
	 }
	 private void initComponents() {
	  setLayout(new BorderLayout());
	  JPanel mainPanel = new JPanel();
	  {
	   Border border = new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new LineBorder(Color.red));
	   mainPanel.setBorder(border);
	   GridBagLayout gridbag = new GridBagLayout();
	   gridbag.columnWidths = new int[]{60, 40, 40, 40, 40, 60, 0};
	   gridbag.columnWeights = new double[]{0, 0, 0, 0, 0, 0, 1.0E-4};
	   gridbag.rowHeights = new int[]{25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 0};
	   gridbag.rowWeights = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0E-4};
	   mainPanel.setLayout(gridbag);
	   {
	    JLabel firstline = new JLabel("第一行");
	    firstline.setHorizontalAlignment(SwingConstants.CENTER);
	    firstline.setBorder(new LineBorder(Color.red));
	    mainPanel.add(firstline, new GridBagConstraints(1, 0, 4, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel sencondline = new JLabel("第二行1");
	    sencondline.setHorizontalAlignment(SwingConstants.CENTER);
	    sencondline.setBorder(new LineBorder(Color.red));
	    mainPanel.add(sencondline, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel sencondline2 = new JLabel("第二行2");
	    sencondline2.setHorizontalAlignment(SwingConstants.CENTER);
	    sencondline2.setBorder(new LineBorder(Color.red));
	    mainPanel.add(sencondline2, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel thirdline = new JLabel("一个JTextArea的例子如下：");
	    thirdline.setHorizontalAlignment(SwingConstants.CENTER);
	    thirdline.setBorder(new LineBorder(Color.red));
	    mainPanel.add(thirdline, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JTextArea area = new JTextArea();
	    area.setBorder(new LineBorder(Color.red));
	    mainPanel.add(area, new GridBagConstraints(0, 3, 6, 3, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel seventhline = new JLabel("第七行");
	    seventhline.setHorizontalAlignment(SwingConstants.CENTER);
	    seventhline.setBorder(new LineBorder(Color.red));
	    mainPanel.add(seventhline, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel eighthline = new JLabel("第八行");
	    eighthline.setHorizontalAlignment(SwingConstants.CENTER);
	    eighthline.setBorder(new LineBorder(Color.red));
	    mainPanel.add(eighthline, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel ninthline = new JLabel("第九行");
	    ninthline.setHorizontalAlignment(SwingConstants.CENTER);
	    ninthline.setBorder(new LineBorder(Color.red));
	    mainPanel.add(ninthline, new GridBagConstraints(0, 8, 3, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel line10 = new JLabel("第十行");
	    line10.setHorizontalAlignment(SwingConstants.CENTER);
	    line10.setBorder(new LineBorder(Color.red));
	    mainPanel.add(line10, new GridBagConstraints(0, 9, 4, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel line11 = new JLabel("第十一行");
	    line11.setHorizontalAlignment(SwingConstants.CENTER);
	    line11.setBorder(new LineBorder(Color.red));
	    mainPanel.add(line11, new GridBagConstraints(0, 10, 5, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JLabel line12 = new JLabel("第十二行");
	    line12.setHorizontalAlignment(SwingConstants.CENTER);
	    line12.setBorder(new LineBorder(Color.red));
	    mainPanel.add(line12, new GridBagConstraints(0, 11, 6, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	    
	    JButton closebtn = new JButton("关闭");
	    closebtn.setBorder(new LineBorder(Color.red));
	    closebtn.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent arg0) {
	      System.exit(0);
	     }
	     
	    });
	    mainPanel.add(closebtn, new GridBagConstraints(2, 12, 2, 1, 0.0, 0.0, 
	      GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 0), 0, 0));
	   }
	  }
	  getContentPane().add(mainPanel, BorderLayout.CENTER);
	 }
	 
	 private Point getMidDimesion(Dimension d){
	  Point p = new Point();
	  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	  p.setLocation((dim.width - d.width)/2,(dim.height - d.height)/2);
	  return p;
	 }
	 
	 public static void main(String[] args){
	  GridBagExample example = new GridBagExample();
	  example.setVisible(true);
	 }
	}
