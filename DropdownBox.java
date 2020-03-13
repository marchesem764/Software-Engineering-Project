import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DropdownBox extends JFrame {

    private static final String Moravian_Lat_lon = "40.631262, -75.381459";

    private static final String ROUTE_DATA_FILE      = "route.csv";
    private static final String GOOGLE_MAPS_BASE_URL = "https://maps.googleapis.com/maps/api/staticmap";
    private static String GOOGLE_MAPS_API_KEY        = null;
    private static final int    DEFAULT_ZOOM         = 13;
    private static final int    WIDTH                = 800;
    private static final int    HEIGHT               = 600;
    private static final String TITLE                = "Dropdown and Google Maps";

    private int     zoom;      // the zoom level for the map
    private JLabel  labelMap;  // the map as a label

    public DropdownBox(String key) throws MalformedURLException {

        //TODO: Condense into one panel

        GOOGLE_MAPS_API_KEY = key;

        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zoom = DEFAULT_ZOOM;
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JFrame frame = new JFrame("Basic Dropdown Menu");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);

        JLabel label = new JLabel("Select one and click OK");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);

        String[] choices = {"A", "B", "C"};

        final JComboBox<String> comboBox = new JComboBox<>(choices);

        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(comboBox);

        JButton button = new JButton("OK");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);

        frame.setVisible(true);

        labelMap = new JLabel(getImageIcon()); // calls getImageIcon to generate the map from Google Maps Static API
        contentPane.add(BorderLayout.CENTER, labelMap);
        setVisible(true);

    }

    private ImageIcon getImageIcon() throws MalformedURLException {

        String urlString = GOOGLE_MAPS_BASE_URL + "?key=" + GOOGLE_MAPS_API_KEY + "&zoom=" + zoom + "&scale=1&size=" + WIDTH + "x" + HEIGHT;
        urlString += "&markers=label:A|40.631262,-75.381459";
        URL url = new URL(urlString);
        return new ImageIcon(url);

    }
}
