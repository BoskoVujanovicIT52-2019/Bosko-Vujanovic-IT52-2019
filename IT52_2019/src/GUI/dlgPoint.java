package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlgPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704010849242731657L;
	private final JPanel contentPanel = new JPanel();
	private JTextField TX;
	private JTextField TY;
	private boolean OK;
	private Color color;
	private JButton btnColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgPoint dialog = new dlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgPoint() {
		setBounds(500, 100, 800, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		color = Color.BLACK;
		setModal(true);
		{
			JPanel panelWest = new JPanel();
			contentPanel.add(panelWest, BorderLayout.WEST);
			panelWest.setLayout(new GridLayout(0, 1));
			{
				JLabel lblX = new JLabel("X coordinate:");
				panelWest.add(lblX);
			}
			{
				JLabel lblY = new JLabel("Y coordinate:");
				panelWest.add(lblY);
			}
		}
		{
			JPanel pnlCenter = new JPanel();
			contentPanel.add(pnlCenter, BorderLayout.CENTER);
			{
				TX = new JTextField();
				TX.setColumns(10);
			}
			{
				TY = new JTextField();
				TY.setColumns(10);
			}
		btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose a color", Color.BLUE);
					btnColor.setBackground(color);
				}
			});
			GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
			gl_pnlCenter.setHorizontalGroup(
				gl_pnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlCenter.createSequentialGroup()
						.addGap(47)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
							.addComponent(TY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(TX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(32, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
						.addContainerGap(261, Short.MAX_VALUE)
						.addComponent(btnColor)
						.addGap(33))
			);
			gl_pnlCenter.setVerticalGroup(
				gl_pnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlCenter.createSequentialGroup()
						.addGap(170)
						.addComponent(TX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(127)
						.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addComponent(TY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(170))
			);
			pnlCenter.setLayout(gl_pnlCenter);
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							if (getTX().getText().trim().isEmpty() ||
									getTY().getText().trim().isEmpty()) {
								OK = false;
								getToolkit().beep();
								setVisible(true);
								JOptionPane.showMessageDialog(null, "You need to enter all values!");
							} else if (Integer.parseInt(getTX().getText().toString()) <= 0 || 
									Integer.parseInt(getTY().getText().toString()) <= 0) {
								JOptionPane.showMessageDialog(null, "You need to enter values greater than 0!");
							} else if (Integer.parseInt(getTX().getText().toString()) >= 465 ||
									Integer.parseInt(getTY().getText().toString()) >= 300)
								JOptionPane.showMessageDialog(null, "You need to enter values for x coordinate between 0 and 465 and between 0 and 300 for y!");
							else {
								OK = true;
								dispose();
							}
						}
						catch (Exception e)
						{
							JOptionPane.showMessageDialog(null, "You need to enter numbers!");
						}
					}
				});
				btnOK.setActionCommand("OK");
				buttonPanel.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCanc = new JButton("Cancel");
				btnCanc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCanc.setActionCommand("Cancel");
				buttonPanel.add(btnCanc);
			}
		}
	}

	public JTextField getTX() {
		return TX;
	}

	public void setTX(JTextField txtX) {
		this.TX = txtX;
	}

	public JTextField getTY() {
		return TY;
	}

	public void setTY(JTextField txtY) {
		this.TY = txtY;
	}

	public boolean isOk() {
		return OK;
	}

	public void setOk(boolean isOk) {
		this.OK = isOk;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

}
