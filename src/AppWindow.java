import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame
{
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

    public AppWindow(Main main)
    {
        this.setLookAndFeel();
        this.setMinimumSize(mainPanel.getMinimumSize());
        // The ComboBox only supports 1 type of sort at the moment.
        // TODO: Add more sorting types in the future.
        sortTypeComboBox.addItem(new QuickSort());
        this.mainPanel.setBackground(Color.gray);
        this.barPanel.setBackground(Color.darkGray);
        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Screen.width / 2, Screen.height / 2);
        this.setVisible(true);
        this.setLocation((Screen.width / 2) - (this.mainPanel.getWidth() / 2), (Screen.height / 2) - (this.mainPanel.getHeight() / 2));
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

    public void setBarPanelGridLayout(int numberOfColumns)
    {
        barPanel.setLayout(new GridLayout(1, numberOfColumns));
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
