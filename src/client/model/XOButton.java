
package client.model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class XOButton extends JButton {
	private ImageIcon X;
	private ImageIcon O;
	public Point point;
	public static boolean isXMove = true;
	public int value = 0;
	
	public XOButton(int x, int y) {
		X = new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/x.png"));
		O = new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/o.png"));
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/blank.png")));
		this.point = new Point(x, y);
                XOButton _this = this;
		this.addMouseListener( new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(_this.isEnabled()){
                            _this.setBackground(null);
                            _this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/blank.png")));
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(_this.isEnabled()) {
                            _this.setBackground(Color.GREEN);
                            _this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/x.png")));
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }
                });
	}
	
	public void setState(Boolean isXMove) {
		if (isXMove) {
			setIcon(X);
			value = 2;
			XOButton.isXMove = false;
                        this.setDisabledIcon(X);
		} else {
			setIcon(O);
			value = 1;
                        this.setDisabledIcon(O);
			XOButton.isXMove = true;
		}
	}
        public void resetState(){
            value = 0;
            this.setEnabled(true);
            this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/blank.png")));
            this.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("./assets/icon/blank.png")));
        }
	
	
}