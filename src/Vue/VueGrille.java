package Vue;
import java.awt.*;

import javax.swing.*;

public class VueGrille extends JPanel{
    
    public VueGrille(int width, int height) {

        Dimension dim = new Dimension(width,height);
        setPreferredSize(dim);
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 128));
    }
    public void addElem(JComponent element) {
        add(element);
    }
}