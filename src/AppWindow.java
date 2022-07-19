import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

public class AppWindow extends JFrame
{
    private Main main;
    private JSpinner jSpinner;
    private JButton generateNewGraphButton;
    private JButton previousStepButton;
    private JButton playButton;
    private JButton nextStepButton;
    private JLabel instructionsLabel;
    private JPanel mainPanel;
    private JPanel barPanel;
    private JComboBox sortTypeComboBox;
    private JLabel sortTypeLabel;
    private ArrayList<Bar> currentBarGraph;

    private final int SPINNER_MIN = 3;
    private final int SPINNER_MAX = 50;
    private final int SPINNER_DEFAULT = 10;

    // Specifically used to store the old height of the barPanel before a resize
    private int oldHeight;

    public AppWindow(Main main)
    {
        this.main = main;
        this.setLookAndFeel();
        super.setTitle("Sorting Algorithm Visualizer");
        this.setMinimumSize(mainPanel.getMinimumSize());
        // The ComboBox only supports 1 type of sort at the moment.
        // TODO: Add more sorting types in the future.
        sortTypeComboBox.addItem(new QuickSort());
        this.mainPanel.setBackground(Color.gray);
        this.barPanel.setBackground(Color.darkGray);
        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Screen.width / 2, Screen.height / 2);
        this.jSpinner.setValue(SPINNER_DEFAULT);
        this.setVisible(true);
        // Calculates the middle of the screen
        this.setLocation((Screen.width / 2) - (this.mainPanel.getWidth() / 2),
                (Screen.height / 2) - (this.mainPanel.getHeight() / 2));
        oldHeight = barPanel.getHeight();
        // Add all of the action listeners
        jSpinner.addChangeListener(event -> jSpinnerAction());
        sortTypeComboBox.addActionListener(event -> sortTypeComboBoxAction());
        generateNewGraphButton.addActionListener(event -> generateNewGraphButtonAction());
        previousStepButton.addActionListener(event -> previousStepButtonAction());
        playButton.addActionListener(event -> playButtonAction());
        nextStepButton.addActionListener(event -> { nextStepButtonAction(); });
        this.addComponentListener(new ComponentListener()
        {
          @Override
          public void componentResized(ComponentEvent e)
          {
              refreshBarWidth(currentBarGraph);
          }

          @Override
          public void componentMoved(ComponentEvent e)
          {

          }

          @Override
          public void componentShown(ComponentEvent e)
          {

          }

          @Override
          public void componentHidden(ComponentEvent e)
          {

          }
        });
    }

    private void nextStepButtonAction()
    {

    }

    private void playButtonAction()
    {

    }

    private void previousStepButtonAction()
    {

    }

    private void generateNewGraphButtonAction()
    {
        currentBarGraph = main.generateNewBarGraph(this, (int) jSpinner.getValue());
        addBarGraphToBarPanel(currentBarGraph);
    }

    private void sortTypeComboBoxAction()
    {

    }

    private void jSpinnerAction()
    {
        if(Integer.parseInt(jSpinner.getValue().toString()) > SPINNER_MAX)
        {
            jSpinner.setValue(SPINNER_MAX);
        }
        else if(Integer.parseInt(jSpinner.getValue().toString()) < SPINNER_MIN)
        {
            jSpinner.setValue(SPINNER_MIN);
        }
    }

    /**
     * Default is System Look and Feel unless there's an error.
     */
    public void setLookAndFeel()
    {
        //Set the look and feel of the window to System look and feel
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            System.err.println("Unsupported Look & Feel Exception: Switching to default...");
            setDefaultLookAndFeelDecorated(true);
        }
        catch (ClassNotFoundException e) {
            // handle exception
            System.err.println("Class not Found Exception: Switching to default...");
            setDefaultLookAndFeelDecorated(true);
        }
        catch (InstantiationException e) {
            System.err.println("Instantiation Exception: Switching to default...");
            setDefaultLookAndFeelDecorated(true);
        }
        catch (IllegalAccessException e) {
            // handle exception
            System.err.println("Illegal Access Exception: Switching to default...");
            setDefaultLookAndFeelDecorated(true);
        }
    }

    public void addBarGraphToBarPanel(ArrayList<Bar> arr)
    {
        barPanel.removeAll();
        setBarPanelGridLayout(arr.size());
        for(int i = 0; i < arr.size(); i++)
        {
            barPanel.add(arr.get(i), i);
            arr.get(i).setyPos(barPanel.getHeight() - arr.get(i).getHeight() - 6);
            arr.get(i).setxPos(arr.get(i).getxPos() + 1);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void refreshBarWidth(ArrayList<Bar> currentBarGraph)
    {
        if(currentBarGraph != null)
        {
            final int marginBetweenBars = 5;
            for(Bar b : currentBarGraph)
            {
                b.setWidth(barPanel.getWidth() / currentBarGraph.size() - marginBetweenBars);
                int newHeight = (int) Math.round(((double) b.getHeight() / (double) this.oldHeight) *
                        (double) barPanel.getHeight());
                b.setHeight(newHeight);
                b.setyPos(barPanel.getHeight() - b.getHeight() - 6);
                b.repaint();
            }
            this.oldHeight = barPanel.getHeight();
        }
    }

    public void setBarPanelGridLayout(int numberOfColumns)
    {
        GridLayout gridLayout = new GridLayout(1, numberOfColumns);
        System.out.println(gridLayout);
        barPanel.setLayout(gridLayout);
    }

    public JSpinner getjSpinner()
    {
        return jSpinner;
    }

    public void setjSpinner(JSpinner jSpinner)
    {
        this.jSpinner = jSpinner;
    }

    public JButton getGenerateNewGraphButton()
    {
        return generateNewGraphButton;
    }

    public void setGenerateNewGraphButton(JButton generateNewGraphButton)
    {
        this.generateNewGraphButton = generateNewGraphButton;
    }

    public JButton getPreviousStepButton()
    {
        return previousStepButton;
    }

    public void setPreviousStepButton(JButton previousStepButton)
    {
        this.previousStepButton = previousStepButton;
    }

    public JButton getPlayButton()
    {
        return playButton;
    }

    public void setPlayButton(JButton playButton)
    {
        this.playButton = playButton;
    }

    public JButton getNextStepButton()
    {
        return nextStepButton;
    }

    public void setNextStepButton(JButton nextStepButton)
    {
        this.nextStepButton = nextStepButton;
    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public JPanel getBarPanel()
    {
        return barPanel;
    }

    public void setBarPanel(JPanel barPanel)
    {
        this.barPanel = barPanel;
    }

    public JComboBox getSortTypeComboBox()
    {
        return sortTypeComboBox;
    }

    public void setSortTypeComboBox(JComboBox sortTypeComboBox)
    {
        this.sortTypeComboBox = sortTypeComboBox;
    }
}
