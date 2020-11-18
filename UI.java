import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.net.URL;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author Alex Hodges  Editor: Kerry Uchtorff
 */

//(Requirement 1.1. Program Begins with opening a graphical User Interface)
//(Requirement 1.1.1. The program launches when user clicks on the .Jar file Icon)
//(Requirement 1.1.2. Program opens a new window with all fields blank)
//(Requirement 1.1.2.1. All Fields will display various parts of the character)
public class UI extends JFrame{
    
 //Variables needed to create characters. 
    Start here = new Start();
    String align = null;
    Character player;
    String race= null;
    String background = null;
    String charclass = null;
    char_class occupation = null;
    String charname = null;
   
    int[] statarray = new int[6];
    String rollChoice = "Rolled Auto Assigned";
    
    String[] rollChoices = {"Rolled Auto Assigned", "Rolled User Assigned", "Standard Array"};
	
    String[] classStrings = {"Select", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
    
    String[] allSkills = {"Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand", "Stealth", "Survival"};
    
    String[] barbarianSubStrings = {"Berserker", "Totem"};
    String[] bardSubStrings = {"Lore","Valor"};
    String[] clericSubStrings = {"Knowledge", "Life", "Light", "Nature", "Tempest", "Trickery", "War"};
    String[] druidSubStrings = {"Land", "Moon"};
    String[] fighterSubStrings = {"Battle Master", "Champion", "Eldritch Knight"};
    String[] monkSubStrings = {"Four Elements", "Open-Hand", "Shadow"};
    String[] paladinSubStrings = {"Ancients", "Devotion", "Vengeance"};
    String[] rangerSubStrings = {"Beast Master", "Hunter"};
    String[] rogueSubStrings = {"Arcane Trickster", "Assassin", "Thief"};
    String[] sorcererSubStrings = {"Draconic","Wild Magic"};
    String[] warlockSubStrings = {"Archfey", "Fiend", "Great Old One"};
    String[] wizardSubStrings = {"Abjuration", "Conjuration", "Divination", "Enchantment", "Evocation", "Illusion", "Necromancy", "Transmutation"};
    
    String[] raceStrings = {"Select", "Dragonborn", "Dwarf(Hill)", "Dwarf(Mountain)", "Elf(High)", "Elf(Wood)", "Elf(Dark/Drow)", "Gnome(Forest)", "Gnome(Rock)", "Half-Elf", "Halfling(Lightfoot)", 
        "Halfling(Stout)", "Half-Orc", "Human", "Tiefling"};
    
    String[] allignStrings = {"Select", "Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
    
    String[] abilityStrings = {"Strength", "Dexterity", "Intelligence", "Wisdom", "Charisma", "Constitution"};
    
    String[] backgrStrings = {"Select", "Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Outlander", "Sage", "Sailor", "Soldier", "Urchin"};
    
    String[] levelStrings = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    
    int spellLvl = 11;
    
    boolean raceSelected = false;
    boolean classSelected = false;
    boolean backgroundSelected = false;
    boolean nameentered = false;
    boolean Loadflag = false;
    boolean hasapplied = false;
    
    BufferedImage img;
    
    //Menu Bar
    JMenuBar menu;
    JMenu file;
    JMenuItem saveFile, loadFile, deleteFile, saveAndExit, exitProgram;
    
    JFrame masterFrame = new JFrame();
    
    //The Windows inside the tabs
    JPanel masterPanel = new JPanel(new FlowLayout());
    
    //Tab 1 Panels
        JPanel statSkillPanel = new JPanel(new BorderLayout());
            JPanel centerPanel = new JPanel();
                JPanel appearancePanel = new JPanel();
                JPanel weaponArmorPanel = new JPanel();
                    JPanel weaponBorderPanel = new JPanel();
                        JPanel weaponPanel = new JPanel();
                            JPanel weaponNamePanel = new JPanel();
                            JPanel weaponAtkPanel = new JPanel();
                            JPanel weaponDmgPanel = new JPanel();
                            JPanel weaponTypePanel = new JPanel();
                    JPanel armorBorderPanel = new JPanel();
                        JPanel armorPanel = new JPanel();
                JPanel filler1Panel = new JPanel();
                JPanel filler2Panel = new JPanel();
            JPanel headerPanel = new JPanel();
                JPanel choicePanel = new JPanel();
                JPanel namePanel = new JPanel();
            JPanel skillPanelBorder = new JPanel();
                JPanel skillPanel = new JPanel();
            JPanel statPanel = new JPanel();
                JPanel coreStatPanel = new JPanel();
                    JPanel hpPanel = new JPanel();
                    JPanel savePanel = new JPanel();
                        JPanel saveSubPanel = new JPanel();
                    JPanel deathPanel = new JPanel();
                        JPanel deathSavesPanel = new JPanel();
                        JPanel deathFailsPanel = new JPanel();
                JPanel abilityPanel = new JPanel();
                    JPanel abilityLabelPanel = new JPanel();
                    JPanel abilityScorePanel = new JPanel();
                    JPanel abilityModifierPanel = new JPanel();
        
    //Tab 2 Panels           
        JPanel infoItemPanel = new JPanel();
            JPanel cfeatureBorderPanel = new JPanel();
                JPanel cfeaturePanel = new JPanel();
                    JPanel langPanel = new JPanel();
            JPanel rfeatureBorderPanel = new JPanel();
                JPanel rfeaturePanel = new JPanel();
                    JPanel profPanel = new JPanel();
            JPanel infoBorderPanel = new JPanel();
                JPanel infoPanel = new JPanel();
                    JPanel infoUpdatePanel = new JPanel();
            JPanel itemPanel = new JPanel();
                JPanel itemHeaderPanel = new JPanel();
                    JPanel goldPanel = new JPanel();    
                    JPanel itemAddRemovePanel = new JPanel();
                    
    //Tab 3 Panels           
        JPanel spellcasterPanel = new JPanel();
            JPanel spellInteriorPanel = new JPanel();
                JPanel spellcastingInfoPanel = new JPanel();
                JPanel cantripSpellPanel = new JPanel();
                    JPanel cantripInfoPanel = new JPanel();
                    JPanel cantripAddPanel = new JPanel();
                JPanel level1SpellPanel = new JPanel();
                    JPanel level1InfoPanel = new JPanel();
                    JPanel level1AddPanel = new JPanel();
                JPanel level2SpellPanel = new JPanel();
                    JPanel level2InfoPanel = new JPanel();
                    JPanel level2AddPanel = new JPanel();
                JPanel level3SpellPanel = new JPanel();
                    JPanel level3InfoPanel = new JPanel();
                    JPanel level3AddPanel = new JPanel();
                JPanel level4SpellPanel = new JPanel();
                    JPanel level4InfoPanel = new JPanel();
                    JPanel level4AddPanel = new JPanel();
                JPanel level5SpellPanel = new JPanel();
                    JPanel level5InfoPanel = new JPanel();
                    JPanel level5AddPanel = new JPanel();
                JPanel level6SpellPanel = new JPanel();
                    JPanel level6InfoPanel = new JPanel();
                    JPanel level6AddPanel = new JPanel();
                JPanel level7SpellPanel = new JPanel();
                    JPanel level7InfoPanel = new JPanel();
                    JPanel level7AddPanel = new JPanel();
                JPanel level8SpellPanel = new JPanel();
                    JPanel level8InfoPanel = new JPanel();
                    JPanel level8AddPanel = new JPanel();
                JPanel level9SpellPanel = new JPanel();
                    JPanel level9InfoPanel = new JPanel();
                    JPanel level9AddPanel = new JPanel();
                JPanel otherSpellPanel = new JPanel();
                    JPanel otherAddPanel = new JPanel();
    //Tabs
    JTabbedPane tabbedPane = new JTabbedPane();
    
    //Option Panes
    JPanel halfElfAbilityPanel = new JPanel();
    JPanel halfElfSkillPanel = new JPanel();
    
    //Option Frames
    JFrame breathFrame = new JFrame();
    JFrame elfHLangFrame = new JFrame();
    JFrame halfElfLangFrame = new JFrame();
           
    //Icons
    String die = "\u2685";
    
/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////Buttons/////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    
    JButton roll = new JButton(); //Roll new Ability Socre
    JButton reassign = new JButton(); //Reassign the Current Scores
    JButton rollSettings = new JButton();//Choose Roll 4d6 drop lowest, Standard Array, Manual, Roll Random Assignment) User needs to be able to choose dist. of stats unless they select random assignment, In which case the roll array should just be entered in order)
    JButton generate = new JButton();
    JButton save = new JButton();
    JButton refresh = new JButton();
    
    JButton addItemButton = new JButton("+");
    JButton removeItemButton = new JButton("-");
    JButton addProfButton = new JButton("+");
    JButton removeProfButton = new JButton("-");
    JButton addLangButton = new JButton("+");
    JButton removeLangButton = new JButton("-");
    JButton setInfoButton = new JButton("Save Info");

    JButton otherAddSpellButton = new JButton("+");
    JButton cantripAddSpellButton = new JButton("+");
    JButton level1AddSpellButton = new JButton("+");
    JButton level2AddSpellButton = new JButton("+");
    JButton level3AddSpellButton = new JButton("+");
    JButton level4AddSpellButton = new JButton("+");
    JButton level5AddSpellButton = new JButton("+");
    JButton level6AddSpellButton = new JButton("+");
    JButton level7AddSpellButton = new JButton("+");
    JButton level8AddSpellButton = new JButton("+");
    JButton level9AddSpellButton = new JButton("+");
    
    JButton otherRemoveSpellButton = new JButton("-");
    JButton cantripRemoveSpellButton = new JButton("-");
    JButton level1RemoveSpellButton = new JButton("-");
    JButton level2RemoveSpellButton = new JButton("-");
    JButton level3RemoveSpellButton = new JButton("-");
    JButton level4RemoveSpellButton = new JButton("-");
    JButton level5RemoveSpellButton = new JButton("-");
    JButton level6RemoveSpellButton = new JButton("-");
    JButton level7RemoveSpellButton = new JButton("-");
    JButton level8RemoveSpellButton = new JButton("-");
    JButton level9RemoveSpellButton = new JButton("-");

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Check Boxes///////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    
    JCheckBox save1 = new JCheckBox();
    JCheckBox save2 = new JCheckBox();
    JCheckBox save3 = new JCheckBox();
    JCheckBox fail1 = new JCheckBox();
    JCheckBox fail2 = new JCheckBox();
    JCheckBox fail3 = new JCheckBox();
    
    JCheckBox strSaveProf = new JCheckBox();
    JCheckBox dexSaveProf = new JCheckBox();
    JCheckBox conSaveProf = new JCheckBox();
    JCheckBox intSaveProf = new JCheckBox();
    JCheckBox wisSaveProf = new JCheckBox();
    JCheckBox chaSaveProf = new JCheckBox();
    
    JCheckBox shield = new JCheckBox();
    
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Text Fields///////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////    
    
    //Name Textbox
    JTextField name = new JTextField(15);
    JTextField exp = new JTextField(4);
    JTextField subclassBox = new JTextField(15);
    
    //Health
    JTextField hp_current = new JTextField(2);
    JTextField hp_max = new JTextField(2);
    
    JTextField hitDice = new JTextField(2);
    
    JTextField armorClass = new JTextField(2);
    JTextField initiative = new JTextField(2);
    JTextField speed = new JTextField(2);
    JTextField profField = new JTextField(2);
    
    //Appearance TextBoxes
    JTextField ageBox = new JTextField(2);
    JTextField heightBox = new JTextField(2);
    JTextField weightBox = new JTextField(2);
    JTextField sizeBox = new JTextField(2);
    JTextField eyesBox = new JTextField(4);
    JTextField hairBox = new JTextField(4); 
    
    //Weapon TextBoxes
    JTextField weaponName1 = new JTextField(8);
    JTextField weaponAtk1 = new JTextField(2);
    JTextField weaponDmg1 = new JTextField(6);
    JTextField weaponType1 = new JTextField(1);
    JTextField weaponName2 = new JTextField(8);
    JTextField weaponAtk2 = new JTextField(2);
    JTextField weaponDmg2 = new JTextField(6);
    JTextField weaponType2 = new JTextField(1);
    JTextField weaponName3 = new JTextField(8);
    JTextField weaponAtk3 = new JTextField(2);
    JTextField weaponDmg3 = new JTextField(6);
    JTextField weaponType3 = new JTextField(1);
    
    //Armor TextBoxes
    JTextField armorName1 = new JTextField(8);
    JTextField armorAC1 = new JTextField(2);
    JTextField armorMagic1 = new JTextField(2);
    
    //Ability Score Boxes
    JTextField str_score = new JTextField(2);
    JTextField dex_score = new JTextField(2);
    JTextField con_score = new JTextField(2);
    JTextField int_score = new JTextField(2);
    JTextField wis_score = new JTextField(2);
    JTextField cha_score = new JTextField(2);
    
    JTextField str_mod = new JTextField(2);
    JTextField dex_mod = new JTextField(2);
    JTextField con_mod = new JTextField(2);
    JTextField int_mod = new JTextField(2);
    JTextField wis_mod = new JTextField(2);
    JTextField cha_mod = new JTextField(2);
    
    JTextField str_save = new JTextField(2);
    JTextField dex_save = new JTextField(2);
    JTextField con_save = new JTextField(2);
    JTextField int_save = new JTextField(2);
    JTextField wis_save = new JTextField(2);
    JTextField cha_save = new JTextField(2);
    
    JTextField acroField = new JTextField(2);
    JTextField animField = new JTextField(2);
    JTextField arcaField = new JTextField(2);
    JTextField athlField = new JTextField(2);
    JTextField deceField = new JTextField(2);
    JTextField histField = new JTextField(2);
    JTextField insiField = new JTextField(2);
    JTextField intiField = new JTextField(2);
    JTextField inveField = new JTextField(2);
    JTextField mediField = new JTextField(2);
    JTextField natuField = new JTextField(2);
    JTextField percField = new JTextField(2);
    JTextField perfField = new JTextField(2);
    JTextField persField = new JTextField(2);
    JTextField reliField = new JTextField(2);
    JTextField sleiField = new JTextField(2);
    JTextField steaField = new JTextField(2);
    JTextField survField = new JTextField(2);
    
    JTextField profAddRemoveBox = new JTextField(10);
    JTextField langAddRemoveBox = new JTextField(10);
    
    JTextField cpBox = new JTextField(3);
    JTextField spBox = new JTextField(3);
    JTextField epBox = new JTextField(3);
    JTextField gpBox = new JTextField(3);
    JTextField ppBox = new JTextField(3);
    JTextField itemBox = new JTextField(10);
    
    JTextField spellAbilBox = new JTextField(3);
    JTextField spellModBox = new JTextField(2);
    JTextField spellSaveBox = new JTextField(2);
    JTextField warlockLeftBox = new JTextField(2);
    JTextField warlockTotalBox = new JTextField(2);
    JTextField kiLeftBox = new JTextField(2);
    JTextField kiTotalBox = new JTextField(2);
    JTextField sorceryLeftBox = new JTextField(2);
    JTextField sorceryTotalBox = new JTextField(2);
    
    JTextField otherBox = new JTextField(10);
    JTextField cantripBox = new JTextField(10);
    JTextField level1Box = new JTextField(10);
    JTextField level2Box = new JTextField(10);
    JTextField level3Box = new JTextField(10);
    JTextField level4Box = new JTextField(10);
    JTextField level5Box = new JTextField(10);
    JTextField level6Box = new JTextField(10);
    JTextField level7Box = new JTextField(10);
    JTextField level8Box = new JTextField(10);
    JTextField level9Box = new JTextField(10);
    
    JTextField level1CastBox = new JTextField(2);
    JTextField level2CastBox = new JTextField(2);
    JTextField level3CastBox = new JTextField(2);
    JTextField level4CastBox = new JTextField(2);
    JTextField level5CastBox = new JTextField(2);
    JTextField level6CastBox = new JTextField(2);
    JTextField level7CastBox = new JTextField(2);
    JTextField level8CastBox = new JTextField(2);
    JTextField level9CastBox = new JTextField(2);
    
    JTextField level1TotalBox = new JTextField(2);
    JTextField level2TotalBox = new JTextField(2);
    JTextField level3TotalBox = new JTextField(2);
    JTextField level4TotalBox = new JTextField(2);
    JTextField level5TotalBox = new JTextField(2);
    JTextField level6TotalBox = new JTextField(2);
    JTextField level7TotalBox = new JTextField(2);
    JTextField level8TotalBox = new JTextField(2);
    JTextField level9TotalBox = new JTextField(2);
    
/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////Labels//////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    
    JLabel na = new JLabel("Name");
    JLabel hp = new JLabel("HP");
    JLabel hd = new JLabel("HIT DICE");
    JLabel ac = new JLabel("AC");
    JLabel init = new JLabel("INITIATIVE");
    JLabel sp = new JLabel("SPEED");
    JLabel pr = new JLabel("PROF BNS");
    JLabel cl = new JLabel("Class");
    JLabel ra = new JLabel("Race");
    JLabel ba = new JLabel("Background");
    JLabel sc = new JLabel("Subclass");
    JLabel al = new JLabel("Alignment");
    JLabel lv = new JLabel("Level");
    JLabel xp = new JLabel("XP");
    
    //Appearance
    JLabel ageLabel = new JLabel("Age");
    JLabel heightLabel = new JLabel("Height");
    JLabel weightLabel = new JLabel("Weight");
    JLabel sizeLabel = new JLabel("Size");
    JLabel eyesLabel = new JLabel("Eyes");
    JLabel hairLabel = new JLabel("Hair");
    
    //Weapons
    JLabel weaponLabel = new JLabel("Weapons");
    JLabel weaponName = new JLabel("Name");
    JLabel weaponAtk = new JLabel("Atk Bns");
    JLabel weaponDmg = new JLabel("Damage");
    JLabel weaponType = new JLabel("Type");
    
    //Armor
    JLabel armorLabel = new JLabel("Armor");
    JLabel armorName = new JLabel("Name");
    JLabel armorAC = new JLabel("AC");
    JLabel armorBonus = new JLabel("Bonus");
    JLabel armorShield = new JLabel("Shield");
    
    //Ability Score
    JLabel st = new JLabel("Str");
    JLabel de = new JLabel("Dex");
    JLabel co = new JLabel("Con");
    JLabel in = new JLabel("Int");
    JLabel wi = new JLabel("Wis");
    JLabel ch = new JLabel("Cha");
    
    //Ability Saves
    JLabel saves = new JLabel("Saving Throws");
    JLabel stS = new JLabel("Str");
    JLabel deS = new JLabel("Dex");
    JLabel coS = new JLabel("Con");
    JLabel inS = new JLabel("Int");
    JLabel wiS = new JLabel("Wis");
    JLabel chS = new JLabel("Cha");
    
    //Death Saves
    JLabel ds = new JLabel("Death Saves");
    JLabel dsave = new JLabel("Save");
    JLabel dfail = new JLabel("   Fail");
    
    //Item and Info Text Area Labels
    JLabel item = new JLabel("Items");
    JLabel info = new JLabel("Info");
    JLabel Cfeat = new JLabel("Subclass Features");
    JLabel Rfeat = new JLabel("Other Features");
    JLabel profs = new JLabel("Proficiencies");
    JLabel lang = new JLabel("Languages");
    
    //Money Labels
    JLabel c$ = new JLabel("CP");
    JLabel s$ = new JLabel("SP");
    JLabel e$ = new JLabel("EP");
    JLabel g$ = new JLabel("GP");
    JLabel p$ = new JLabel("PP");
    
    //Empty Labels
    JLabel empty0 = new JLabel("");
    JLabel empty1 = new JLabel("");
    JLabel empty2 = new JLabel("");
    JLabel empty3 = new JLabel("");
    JLabel empty4 = new JLabel("");
    JLabel empty5 = new JLabel("");
    JLabel empty6 = new JLabel("                                                 ");
    JLabel empty7 = new JLabel("                                                         ");
    JLabel empty8 = new JLabel("                                                         ");
    JLabel empty9 = new JLabel("                                                 ");
    JLabel empty10 = new JLabel("                                                        ");
    JLabel empty11 = new JLabel("                                                        ");
    JLabel empty12 = new JLabel("                                                        ");
    JLabel empty13 = new JLabel("                                                        ");
    JLabel empty14 = new JLabel("                                                        ");
     JLabel empty15 = new JLabel("                                                        ");
    
    JLabel acro = new JLabel("Acrobatics");
    JLabel anim = new JLabel("Animal Handling");
    JLabel arca = new JLabel("Arcana");
    JLabel athl = new JLabel("Athletics");
    JLabel dece = new JLabel("Deception");
    JLabel hist = new JLabel("History");
    JLabel insi = new JLabel("Insight");
    JLabel inti = new JLabel("Intimidation");
    JLabel inve = new JLabel("Investigation");
    JLabel medi = new JLabel("Medicine");
    JLabel natu = new JLabel("Nature");
    JLabel perc = new JLabel("Perception");
    JLabel perf = new JLabel("Performance");
    JLabel pers = new JLabel("Persuasion");
    JLabel reli = new JLabel("Religion");
    JLabel slei = new JLabel("Sleight of Hand");
    JLabel stea = new JLabel("Stealth");
    JLabel surv = new JLabel("Survival");
    
    JLabel st1 = new JLabel("   Str");
    JLabel de1 = new JLabel("   Dex");
    JLabel de2 = new JLabel("   Dex");
    JLabel de3 = new JLabel("   Dex");
    JLabel in1 = new JLabel("   Int");
    JLabel in2 = new JLabel("   Int");
    JLabel in3 = new JLabel("   Int");
    JLabel in4 = new JLabel("   Int");
    JLabel in5 = new JLabel("   Int");
    JLabel wi1 = new JLabel("   Wis");
    JLabel wi2 = new JLabel("   Wis");
    JLabel wi3 = new JLabel("   Wis");
    JLabel wi4 = new JLabel("   Wis");
    JLabel wi5 = new JLabel("   Wis");
    JLabel ch1 = new JLabel("   Cha");
    JLabel ch2 = new JLabel("   Cha");
    JLabel ch3 = new JLabel("   Cha");
    JLabel ch4 = new JLabel("   Cha");
    
    JLabel otherSpells = new JLabel("Race & Class Spells");
    JLabel cantripSpells = new JLabel("Cantrips");
    JLabel lvl1Spells = new JLabel("Level 1");
    JLabel lvl2Spells = new JLabel("Level 2");
    JLabel lvl3Spells = new JLabel("Level 3");
    JLabel lvl4Spells = new JLabel("Level 4");
    JLabel lvl5Spells = new JLabel("Level 5");
    JLabel lvl6Spells = new JLabel("Level 6");
    JLabel lvl7Spells = new JLabel("Level 7");
    JLabel lvl8Spells = new JLabel("Level 8");
    JLabel lvl9Spells = new JLabel("Level 9");
    JLabel spellAbil = new JLabel("Spellcasting Ability");
    JLabel spellMod = new JLabel("Spellcasting Modifier");
    JLabel spellSave = new JLabel("Spell Save DC");
    JLabel warlockLabel = new JLabel("Warlock Slots");
    JLabel kiLabel = new JLabel("Ki Points");
    JLabel sorceryLabel = new JLabel("Sorcery Points");
    
/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////Areas///////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    JTextArea item_area = new JTextArea(5,20);
    JTextArea info_area = new JTextArea(5,20);
    JTextArea rfeature_area = new JTextArea(5,20);
    JTextArea cfeature_area = new JTextArea(5,20);
    JTextArea language_area = new JTextArea(5,20);
    JTextArea proficiency_area = new JTextArea(5,20);
    
    JTextArea cantripTextArea = new JTextArea();
    JTextArea otherSpellTextArea = new JTextArea();
    JTextArea level1TextArea = new JTextArea();
    JTextArea level2TextArea = new JTextArea();
    JTextArea level3TextArea = new JTextArea();
    JTextArea level4TextArea = new JTextArea();
    JTextArea level5TextArea = new JTextArea();
    JTextArea level6TextArea = new JTextArea();
    JTextArea level7TextArea = new JTextArea();
    JTextArea level8TextArea = new JTextArea();
    JTextArea level9TextArea = new JTextArea();

/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////Boxes///////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    JComboBox classList = new JComboBox(classStrings);
    JComboBox raceList = new JComboBox(raceStrings);
    JComboBox allignList = new JComboBox(allignStrings);
    JComboBox backgrList = new JComboBox(backgrStrings);
    JComboBox levelList = new JComboBox(levelStrings);
    JComboBox rollList = new JComboBox(rollChoices);
    
    JComboBox abilityList1 = new JComboBox(abilityStrings);//Half Elf
    JComboBox abilityList2 = new JComboBox(abilityStrings);//Half Elf 
    
    JComboBox skillList1 = new JComboBox(allSkills);//Half Elf
    JComboBox skillList2 = new JComboBox(allSkills);//Half Elf
    
/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////Pop Ups/////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    JOptionPane breathWeapon = new JOptionPane();
    
/////////////////////////////////////////////////////////////////////////////
///////////////////////////////////Choices/////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////    
    Choice choice = new Choice();
    
/////////////////////////////////////////////////////////////////////////////
//////////////////////////////////  Listeners////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////
    private final ItemHandler boxHandler = new ItemHandler();
    private final ApplyListener generateListener = new ApplyListener();
    private final NameListener nameSave = new NameListener();
    private final RollListener rollad6 = new RollListener();
    private final AddSpell addSpell = new AddSpell();
    private final RemoveSpell removeSpell = new RemoveSpell();
    private final AddItem addItem = new AddItem();
    private final RemoveItem removeItem = new RemoveItem();
    private final RefreshListener refreshAll = new RefreshListener();
    private final SaveListener saveListener = new SaveListener();
    private final DeleteListener deleteListener = new DeleteListener();
    private final ExitListener exitListener = new ExitListener();
    private final SaveExitListener saveexitListener = new SaveExitListener();
    private final LoadListener loadListener = new LoadListener();
    private final RollSettingListener rollSettingListener = new RollSettingListener();
    private final RollAssignListener rollAssignListener = new RollAssignListener();
    private final AddLangListener langAddListener = new AddLangListener();
    private final RemoveLangListener langRemoveListener = new RemoveLangListener();
    private final InfoListener setInfoListener = new InfoListener();
    private final AddProfListener profAddListener = new AddProfListener();
    private final RemoveProfListener profRemoveListener = new RemoveProfListener();
    
    
    public UI(){
        super("Purple Slime's 5th Edition Character Menu");//Name at the Top of UI Window
        setSize(1350,800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Menu Bar
        menu = new JMenuBar();
        file = new JMenu("File");
        
        saveFile = new JMenuItem("Save");
        loadFile = new JMenuItem("Load");
        deleteFile = new JMenuItem("Delete");
        saveAndExit = new JMenuItem("Save and Exit");
        exitProgram = new JMenuItem("Exit");
        
        saveFile.addActionListener(saveListener); //(Requirement 4.1) User clicks Save to save the character.
        deleteFile.addActionListener(deleteListener);  //(Requirement 5.1) User clicks Save to save the character.
        loadFile.addActionListener(loadListener);  //(Requirement 6.1) User clicks Load to save the character.
        saveAndExit.addActionListener(saveexitListener); //(Requirement 9.1) Save the character before closing the program
        exitProgram.addActionListener(exitListener); //(Requirement 10.1) Save the character before closing the program
        
        file.add(saveFile);
        file.add(loadFile);
        file.add(deleteFile);
        file.add(saveAndExit);
        file.add(exitProgram);
        
        menu.add(file);

        info_area.setText("");
        
        //Font of Labels
        String font = "Algerian";
        sc.setFont(new Font(font, Font.PLAIN, 14));
        na.setFont(new Font(font, Font.PLAIN, 14));
        cl.setFont(new Font(font, Font.PLAIN, 14));
        ra.setFont(new Font(font, Font.PLAIN, 14));
        ba.setFont(new Font(font, Font.PLAIN, 14));
        al.setFont(new Font(font, Font.PLAIN, 14));
        st.setFont(new Font(font, Font.PLAIN, 15));
        de.setFont(new Font(font, Font.PLAIN, 15));
        co.setFont(new Font(font, Font.PLAIN, 15));
        in.setFont(new Font(font, Font.PLAIN, 15));
        wi.setFont(new Font(font, Font.PLAIN, 15));
        ch.setFont(new Font(font, Font.PLAIN, 15));
        item.setFont(new Font(font, Font.PLAIN, 14));
        Cfeat.setFont(new Font(font, Font.PLAIN, 14));
        Rfeat.setFont(new Font(font, Font.PLAIN, 14));
        info.setFont(new Font(font, Font.PLAIN, 14));
        lang.setFont(new Font(font, Font.PLAIN, 14));
        profs.setFont(new Font(font, Font.PLAIN, 14));
        lv.setFont(new Font(font, Font.PLAIN, 14));
        weaponLabel.setFont(new Font(font, Font.PLAIN, 14));
        armorLabel.setFont(new Font(font, Font.PLAIN, 14));
        
        hp.setFont(new Font(font, Font.PLAIN, 14));
        hd.setFont(new Font(font, Font.PLAIN, 14));
        ac.setFont(new Font(font, Font.PLAIN, 14));
        init.setFont(new Font(font, Font.PLAIN, 14));
        sp.setFont(new Font(font, Font.PLAIN, 14));
        pr.setFont(new Font(font, Font.PLAIN, 14));
        ds.setFont(new Font(font, Font.PLAIN, 14));
        saves.setFont(new Font(font, Font.PLAIN, 14));
        xp.setFont(new Font(font, Font.PLAIN, 14));
        cantripSpells.setFont(new Font(font, Font.PLAIN, 14));
        lvl1Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl2Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl3Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl4Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl5Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl6Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl7Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl8Spells.setFont(new Font(font, Font.PLAIN, 14));
        lvl9Spells.setFont(new Font(font, Font.PLAIN, 14));
        otherSpells.setFont(new Font(font, Font.PLAIN, 14));
        
/////////////////////////////////////////////////////////////////////////////
////////////////////////////////Panel Layouts////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
        
        //Tab 1 Header Box Layout
        BoxLayout headLayout = new BoxLayout(headerPanel, BoxLayout.Y_AXIS);
        headerPanel.setLayout(headLayout);
        
        //Ability Score Labels Box Layout
        BoxLayout choiceLayout = new BoxLayout(headerPanel, BoxLayout.X_AXIS);
        abilityLabelPanel.setLayout(choiceLayout);
        
        //Ability Score Labels Box Layout
        BoxLayout nameLayout = new BoxLayout(headerPanel, BoxLayout.X_AXIS);
        abilityLabelPanel.setLayout(nameLayout);
        
        //Ability Panel Box Layout
        BoxLayout abilityLayout = new BoxLayout(abilityPanel, BoxLayout.X_AXIS);
        abilityLabelPanel.setLayout(abilityLayout);
        
        //Ability Score Labels Box Layout
        BoxLayout lLayout = new BoxLayout(abilityLabelPanel, BoxLayout.Y_AXIS);
        abilityLabelPanel.setLayout(lLayout);

        //Ability Scores Box Layout
        BoxLayout cLayout = new BoxLayout(abilityScorePanel, BoxLayout.Y_AXIS);
        abilityScorePanel.setLayout(cLayout);

        //Ability Modifiers Box
        BoxLayout rLayout = new BoxLayout(abilityModifierPanel, BoxLayout.Y_AXIS);
        abilityModifierPanel.setLayout(rLayout);
        
        //Skills Grid
        GridLayout skillLayout = new GridLayout(0,3);
        skillPanel.setLayout(skillLayout);
        
        //Skill Border
        BorderLayout skillBorderLayout = new BorderLayout();
        skillPanelBorder.setLayout(skillBorderLayout);
        
        //Saves
        BorderLayout saveLayout = new BorderLayout();
        savePanel.setLayout(saveLayout);
        
        GridLayout saveSubLayout = new GridLayout(0,3);
        saveSubPanel.setLayout(saveSubLayout);
        
        //Death Save
        BoxLayout deathLayout = new BoxLayout(deathPanel, BoxLayout.Y_AXIS);
        deathPanel.setLayout(deathLayout);
        
        //Core Stat Grid
        BoxLayout coreStatLayout = new BoxLayout(coreStatPanel, BoxLayout.Y_AXIS);
        coreStatPanel.setLayout(coreStatLayout);
        
        GridLayout hpLayout = new GridLayout(0,3);
        hpPanel.setLayout(hpLayout);
        
        BoxLayout centerLayout = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
        centerPanel.setLayout(centerLayout);
        
        BoxLayout weaponArmorLayout = new BoxLayout(weaponArmorPanel, BoxLayout.X_AXIS);
        weaponArmorPanel.setLayout(weaponArmorLayout);
        
        BoxLayout profInsertLayout = new BoxLayout(profPanel, BoxLayout.X_AXIS);
        profPanel.setLayout(profInsertLayout);

        BoxLayout langInsertLayout = new BoxLayout(langPanel, BoxLayout.X_AXIS);
        langPanel.setLayout(langInsertLayout);
        
        BorderLayout infoInsertLayout = new BorderLayout();
        infoUpdatePanel.setLayout(infoInsertLayout);
        
        BorderLayout cfeatureBorderLayout = new BorderLayout();
        cfeatureBorderPanel.setLayout(cfeatureBorderLayout);
        
        BorderLayout rfeatureBorderLayout = new BorderLayout();
        rfeatureBorderPanel.setLayout(rfeatureBorderLayout);
        
        BorderLayout infoBorderLayout = new BorderLayout();
       infoBorderPanel.setLayout(infoBorderLayout);
        
        BorderLayout armorBorderLayout = new BorderLayout();
        armorBorderPanel.setLayout(armorBorderLayout);
        
        BorderLayout weaponBorderLayout = new BorderLayout();
        weaponBorderPanel.setLayout(weaponBorderLayout);
        
        BoxLayout weaponLayout = new BoxLayout(weaponPanel, BoxLayout.X_AXIS);
        weaponPanel.setLayout(weaponLayout);
        
        BoxLayout weaponNameLayout = new BoxLayout(weaponNamePanel, BoxLayout.Y_AXIS);
        weaponNamePanel.setLayout(weaponNameLayout);
        
        BoxLayout weaponAtkLayout = new BoxLayout(weaponAtkPanel, BoxLayout.Y_AXIS);
        weaponAtkPanel.setLayout(weaponAtkLayout);
        
        BoxLayout weaponDmgLayout = new BoxLayout(weaponDmgPanel, BoxLayout.Y_AXIS);
        weaponDmgPanel.setLayout(weaponDmgLayout);
        
        BoxLayout weaponTypeLayout = new BoxLayout(weaponTypePanel, BoxLayout.Y_AXIS);
        weaponTypePanel.setLayout(weaponTypeLayout);
        
        BoxLayout armorLayout = new BoxLayout(armorPanel, BoxLayout.X_AXIS);
        armorPanel.setLayout(armorLayout);
        
        BoxLayout statLayout = new BoxLayout(statPanel, BoxLayout.Y_AXIS);
        statPanel.setLayout(statLayout);
        
        GridLayout spellGridLayout = new GridLayout(0,1);
        spellcasterPanel.setLayout(spellGridLayout);
        
        GridLayout spellInteriorLayout = new GridLayout(0,6);
        spellInteriorPanel.setLayout(spellInteriorLayout);
        
        BorderLayout spellBorderLayout1 = new BorderLayout();
        BorderLayout spellBorderLayout2 = new BorderLayout();
        BorderLayout spellBorderLayout3 = new BorderLayout();
        BorderLayout spellBorderLayout4 = new BorderLayout();
        BorderLayout spellBorderLayout5 = new BorderLayout();
        BorderLayout spellBorderLayout6 = new BorderLayout();
        BorderLayout spellBorderLayout7 = new BorderLayout();
        BorderLayout spellBorderLayout8 = new BorderLayout();
        BorderLayout spellBorderLayout9 = new BorderLayout();
        BorderLayout spellBorderLayout10 = new BorderLayout();
        BorderLayout spellBorderLayout11 = new BorderLayout();
        otherSpellPanel.setLayout(spellBorderLayout1);
        cantripSpellPanel.setLayout(spellBorderLayout2);
        level1SpellPanel.setLayout(spellBorderLayout3);
        level2SpellPanel.setLayout(spellBorderLayout4);
        level3SpellPanel.setLayout(spellBorderLayout5);
        level4SpellPanel.setLayout(spellBorderLayout6);
        level5SpellPanel.setLayout(spellBorderLayout7);
        level6SpellPanel.setLayout(spellBorderLayout8);
        level7SpellPanel.setLayout(spellBorderLayout9);
        level8SpellPanel.setLayout(spellBorderLayout10);
        level9SpellPanel.setLayout(spellBorderLayout11);
        
/////////////////////////////////////////////////////////////////////////////
//////////////////////////////Textbox Alignment//////////////////////////////
/////////////////////////////////////////////////////////////////////////////        

        str_score.setHorizontalAlignment(JTextField.CENTER);
        dex_score.setHorizontalAlignment(JTextField.CENTER);
        con_score.setHorizontalAlignment(JTextField.CENTER);
        int_score.setHorizontalAlignment(JTextField.CENTER);
        wis_score.setHorizontalAlignment(JTextField.CENTER);
        cha_score.setHorizontalAlignment(JTextField.CENTER);

        str_mod.setHorizontalAlignment(JTextField.CENTER);
        dex_mod.setHorizontalAlignment(JTextField.CENTER);
        con_mod.setHorizontalAlignment(JTextField.CENTER);
        int_mod.setHorizontalAlignment(JTextField.CENTER);
        wis_mod.setHorizontalAlignment(JTextField.CENTER);
        cha_mod.setHorizontalAlignment(JTextField.CENTER);

        acroField.setHorizontalAlignment(JTextField.CENTER);
        animField.setHorizontalAlignment(JTextField.CENTER);
        arcaField.setHorizontalAlignment(JTextField.CENTER);
        athlField.setHorizontalAlignment(JTextField.CENTER);
        deceField.setHorizontalAlignment(JTextField.CENTER);
        histField.setHorizontalAlignment(JTextField.CENTER);        
        insiField.setHorizontalAlignment(JTextField.CENTER);        
        intiField.setHorizontalAlignment(JTextField.CENTER);        
        inveField.setHorizontalAlignment(JTextField.CENTER);
        mediField.setHorizontalAlignment(JTextField.CENTER);        
        natuField.setHorizontalAlignment(JTextField.CENTER);        
        percField.setHorizontalAlignment(JTextField.CENTER);        
        perfField.setHorizontalAlignment(JTextField.CENTER);        
        persField.setHorizontalAlignment(JTextField.CENTER);
        reliField.setHorizontalAlignment(JTextField.CENTER);        
        sleiField.setHorizontalAlignment(JTextField.CENTER);        
        steaField.setHorizontalAlignment(JTextField.CENTER);        
        survField.setHorizontalAlignment(JTextField.CENTER);
        
        hp_current.setHorizontalAlignment(JTextField.CENTER);
        hp_max.setHorizontalAlignment(JTextField.CENTER);
        armorClass.setHorizontalAlignment(JTextField.CENTER);
        hitDice.setHorizontalAlignment(JTextField.CENTER);
        initiative.setHorizontalAlignment(JTextField.CENTER);
        speed.setHorizontalAlignment(JTextField.CENTER);
        profField.setHorizontalAlignment(JTextField.CENTER);
        
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////Add/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

        //Class
        choicePanel.add(cl);
        choicePanel.add(classList); // (Requirement 3.2) User shall   select a class from a pre-populated list a class for the character
        classList.addItemListener(boxHandler);
        
        //Race
        choicePanel.add(ra);
        choicePanel.add(raceList); // (Requirement 3.1) User shall select race from pre-populated list 
        raceList.addItemListener(boxHandler);
        
        //Background
        choicePanel.add(ba);
        choicePanel.add(backgrList); // (Requirement 3.3) User shall select a background from a pre-populated list a background for the character
        backgrList.addItemListener(boxHandler);
        
        //Apply Button
        generate.addActionListener(generateListener); //(Requirement 3.6) User shall activate a clickable button named �Apply� to generate the character as a level 1 character.
        String skull = "\u26A0";
        generate.setText(skull+" Apply");
        generate.setBackground(Color.PINK);
        generate.setToolTipText("Generate Sheet based on Selections(CAUTION! Resets Sheet and Requires Reselection of choices!)");
        choicePanel.add(generate);
        
        
        //Name
        namePanel.add(na);
        namePanel.add(name);
        save.addActionListener(nameSave); //(Requirement 3.4.1) A clickable button with a pen on it will be provided to save the character name
        save.setText("\u270E");
        namePanel.add(save);
        
        //Level
        namePanel.add(lv);
        namePanel.add(levelList);
        levelList.addItemListener(boxHandler); //(Requirement 7.1) User clicks on the pre-populated drop down box of levels

        
        //Experience
        namePanel.add(xp);
        namePanel.add(exp);
        
        //HP
        hp_current.setToolTipText("Current Health");
        hp_max.setToolTipText("Maximum Health");
        hpPanel.add(hp);
        hpPanel.add(hp_current);
        hpPanel.add(hp_max);
        hpPanel.add(hd);
        hpPanel.add(hitDice);
        hpPanel.add(empty0);
        hpPanel.add(ac);
        hpPanel.add(armorClass);
        hpPanel.add(empty1);
        hpPanel.add(init);
        hpPanel.add(initiative);
        hpPanel.add(empty2);
        hpPanel.add(sp);
        hpPanel.add(speed);
        hpPanel.add(empty3);
        hpPanel.add(pr);
        hpPanel.add(profField);
        hpPanel.add(empty4);
        
        coreStatPanel.add(hpPanel);
        

        
        //Allignment
        namePanel.add(al);
        namePanel.add(allignList);
        allignList.addItemListener(boxHandler);
        
        
        //Subclass
        namePanel.add(sc);
        namePanel.add(subclassBox);
        refresh.addActionListener(refreshAll); // (Requirement 8.1) User clicks refresh button to refresh display. 
        refresh.setText("Refresh");
        namePanel.add(refresh);
        
        //Manual Stat Entry
        st.setAlignmentX(Component.LEFT_ALIGNMENT);
        de.setAlignmentX(Component.LEFT_ALIGNMENT);
        co.setAlignmentX(Component.LEFT_ALIGNMENT);
        in.setAlignmentX(Component.LEFT_ALIGNMENT);
        wi.setAlignmentX(Component.LEFT_ALIGNMENT);
        ch.setAlignmentX(Component.LEFT_ALIGNMENT);
        roll.setAlignmentX(Component.LEFT_ALIGNMENT);
        roll.setText("\u2685");
        roll.setFont(new Font("UTF-16", Font.PLAIN, 15));
        roll.setToolTipText("Roll the dice \u2685");
        roll.addActionListener(rollad6);
        abilityLabelPanel.add(st);
        abilityLabelPanel.add(de);
        abilityLabelPanel.add(co);
        abilityLabelPanel.add(in);
        abilityLabelPanel.add(wi);
        abilityLabelPanel.add(ch);
        abilityLabelPanel.add(roll);
        
        str_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        dex_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        con_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        int_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        wis_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        cha_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        reassign.setAlignmentX(Component.CENTER_ALIGNMENT);
        reassign.setText("\u21BB");
        reassign.setToolTipText("Reassign with current rolls");
        reassign.addActionListener(rollAssignListener);
        abilityScorePanel.add(str_score);
        abilityScorePanel.add(dex_score);
        abilityScorePanel.add(con_score);
        abilityScorePanel.add(int_score);
        abilityScorePanel.add(wis_score);
        abilityScorePanel.add(cha_score);
        abilityScorePanel.add(reassign);
        
        savePanel.add(saves, BorderLayout.PAGE_START);
        saveSubPanel.add(stS);
        saveSubPanel.add(str_save);
        saveSubPanel.add(strSaveProf);
        saveSubPanel.add(deS);
        saveSubPanel.add(dex_save);
        saveSubPanel.add(dexSaveProf);
        saveSubPanel.add(coS);
        saveSubPanel.add(con_save);
        saveSubPanel.add(conSaveProf);
        saveSubPanel.add(inS);
        saveSubPanel.add(int_save);
        saveSubPanel.add(intSaveProf);
        saveSubPanel.add(wiS);
        saveSubPanel.add(wis_save);
        saveSubPanel.add(wisSaveProf);
        saveSubPanel.add(chS);
        saveSubPanel.add(cha_save);
        saveSubPanel.add(chaSaveProf);
        savePanel.add(saveSubPanel, BorderLayout.CENTER);
        
        ds.setAlignmentX(Component.LEFT_ALIGNMENT);
        deathPanel.add(ds);
        deathSavesPanel.add(dsave);
        deathSavesPanel.add(save1);
        deathSavesPanel.add(save2);
        deathSavesPanel.add(save3);
        deathFailsPanel.add(dfail);
        deathFailsPanel.add(fail1);
        deathFailsPanel.add(fail2);
        deathFailsPanel.add(fail3);
        deathPanel.add(deathSavesPanel);
        deathPanel.add(deathFailsPanel);
        
        str_mod.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dex_mod.setAlignmentX(Component.RIGHT_ALIGNMENT);
        con_mod.setAlignmentX(Component.RIGHT_ALIGNMENT);
        int_mod.setAlignmentX(Component.RIGHT_ALIGNMENT);
        wis_mod.setAlignmentX(Component.RIGHT_ALIGNMENT);
        cha_mod.setAlignmentX(Component.RIGHT_ALIGNMENT);
        rollSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
        rollSettings.setText("\u2699");
        rollSettings.setToolTipText("Choose your roll method");
        rollSettings.addActionListener(rollSettingListener);
        abilityModifierPanel.add(str_mod);
        abilityModifierPanel.add(dex_mod);
        abilityModifierPanel.add(con_mod);
        abilityModifierPanel.add(int_mod);
        abilityModifierPanel.add(wis_mod);
        abilityModifierPanel.add(cha_mod);
        abilityModifierPanel.add(rollSettings);
        
        //Appearance Panel
        appearancePanel.add(ageLabel);
        appearancePanel.add(ageBox);
        appearancePanel.add(heightLabel);
        appearancePanel.add(heightBox);
        appearancePanel.add(weightLabel);
        appearancePanel.add(weightBox);
        appearancePanel.add(sizeLabel);
        appearancePanel.add(sizeBox);
        appearancePanel.add(eyesLabel);
        appearancePanel.add(eyesBox); //(Requirement 11.1.2) User enters eye color in eye text box
        appearancePanel.add(hairLabel); 
        appearancePanel.add(hairBox); //(Requirement 11.1.1) User enters hair color in hair text box
       
        //Weapon Panel
        weaponNamePanel.add(weaponName);
        weaponNamePanel.add(weaponName1);
        weaponNamePanel.add(weaponName2);
        weaponNamePanel.add(weaponName3);
        weaponAtkPanel.add(weaponAtk);
        weaponAtkPanel.add(weaponAtk1);
        weaponAtkPanel.add(weaponAtk2);
        weaponAtkPanel.add(weaponAtk3);
        weaponDmgPanel.add(weaponDmg);
        weaponDmgPanel.add(weaponDmg1);
        weaponDmgPanel.add(weaponDmg2);
        weaponDmgPanel.add(weaponDmg3);
        weaponTypePanel.add(weaponType);
        weaponTypePanel.add(weaponType1);
        weaponTypePanel.add(weaponType2);
        weaponTypePanel.add(weaponType3);
        weaponPanel.add(weaponNamePanel);
        weaponPanel.add(weaponAtkPanel);
        weaponPanel.add(weaponDmgPanel);
        weaponPanel.add(weaponTypePanel);
        weaponBorderPanel.add(weaponLabel,BorderLayout.PAGE_START);
        weaponBorderPanel.add(weaponPanel,BorderLayout.CENTER);
        
        //Armor Panel
        armorPanel.add(armorName);
        armorPanel.add(armorName1);
        armorPanel.add(armorAC);
        armorPanel.add(armorAC1);
        armorPanel.add(armorBonus);
        armorPanel.add(armorMagic1);
        armorPanel.add(armorShield);
        armorPanel.add(shield);
        armorBorderPanel.add(armorLabel, BorderLayout.PAGE_START);
        armorBorderPanel.add(armorPanel, BorderLayout.CENTER);
        
        //Skill Panel
        skillPanel.add(acro);skillPanel.add(de1);skillPanel.add(acroField);
        skillPanel.add(anim);skillPanel.add(wi1);skillPanel.add(animField);
        skillPanel.add(arca);skillPanel.add(in1);skillPanel.add(arcaField);
        skillPanel.add(athl);skillPanel.add(st1);skillPanel.add(athlField);
        skillPanel.add(dece);skillPanel.add(ch1);skillPanel.add(deceField);
        skillPanel.add(hist);skillPanel.add(in2);skillPanel.add(histField);
        skillPanel.add(insi);skillPanel.add(wi2);skillPanel.add(insiField);
        skillPanel.add(inti);skillPanel.add(ch2);skillPanel.add(intiField);
        skillPanel.add(inve);skillPanel.add(in3);skillPanel.add(inveField);
        skillPanel.add(medi);skillPanel.add(wi3);skillPanel.add(mediField);
        skillPanel.add(natu);skillPanel.add(in4);skillPanel.add(natuField);
        skillPanel.add(perc);skillPanel.add(wi4);skillPanel.add(percField);
        skillPanel.add(perf);skillPanel.add(ch3);skillPanel.add(perfField);
        skillPanel.add(pers);skillPanel.add(ch4);skillPanel.add(persField);
        skillPanel.add(reli);skillPanel.add(in5);skillPanel.add(reliField);
        skillPanel.add(slei);skillPanel.add(de2);skillPanel.add(sleiField);
        skillPanel.add(stea);skillPanel.add(de3);skillPanel.add(steaField);
        skillPanel.add(surv);skillPanel.add(wi5);skillPanel.add(survField);
        
                
                
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        Cfeat.setAlignmentX(Component.CENTER_ALIGNMENT);
        Rfeat.setAlignmentX(Component.CENTER_ALIGNMENT);
        profs.setAlignmentX(Component.CENTER_ALIGNMENT);
        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        lang.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        BoxLayout infoItemLayout = new BoxLayout(infoItemPanel, BoxLayout.X_AXIS);
        infoItemPanel.setLayout(infoItemLayout);
        
        BoxLayout itemARLayout = new BoxLayout(itemAddRemovePanel, BoxLayout.X_AXIS);
        itemAddRemovePanel.setLayout(itemARLayout);
        
        //Ability Score Labels Box Layout
        BorderLayout itemLayout = new BorderLayout();
        BoxLayout infoLayout = new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
        BoxLayout rfeatureLayout = new BoxLayout(rfeaturePanel, BoxLayout.Y_AXIS);
        BoxLayout cfeatureLayout = new BoxLayout(cfeaturePanel, BoxLayout.Y_AXIS);
        

        
        //Borders
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        goldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rfeaturePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cfeaturePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        choicePanel.setBorder(BorderFactory.createRaisedBevelBorder());
        abilityPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        deathPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        skillPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        skillPanelBorder.setBorder(BorderFactory.createLoweredBevelBorder());
        statPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        savePanel.setBorder(BorderFactory.createRaisedBevelBorder());
        hpPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        
        namePanel.setBorder(BorderFactory.createRaisedBevelBorder());
        
        weaponPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));
        armorPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        setInfoButton.addActionListener(setInfoListener);
        infoUpdatePanel.add(setInfoButton, BorderLayout.CENTER);
        
        addLangButton.addActionListener(langAddListener);
        removeLangButton.addActionListener(langRemoveListener);
        langPanel.add(langAddRemoveBox);
        langPanel.add(addLangButton);
        langPanel.add(removeLangButton);
        
        addProfButton.addActionListener(profAddListener);
        removeProfButton.addActionListener(profRemoveListener);
        profPanel.add(profAddRemoveBox);
        profPanel.add(addProfButton);
        profPanel.add(removeProfButton);
        
        itemPanel.setLayout(itemLayout);
        rfeaturePanel.setLayout(rfeatureLayout);
        cfeaturePanel.setLayout(cfeatureLayout);
        infoPanel.setLayout(infoLayout);
        infoPanel.add(info);
        infoPanel.add(info_area);
        infoBorderPanel.add(infoPanel, BorderLayout.CENTER);
        infoBorderPanel.add(infoUpdatePanel, BorderLayout.PAGE_END);
        
//        itemPanel.add(item, BorderLayout.PAGE_START);
        itemPanel.add(item_area, BorderLayout.CENTER);
        cfeaturePanel.add(Cfeat);
        cfeaturePanel.add(cfeature_area);
        cfeaturePanel.add(lang);
        cfeaturePanel.add(language_area);
        cfeatureBorderPanel.add(cfeaturePanel, BorderLayout.CENTER);
        cfeatureBorderPanel.add(langPanel, BorderLayout.PAGE_END);
        
        rfeaturePanel.add(Rfeat);
        rfeaturePanel.add(rfeature_area);
        rfeaturePanel.add(profs);
        rfeaturePanel.add(proficiency_area);
        rfeatureBorderPanel.add(rfeaturePanel, BorderLayout.CENTER);
        rfeatureBorderPanel.add(profPanel, BorderLayout.PAGE_END);
        
        goldPanel.add(c$);
        goldPanel.add(cpBox);
        goldPanel.add(s$);
        goldPanel.add(spBox);
        goldPanel.add(e$);
        goldPanel.add(epBox);
        goldPanel.add(g$);
        goldPanel.add(gpBox);
        goldPanel.add(p$);
        goldPanel.add(ppBox);
        
        itemHeaderPanel.add(item);
        itemHeaderPanel.add(goldPanel);
        itemPanel.add(itemHeaderPanel, BorderLayout.PAGE_START);
        
        addItemButton.addActionListener(addItem);
        removeItemButton.addActionListener(removeItem);
        itemAddRemovePanel.add(itemBox);
        itemAddRemovePanel.add(addItemButton);
        itemAddRemovePanel.add(removeItemButton);
        itemPanel.add(itemAddRemovePanel, BorderLayout.PAGE_END);
        
        infoItemPanel.add(cfeatureBorderPanel);
        infoItemPanel.add(infoBorderPanel);
        infoItemPanel.add(rfeatureBorderPanel);
        infoItemPanel.add(itemPanel);
        
        //Spell Button Listeners
        cantripAddSpellButton.addActionListener(addSpell);
        cantripRemoveSpellButton.addActionListener(removeSpell);
        level1AddSpellButton.addActionListener(addSpell);
        level1RemoveSpellButton.addActionListener(removeSpell);
        level2AddSpellButton.addActionListener(addSpell);
        level2RemoveSpellButton.addActionListener(removeSpell);
        level3AddSpellButton.addActionListener(addSpell);
        level3RemoveSpellButton.addActionListener(removeSpell);
        level4AddSpellButton.addActionListener(addSpell);
        level4RemoveSpellButton.addActionListener(removeSpell);
        level5AddSpellButton.addActionListener(addSpell);
        level5RemoveSpellButton.addActionListener(removeSpell);
        level6AddSpellButton.addActionListener(addSpell);
        level6RemoveSpellButton.addActionListener(removeSpell);
        level7AddSpellButton.addActionListener(addSpell);
        level7RemoveSpellButton.addActionListener(removeSpell);
        level8AddSpellButton.addActionListener(addSpell);
        level8RemoveSpellButton.addActionListener(removeSpell);
        level9AddSpellButton.addActionListener(addSpell);
        level9RemoveSpellButton.addActionListener(removeSpell);
        otherAddSpellButton.addActionListener(addSpell);
        otherRemoveSpellButton.addActionListener(removeSpell);
        
         //Spells
         spellcastingInfoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cantripSpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level1SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level2SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level3SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level4SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        otherSpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level5SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level6SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level7SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level8SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        level9SpellPanel.setBorder(BorderFactory.createLineBorder(Color.black));
         
        
        spellcastingInfoPanel.add(spellAbil);
        spellcastingInfoPanel.add(spellAbilBox);
        spellcastingInfoPanel.add(spellMod);
        spellcastingInfoPanel.add(spellModBox);
        spellcastingInfoPanel.add(spellSave);
        spellcastingInfoPanel.add(spellSaveBox);
        spellcastingInfoPanel.add(empty6);
        spellcastingInfoPanel.add(empty7);
        spellcastingInfoPanel.add(empty10);
        spellcastingInfoPanel.add(empty11);
        spellcastingInfoPanel.add(empty12);
        spellcastingInfoPanel.add(empty13);
        spellcastingInfoPanel.add(empty14);
        spellcastingInfoPanel.add(warlockLabel);
        spellcastingInfoPanel.add(warlockLeftBox);
        spellcastingInfoPanel.add(warlockTotalBox);
        spellcastingInfoPanel.add(empty8);
        spellcastingInfoPanel.add(kiLabel);
        spellcastingInfoPanel.add(kiLeftBox);
        spellcastingInfoPanel.add(kiTotalBox);
        spellcastingInfoPanel.add(empty9);
        spellcastingInfoPanel.add(sorceryLabel);
        spellcastingInfoPanel.add(sorceryLeftBox);
        spellcastingInfoPanel.add(sorceryTotalBox);
        
        cantripInfoPanel.add(cantripSpells);
        cantripSpellPanel.add(cantripInfoPanel, BorderLayout.PAGE_START);
        cantripSpellPanel.add(cantripTextArea, BorderLayout.CENTER);
        cantripAddPanel.add(cantripBox);
        cantripAddPanel.add(cantripAddSpellButton);
        cantripAddPanel.add(cantripRemoveSpellButton);
        cantripSpellPanel.add(cantripAddPanel, BorderLayout.PAGE_END);
        
        level1InfoPanel.add(lvl1Spells);
        level1InfoPanel.add(level1CastBox);
        level1InfoPanel.add(level1TotalBox);
        level1SpellPanel.add(level1InfoPanel, BorderLayout.PAGE_START);
        level1SpellPanel.add(level1TextArea, BorderLayout.CENTER);
        level1AddPanel.add(level1Box);
        level1AddPanel.add(level1AddSpellButton);
        level1AddPanel.add(level1RemoveSpellButton);
        level1SpellPanel.add(level1AddPanel, BorderLayout.PAGE_END);
        
        level2InfoPanel.add(lvl2Spells);
        level2InfoPanel.add(level2CastBox);
        level2InfoPanel.add(level2TotalBox);
        level2SpellPanel.add(level2InfoPanel, BorderLayout.PAGE_START);
        level2SpellPanel.add(level2TextArea, BorderLayout.CENTER);
        level2AddPanel.add(level2Box);
        level2AddPanel.add(level2AddSpellButton);
        level2AddPanel.add(level2RemoveSpellButton);
        level2SpellPanel.add(level2AddPanel, BorderLayout.PAGE_END);
        
        level3InfoPanel.add(lvl3Spells);
        level3InfoPanel.add(level3CastBox);
        level3InfoPanel.add(level3TotalBox);
        level3SpellPanel.add(level3InfoPanel, BorderLayout.PAGE_START);
        level3SpellPanel.add(level3TextArea, BorderLayout.CENTER);
        level3AddPanel.add(level3Box);
        level3AddPanel.add(level3AddSpellButton);
        level3AddPanel.add(level3RemoveSpellButton);
        level3SpellPanel.add(level3AddPanel, BorderLayout.PAGE_END);
        
        level4InfoPanel.add(lvl4Spells);
        level4InfoPanel.add(level4CastBox);
        level4InfoPanel.add(level4TotalBox);
        level4SpellPanel.add(level4InfoPanel, BorderLayout.PAGE_START);
        level4SpellPanel.add(level4TextArea, BorderLayout.CENTER);
        level4AddPanel.add(level4Box);
        level4AddPanel.add(level4AddSpellButton);
        level4AddPanel.add(level4RemoveSpellButton);
        level4SpellPanel.add(level4AddPanel, BorderLayout.PAGE_END);
        
        otherSpellPanel.add(otherSpells, BorderLayout.PAGE_START);
        otherSpellPanel.add(otherSpellTextArea, BorderLayout.CENTER);
        otherAddPanel.add(otherBox);
        otherAddPanel.add(otherAddSpellButton);
        otherAddPanel.add(otherRemoveSpellButton);
        otherSpellPanel.add(otherAddPanel, BorderLayout.PAGE_END);
        
        level5InfoPanel.add(lvl5Spells);
        level5InfoPanel.add(level5CastBox);
        level5InfoPanel.add(level5TotalBox);
        level5SpellPanel.add(level5InfoPanel, BorderLayout.PAGE_START);
        level5SpellPanel.add(level5TextArea, BorderLayout.CENTER);
        level5AddPanel.add(level5Box);
        level5AddPanel.add(level5AddSpellButton);
        level5AddPanel.add(level5RemoveSpellButton);
        level5SpellPanel.add(level5AddPanel, BorderLayout.PAGE_END);
        
        level6InfoPanel.add(lvl6Spells);
        level6InfoPanel.add(level6CastBox);
        level6InfoPanel.add(level6TotalBox);
        level6SpellPanel.add(level6InfoPanel, BorderLayout.PAGE_START);
        level6SpellPanel.add(level6TextArea, BorderLayout.CENTER);
        level6AddPanel.add(level6Box);
        level6AddPanel.add(level6AddSpellButton);
        level6AddPanel.add(level6RemoveSpellButton);
        level6SpellPanel.add(level6AddPanel, BorderLayout.PAGE_END);
        
        level7InfoPanel.add(lvl7Spells);
        level7InfoPanel.add(level7CastBox);
        level7InfoPanel.add(level7TotalBox);
        level7SpellPanel.add(level7InfoPanel, BorderLayout.PAGE_START);
        level7SpellPanel.add(level7TextArea, BorderLayout.CENTER);
        level7AddPanel.add(level7Box);
        level7AddPanel.add(level7AddSpellButton);
        level7AddPanel.add(level7RemoveSpellButton);
        level7SpellPanel.add(level7AddPanel, BorderLayout.PAGE_END);
        
        level8InfoPanel.add(lvl8Spells);
        level8InfoPanel.add(level8CastBox);
        level8InfoPanel.add(level8TotalBox);
        level8SpellPanel.add(level8InfoPanel, BorderLayout.PAGE_START);
        level8SpellPanel.add(level8TextArea, BorderLayout.CENTER);
        level8AddPanel.add(level8Box);
        level8AddPanel.add(level8AddSpellButton);
        level8AddPanel.add(level8RemoveSpellButton);
        level8SpellPanel.add(level8AddPanel, BorderLayout.PAGE_END);
        
        level9InfoPanel.add(lvl9Spells);
        level9InfoPanel.add(level9CastBox);
        level9InfoPanel.add(level9TotalBox);
        level9SpellPanel.add(level9InfoPanel, BorderLayout.PAGE_START);
        level9SpellPanel.add(level9TextArea, BorderLayout.CENTER);
        level9AddPanel.add(level9Box);
        level9AddPanel.add(level9AddSpellButton);
        level9AddPanel.add(level9RemoveSpellButton);
        level9SpellPanel.add(level9AddPanel, BorderLayout.PAGE_END);
        
        spellInteriorPanel.add(spellcastingInfoPanel);
        spellInteriorPanel.add(cantripSpellPanel);
        spellInteriorPanel.add(level1SpellPanel);
        spellInteriorPanel.add(level2SpellPanel);
        spellInteriorPanel.add(level3SpellPanel);
        spellInteriorPanel.add(level4SpellPanel);
        spellInteriorPanel.add(otherSpellPanel);
        spellInteriorPanel.add(level5SpellPanel);
        spellInteriorPanel.add(level6SpellPanel);
        spellInteriorPanel.add(level7SpellPanel);
        spellInteriorPanel.add(level8SpellPanel);
        spellInteriorPanel.add(level9SpellPanel);       
       
        spellcasterPanel.add(spellInteriorPanel);
        
        //NO ADDITIONAL CODE PAST THIS LINE
        tabbedPane.addTab("Stats & Skills", statSkillPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Items & Info", infoItemPanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.addTab("Spells", spellcasterPanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        abilityPanel.add(abilityLabelPanel);
        abilityPanel.add(abilityScorePanel);
        abilityPanel.add(abilityModifierPanel);
        
        statPanel.add(coreStatPanel);
        statPanel.add(abilityPanel);
        statPanel.add(savePanel);
        statPanel.add(deathPanel);
        
        Dimension d = new Dimension();
        d.setSize(600,100);
        weaponArmorPanel.setMaximumSize(d);
        filler1Panel.add(empty15);
        
        centerPanel.add(appearancePanel);
        weaponArmorPanel.add(weaponBorderPanel);
        weaponArmorPanel.add(armorBorderPanel);
        centerPanel.add(weaponArmorPanel);
        centerPanel.add(filler1Panel);
        centerPanel.add(filler2Panel);
        
        headerPanel.add(choicePanel);
        headerPanel.add(namePanel);
        
        skillPanelBorder.add(skillPanel, BorderLayout.CENTER);
        
        statSkillPanel.add(statPanel, BorderLayout.LINE_START);
        statSkillPanel.add(headerPanel, BorderLayout.PAGE_START);
        statSkillPanel.add(skillPanelBorder, BorderLayout.LINE_END);
        statSkillPanel.add(centerPanel, BorderLayout.CENTER);
        
        img = null;
        try{
        	InputStream input = this.getClass().getResourceAsStream("PurpleSlime.png");
        	img = ImageIO.read(input);
        
        }catch (IOException e){}
        
        super.setIconImage(img);
        
        
        add(masterPanel);
        setJMenuBar(menu);
        add(tabbedPane);
        
        setVisible(true);
    }
    
    //Class for Determining whether Comboboxes have been changed, and calls the class for that choice
    private class ItemHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            
            //Class Listeners- Changes to classList comboBox
            if(event.getSource() == classList){
                
                if(event.getStateChange() == ItemEvent.SELECTED){
                    
                    if(classList.getSelectedItem().equals("Select")){
                        
                        classSelected = false;
                    }
                    if(classList.getSelectedItem().equals("Barbarian")){
                    	charclass = "Barbarian";
                        strSaveProf.setSelected(true);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(true);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(false);
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Bard")){
                    	charclass = "Bard";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(true);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(true);
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Cleric")){
                    	charclass = "Cleric";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(true);
                        chaSaveProf.setSelected(true);
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Druid")){
                    	charclass = "Druid";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(true);
                        wisSaveProf.setSelected(true);
                        chaSaveProf.setSelected(false);
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Fighter")){
                    	charclass = "Fighter";
                        strSaveProf.setSelected(true);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(true);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(false);
                        
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Monk")){
                    	charclass = "Monk";
                        strSaveProf.setSelected(true);
                        dexSaveProf.setSelected(true);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(false);
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Paladin")){
                    	charclass = "Paladin";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(true);
                        chaSaveProf.setSelected(true);
                        
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Ranger")){
                    	charclass = "Ranger";
                        strSaveProf.setSelected(true);
                        dexSaveProf.setSelected(true);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(false);
                        
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Rogue")){
                    	charclass = "Rogue";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(true);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(true);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(false);
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Sorcerer")){
                    	charclass = "Sorcerer";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(true);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(false);
                        chaSaveProf.setSelected(true);
                        
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Warlock")){
                    	charclass = "Warlock";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(false);
                        wisSaveProf.setSelected(true);
                        chaSaveProf.setSelected(true);
                        
                        classSelected = true;
                    }
                    if(classList.getSelectedItem().equals("Wizard")){
                    	charclass = "Wizard";
                        strSaveProf.setSelected(false);
                        dexSaveProf.setSelected(false);
                        conSaveProf.setSelected(false);
                        intSaveProf.setSelected(true);
                        wisSaveProf.setSelected(true);
                        chaSaveProf.setSelected(false);
                        
                        classSelected = true;
                    }
                } 
            }
             //Race Listeners- Changes to raceList comboBox
            if(event.getSource() == raceList){
            	if(event.getStateChange() == ItemEvent.SELECTED){
                   if(raceList.getSelectedItem().equals("Select")){
                        raceSelected = false;
                    } 
                    if(raceList.getSelectedItem().equals("Dragonborn")){
                        //Prompt User to choose color to determine breath weapon
                    	race = "Dragonborn";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Dwarf(Hill)")){
                    	race = "Hill Dwarf";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Dwarf(Mountain)")){
                    	race = "Mountain Dwarf";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Elf(High)")){
                    	race = "High Elf";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Elf(Wood)")){
                    	race = "Wood Elf";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Elf(Dark/Drow)")){
                    	race = "Drow Elf";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Gnome(Forest)")){
                    	race = "Forest Gnome";
                        sizeBox.setText("S");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Gnome(Rock)")){
                    	race = "Rock Gnome";
                        sizeBox.setText("S");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Half-Elf")){
                    	race = "Half Elf";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Halfling(Lightfoot)")){
                    	race = "Lightfoot Halfling";
                        sizeBox.setText("S");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Halfling(Stout)")){
                    	race =  "Stout Halfling";
                        sizeBox.setText("S");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Half-Orc")){
                    	race = "Half Orc";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Human")){
                    	race =  "Human";
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                    if(raceList.getSelectedItem().equals("Tiefling")){
                    	race = "Tiefling" ;
                        sizeBox.setText("M");
                        raceSelected = true;
                    }
                }
            }
             //Background Listeners- Changes to backgrList comboBox
            if(event.getSource() == backgrList){
                if(event.getStateChange() == ItemEvent.SELECTED){
                    if(backgrList.getSelectedItem().equals("Select")){
                        
                        backgroundSelected = false;
                    }
                    if(backgrList.getSelectedItem().equals("Acolyte")){
                    	background = "Acolyte";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Charlatan")){
                    	background = "Charlatan";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Criminal")){
                    	background = "Criminal";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Entertainer")){
                    	background = "Entertainer";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Folk Hero")){
                    	background = "Folk Hero";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Guild Artisan")){
                    	background = "Guild Artisan";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Hermit")){
                    	background = "Hermit";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Noble")){
                    	background = "Noble";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Outlander")){
                    	background = "Outlander";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Sage")){
                    	background = "Sage";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Sailor")){
                    	background = "Sailor";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals( "Soldier")){
                    	background = "Soldier";
                        backgroundSelected = true;
                    }
                    if(backgrList.getSelectedItem().equals("Urchin")){
                    	background = "Urchin";
                        backgroundSelected = true;
                    }
                }
            }
            //Allignment Listener- Changes to allignList comboBox
            if(event.getSource() == allignList){
                if(event.getStateChange() == ItemEvent.SELECTED){
                    
                	String aligned = (String) allignList.getSelectedItem();
                	align = aligned; 
                	if(!(player == null)) {
	                	switch(aligned) {
			            	case "Lawful Good":{
			            		player.setAlignment("Lawful Good");
			            		break;
			            	}
			            	case "Neutral Good":{
			            		player.setAlignment("Neutral Good");
			            		break;
			            	}
			            	case "Chaotic Good":{
			            		player.setAlignment("Chaotic Good");
			            		break;
			            	}
			            	case "Lawful Neutral":{
			            		player.setAlignment("Lawful Neutral");
			            		break;
			            	}
			            	case "Neutral":{
			            		player.setAlignment("Neutral");
			            		break;
			            	}
			            	case "Chaotic Neutral":{
			            		player.setAlignment("Chaotic Neutral");
			            		break;
			            	}
			            	case "Lawful Evil":{
			            		player.setAlignment("Lawful Evil");
			            		break;
			            	}
			            	case "Neutral Evil":{
			            		player.setAlignment("Neutral Evil");
			            		break;
			            	}
			            	case "Chaotic Evil":{
			            		player.setAlignment("Chaotic Evil");
			            		break;
			            	}
	                	}
                	}	
               }
            }
            
            //Level Listener- Changes to levelList comboBox
            if(event.getSource() == levelList){
            	if(event.getStateChange() == ItemEvent.SELECTED){
            		int newlvl = here.loadnumber((String) levelList.getSelectedItem()) ;
                   //(Requirement 7.1.1) Program checks if active character exists
            		if(!(player == null)) {
                	   if(newlvl > 1) {
                	    String filepath = here.getfilepath();
	           	    	if(filepath == "" || filepath == null) {
	           	    		
	           	    		JFileChooser filebox = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	           	    		
	           	    		filebox.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	           	    		
	           	    		int r = filebox.showSaveDialog(null);
	           	    		
	           	    		if (r == JFileChooser.APPROVE_OPTION) {
	           	    			filepath = filebox.getSelectedFile().getAbsolutePath();
	           	    			here.setfilepath(filepath);
	           	    			
	           	    		}else {
	           	    			JOptionPane.showMessageDialog(null, "Please select a folder to save characters to.");
	           	    			return;
	           	    		}
	           	    	}	
                	   }
                	   //(Requirement 7.1.1.2) If character exists
                	   if(Loadflag == false) {
		                	String Charclass = player.getCharClass();
		                   
/*							Below is the switch that changes the characters level based on the input from the drop down
							The switch itself will set the charcters experience
							and check for any choices that need made based on the characters class based 
							So it is essentially 
								the new level choice
									set experience (Requirement 7.1.1.2.1)
									if statement to check if the characters class matches the possible class
										Possible choice boxes for	
											Class Specific choices (Requirement 7.1.1.2.2.1.4) Class specific feature choices
											Subclass (Requirement 7.1.1.2.2.1.2) Choosing a subclass
											Subclass choices determined by if the class and the subclass are the same (Requirement 7.1.1.2.2.1.2) Subclass specific ability choices
									Some ability points are given to all classes at this level and are not in a if statement (Requirement 7.1.1.2.2.1.1) Ability Point Increases
									break;
*/		                   
		                    switch(newlvl) {
			                    case 1: {
			        				player.setexp(0);
			        				return;
			        				}
			                    case 2: {
			        				player.setexp(300);
			        				if (Charclass.equals("Druid")){
			        					//Choose a Subclass info
			        	            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
			        	            	 JPanel DruidsubclassPanel1 = new JPanel();
			        	            	 String[] domain = new String[subclasslist.size()];
			        	                 for(int i = 0; i< subclasslist.size(); i++) {
			        	                	 domain[i] = subclasslist.get(i);
			        	                 }
			        	                 JComboBox newsubclass = new JComboBox(domain);
			        	                 DruidsubclassPanel1.add(newsubclass);
			        	                 JOptionPane.showConfirmDialog(null, DruidsubclassPanel1, "Choose a Driud Circle for your Druid:", JOptionPane.OK_OPTION);
			        	                 
			        	                 player.setSubClass((String) newsubclass.getSelectedItem());
			        	                 
			        	                 if (player.getSubClass().contentEquals("Circle of Land")) {
				        	                   JPanel DruidcantripPanel2 = new JPanel();
				        	              	   ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);;
				        	  		   	       String[] options = new String[Cantripoptions.size()];
				        	  	               for(int i = 0; i< Cantripoptions.size(); i++) {
				        	  	            	   options[i] = Cantripoptions.get(i);
				        	  	               }
				        	  	               JComboBox cantripList = new JComboBox(options);
				        	  	             DruidcantripPanel2.add(cantripList);
				        	  	               JOptionPane.showConfirmDialog(null, DruidcantripPanel2, "Choose a Cantrip:", JOptionPane.OK_OPTION);
				        	  	               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
			        	                 }      
			        				}
			        				
			        				if (Charclass.equals("Paladin")){
			        					ArrayList<String> Fightingstyles = occupation.getfightingStyle();
			        		            String[] allstyles = new String[Fightingstyles.size()];
			        		        	for (int i = 0; i < Fightingstyles.size(); i++) { 
			        		                allstyles[i] = Fightingstyles.get(i);
			        		            }
			        		             JPanel FighterStylePanel = new JPanel();
			        		             JComboBox styleList = new JComboBox(allstyles);
			        		             FighterStylePanel.add(styleList);
			        		             JOptionPane.showConfirmDialog(null, FighterStylePanel, "Choose a Fighting Style for your Paladin", JOptionPane.OK_OPTION);
			        		             occupation.GUIaddspecialty((String) styleList.getSelectedItem(), player);
			        				}
			        				
			        				if (Charclass.equals("Ranger")){
			        					ArrayList<String> Fightingstyles = occupation.getfightingStyle();
			        		            String[] allstyles = new String[Fightingstyles.size()];
			        		        	for (int i = 0; i < Fightingstyles.size(); i++) { 
			        		                allstyles[i] = Fightingstyles.get(i);
			        		            }
			        		             JPanel FighterStylePanel = new JPanel();
			        		             JComboBox styleList = new JComboBox(allstyles);
			        		             FighterStylePanel.add(styleList);
			        		             JOptionPane.showConfirmDialog(null, FighterStylePanel, "Choose a Fighting Style for your Ranger", JOptionPane.OK_OPTION);
			        		             occupation.GUIaddspecialty((String) styleList.getSelectedItem(), player);
			        				}
			        				
			        				if (Charclass.equals("Wizard")){
			        					//Choose a Subclass info
			        	            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
			        	            	 JPanel WizardsubclassPanel1 = new JPanel();
			        	            	 String[] domain = new String[subclasslist.size()];
			        	                 for(int i = 0; i< subclasslist.size(); i++) {
			        	                	 domain[i] = subclasslist.get(i);
			        	                 }
			        	                 JComboBox newsubclass = new JComboBox(domain);
			        	                 WizardsubclassPanel1.add(newsubclass);
			        	                 JOptionPane.showConfirmDialog(null, WizardsubclassPanel1, "Choose a Arcane Traditions for your Wizard:", JOptionPane.OK_OPTION);
			        	                 player.setSubClass((String) newsubclass.getSelectedItem());
		//	        	                 occupation.GUIsubclassinfo(player);
		 	        	            }
		//	        				player.setlevel(2);
			        			}
			        			break;
			                    case 3: {
			        				player.setexp(900);
			        				if (Charclass.equals("Barbarian")){
			        					//Choose a Subclass info
			        	            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
			        	            	 JPanel BarbariansubclassPanel1 = new JPanel();
			        	            	 String[] domain = new String[subclasslist.size()];
			        	                 for(int i = 0; i< subclasslist.size(); i++) {
			        	                	 domain[i] = subclasslist.get(i);
			        	                 }
			        	                 JComboBox newsubclass = new JComboBox(domain);
			        	                 BarbariansubclassPanel1.add(newsubclass);
			        	                 JOptionPane.showConfirmDialog(null, BarbariansubclassPanel1, "Choose a Primal Path for your Barbarian:", JOptionPane.OK_OPTION);
			        	                 player.setSubClass((String) newsubclass.getSelectedItem());
			        	                
			        	                //Subclass choices
			        	                 if (player.getSubClass().contentEquals("Path of the Totem Warrior")) {
			        	                	 ArrayList<String> Subclasschoice = occupation.getsubclasschoices();
				        	            	 JPanel BarbariansubclasschoicePanel1 = new JPanel();
				        	            	 String[] options = new String[Subclasschoice.size()];
				        	                 for(int i = 0; i< Subclasschoice.size(); i++) {
				        	                	 options[i] = Subclasschoice.get(i);
				        	                 }
				        	                 JComboBox newsubclasschoice = new JComboBox(options);
				        	                 BarbariansubclasschoicePanel1.add(newsubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, BarbariansubclasschoicePanel1, "Choose a Totem Spirit for your Barbarian:", JOptionPane.OK_OPTION);
				        	                 occupation.setChoicesub((String) newsubclasschoice.getSelectedItem());
			        	                 }
			        					}  
			        	                 
			        	                if (Charclass.equals("Bard")){
			 	        					//Choose a Subclass info
			 	        	            	 ArrayList<String> bardsubclasslist = occupation.getdomainoptions();
			 	        	            	 JPanel BardsubclassPanel1 = new JPanel();
			 	        	            	 String[] domain1 = new String[bardsubclasslist.size()];
			 	        	                 for(int i = 0; i< bardsubclasslist.size(); i++) {
			 	        	                	domain1[i] = bardsubclasslist.get(i);
			 	        	                 }
			 	        	                 JComboBox newsubclassbard = new JComboBox(domain1);
			 	        	                 BardsubclassPanel1.add(newsubclassbard);
			 	        	                 JOptionPane.showConfirmDialog(null, BardsubclassPanel1, "Choose a Bard College for your Bard:", JOptionPane.OK_OPTION);
			 	        	                 player.setSubClass((String) newsubclassbard.getSelectedItem());
						 	        	                			 	        	                
			 	        	                //Subclass choices 
			 	        	                //ArrayList<String> currentfeat = (ArrayList<String>) (player.getFeats()).clone();
			 	        	                if (player.getSubClass().contentEquals("College of Lore")){  
			 	        	                	for(int i = 0; i < 3; i++) {
			 	        	                		 ArrayList<String> possibleskilllist1 = occupation.possibleskillsCharacter(player);
			 	        	                		 String[] allskills2 = new String[possibleskilllist1.size()];
			 	        	                		 for(int l = 0; l< possibleskilllist1.size(); l++) {
			 	        	                			 allskills2[l] = possibleskilllist1.get(l);
			 	        	                		 }
			 	        	                		 JPanel BardSkillPanel1 = new JPanel();
			 	        	                		 JComboBox skillList = new JComboBox(allskills2);//Half Elf
			 	        	                		 BardSkillPanel1.add(skillList);
			 	        	                		 JOptionPane.showConfirmDialog(null, BardSkillPanel1, "Choose a Skill to Increase by 1 for College of Lore", JOptionPane.OK_OPTION);
			 	        	                		 player.addskill((String) skillList.getSelectedItem()); 
				 	        	                 }
			 	        	                }
			 	        	                
			 	        	               //get Expert skill 
			 	        	                 for(int y = 0; y < 2; y++) {
			 	        	                 ArrayList<String> bardexpert = occupation.possibleExpertskillsCharacter(player);
			 	        	            	 JPanel BardExpertPanel1 = new JPanel();
			 	        	            	 String[] Expert = new String[bardexpert.size()];
			 	        	                 for(int i = 0; i< bardexpert.size(); i++) {
			 	        	                	Expert[i] = bardexpert.get(i);
			 	        	                 }
			 	        	                 JComboBox newexpertbard = new JComboBox(Expert);
			 	        	                 BardExpertPanel1.add(newexpertbard);
			 	        	                 JOptionPane.showConfirmDialog(null, BardExpertPanel1, "Choose a Skill to Make Expert:", JOptionPane.OK_OPTION);
			 	        	                 player.setExpert((String) newexpertbard.getSelectedItem());
			 	        	                 }
			        	               }      
		 	        	              if (Charclass.equals("Druid")){
		 	        	            	//Subclass choices
		 	        	                 if (player.getSubClass().contentEquals("Circle of Land")) {
		 	        	                	 ArrayList<String> DruidSubclasschoice = occupation.getsubclasschoices();
		 		        	            	 JPanel DruidsubclasschoicePanel1 = new JPanel();
		 		        	            	 String[] options3 = new String[DruidSubclasschoice.size()];
		 		        	                 for(int i = 0; i< DruidSubclasschoice.size(); i++) {
		 		        	                	 options3[i] = DruidSubclasschoice.get(i);
		 		        	                 }
		 		        	                 JComboBox Druidsubclasschoice = new JComboBox(options3);
		 		        	                DruidsubclasschoicePanel1.add(Druidsubclasschoice);
		 		        	                 JOptionPane.showConfirmDialog(null, DruidsubclasschoicePanel1, "Choose a Land for the Level 3 Circle Spells:", JOptionPane.OK_OPTION);
		 		        	                 player.setbattlemasterSave((String) Druidsubclasschoice.getSelectedItem());
		 	        	                 }
		 	        	            	   
		 	        	              }
		 	        	             if (Charclass.equals("Fighter")){
		 	        					//Choose a Subclass info
		 	        	            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
		 	        	            	 JPanel FightersubclassPanel1 = new JPanel();
		 	        	            	 String[] domain2 = new String[subclasslist.size()];
		 	        	                 for(int i = 0; i< subclasslist.size(); i++) {
		 	        	                	 domain2[i] = subclasslist.get(i);
		 	        	                 }
		 	        	                 JComboBox newsubclass = new JComboBox(domain2);
		 	        	                FightersubclassPanel1.add(newsubclass);
		 	        	                JOptionPane.showConfirmDialog(null, FightersubclassPanel1, "Choose a Martial Archetype for your Fighter:", JOptionPane.OK_OPTION);
		 	        	                player.setSubClass((String) newsubclass.getSelectedItem());
		// 	        	                occupation.GUIsubclassinfo(player);
		 	        	             
		 	        	               if (player.getSubClass().contentEquals("Battle Master")) {
			        	                	 JPanel BMsubclasschoicePanel1 = new JPanel();
				        	            	 String[] options4 = new String[2];
				        	                 options4[0] = "Strength";
				        	                 options4[1] = "Dexterity";
				        	                 JComboBox BMsubclasschoice = new JComboBox(options4);
				        	                 BMsubclasschoicePanel1.add(BMsubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, BMsubclasschoicePanel1, "Choose a Ability to use for your Save DC:", JOptionPane.OK_OPTION);
				        	                 player.setbattlemasterSave((String) BMsubclasschoice.getSelectedItem());
			        	                
				        	                 for (int y = 0; y < 3; y++ ) {
				        	                	 ArrayList<String> maneuversSubclasschoice = occupation.getpossibleManeuvers(player);
			 		        	            	 JPanel MansubclasschoicePanel1 = new JPanel();
			 		        	            	 String[] optionsman = new String[maneuversSubclasschoice.size()];
			 		        	                 for(int i = 0; i< maneuversSubclasschoice.size(); i++) {
			 		        	                	optionsman[i] = maneuversSubclasschoice.get(i);
			 		        	                 }
			 		        	                 JComboBox Mansubclasschoice = new JComboBox(optionsman);
			 		        	                 MansubclasschoicePanel1.add(Mansubclasschoice);
			 		        	                 JOptionPane.showConfirmDialog(null, MansubclasschoicePanel1, "Choose a Maneuver for your BattleMaster", JOptionPane.OK_OPTION);
			 		        	                 occupation.setChoicesub((String) Mansubclasschoice.getSelectedItem());
			 		        	                 occupation.getGUImaneuvers(player);
				        	                 }
		 	        	               	}
		 	        	             }
		 	        	             
		 	        	            if (Charclass.equals("Monk")){
			        					//Choose a Subclass info
			        	            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
			        	            	 JPanel MonksubclassPanel1 = new JPanel();
			        	            	 String[] domain = new String[subclasslist.size()];
			        	                 for(int i = 0; i< subclasslist.size(); i++) {
			        	                	 domain[i] = subclasslist.get(i);
			        	                 }
			        	                 JComboBox newsubclass = new JComboBox(domain);
			        	                 MonksubclassPanel1.add(newsubclass);
			        	                 JOptionPane.showConfirmDialog(null, MonksubclassPanel1, "Choose a Monastic Tradition for your Monk:", JOptionPane.OK_OPTION);
			        	                 player.setSubClass((String) newsubclass.getSelectedItem());
			        	                
			        	                //Subclass choices
			        	                 if (player.getSubClass().contentEquals("Path of the Totem Warrior")) {
			        	                	 ArrayList<String> Subclasschoice = occupation.getsubclasschoices();
				        	            	 JPanel BarbariansubclasschoicePanel1 = new JPanel();
				        	            	 String[] options = new String[Subclasschoice.size()];
				        	                 for(int i = 0; i< Subclasschoice.size(); i++) {
				        	                	 options[i] = Subclasschoice.get(i);
				        	                 }
				        	                 JComboBox newsubclasschoice = new JComboBox(options);
				        	                 BarbariansubclasschoicePanel1.add(newsubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, BarbariansubclasschoicePanel1, "Choose a Totem Spirit for your Barbarian:", JOptionPane.OK_OPTION);
				        	                 occupation.setChoicesub((String) newsubclasschoice.getSelectedItem());
			        	                 }
			        					} 
		 	        	             
		 	        	              if (Charclass.equals("Paladin")){
			 	        					//Choose a Subclass info
			 	        	            	 ArrayList<String> Palsubclasslist = occupation.getdomainoptions();
			 	        	            	 JPanel PalsubclassPanel1 = new JPanel();
			 	        	            	 String[] Paldomain1 = new String[Palsubclasslist.size()];
			 	        	                 for(int i = 0; i< Palsubclasslist.size(); i++) {
			 	        	                	Paldomain1[i] = Palsubclasslist.get(i);
			 	        	                 }
			 	        	                 JComboBox subclassPal = new JComboBox(Paldomain1);
			 	        	                PalsubclassPanel1.add(subclassPal);
			 	        	                 JOptionPane.showConfirmDialog(null, PalsubclassPanel1, "Choose a Sacred Oath for your Paladin:", JOptionPane.OK_OPTION);
			 	        	                 player.setSubClass((String) subclassPal.getSelectedItem());
				 
			        	               }
		 	        	              
		 	        	             if (Charclass.equals("Ranger")){
			 	        					//Choose a Subclass info
			 	        	            	 ArrayList<String> Rangsubclasslist = occupation.getdomainoptions();
			 	        	            	 JPanel RansubclassPanel1 = new JPanel();
			 	        	            	 String[] Rangdomain1 = new String[Rangsubclasslist.size()];
			 	        	                 for(int i = 0; i< Rangsubclasslist.size(); i++) {
			 	        	                	Rangdomain1[i] = Rangsubclasslist.get(i);
			 	        	                 }
			 	        	                 JComboBox subclassPal = new JComboBox(Rangdomain1);
			 	        	                 RansubclassPanel1.add(subclassPal);
			 	        	                 JOptionPane.showConfirmDialog(null, RansubclassPanel1, "Choose a Ranger Archetype for your Ranger:", JOptionPane.OK_OPTION);
			 	        	                 player.setSubClass((String) subclassPal.getSelectedItem());
		
			 	        	              //Subclass choices
				        	                 if (player.getSubClass().contentEquals("Hunter")) {
				        	                	 JPanel huntersubclasschoicePanel1 = new JPanel();
					        	            	 String[] options4 = new String[3];
					        	                 options4[0] = "Colossus Slayer";
					        	                 options4[1] = "Giant Killer";
					        	                 options4[2] = "Horde Breaker";
					        	                 JComboBox huntersubclasschoice = new JComboBox(options4);
					        	                 huntersubclasschoicePanel1.add(huntersubclasschoice);
					        	                 JOptionPane.showConfirmDialog(null, huntersubclasschoicePanel1, "Choose a Hunter's Prey for your Ranger:", JOptionPane.OK_OPTION);
					        	                 occupation.setChoicesub((String) huntersubclasschoice.getSelectedItem());
				        	                 }
		 	        	             }
		 	        	            if (Charclass.equals("Rogue")){
			        					//Choose a Subclass info
			        	            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
			        	            	 JPanel BarbariansubclassPanel1 = new JPanel();
			        	            	 String[] domain = new String[subclasslist.size()];
			        	                 for(int i = 0; i< subclasslist.size(); i++) {
			        	                	 domain[i] = subclasslist.get(i);
			        	                 }
			        	                 JComboBox newsubclass = new JComboBox(domain);
			        	                 BarbariansubclassPanel1.add(newsubclass);
			        	                 JOptionPane.showConfirmDialog(null, BarbariansubclassPanel1, "Choose a Rogue Archetype for your Rogue:", JOptionPane.OK_OPTION);
			        	                 player.setSubClass((String) newsubclass.getSelectedItem());
		 	        	            }
		 	        	             
		 	        	           if (Charclass.equals("Sorcerer")){
			        	            	//MetaMagic choices
		        	                  for (int y = 0; y < 2; y++) { 	 
		 	        	        	   	 ArrayList<String> MetamagicSubclasschoice = occupation.possiblemetamagic(player);
			        	            	 JPanel metamagicsubclasschoicePanel1 = new JPanel();
			        	            	 String[] options3 = new String[MetamagicSubclasschoice.size()];
			        	                 for(int i = 0; i< MetamagicSubclasschoice.size(); i++) {
			        	                	 options3[i] = MetamagicSubclasschoice.get(i);
			        	                 }
			        	                 JComboBox metamagicsubclasschoice = new JComboBox(options3);
			        	                 metamagicsubclasschoicePanel1.add(metamagicsubclasschoice);
			        	                 JOptionPane.showConfirmDialog(null, metamagicsubclasschoicePanel1, "Choose a Metamagic Spell:", JOptionPane.OK_OPTION);
			        	                 occupation.AddmMetaMagic((String) metamagicsubclasschoice.getSelectedItem(), player);
		        	                  }
		 	        	           }  
		 	        	          
		 	        	          if (Charclass.equals("Warlock")){
		        	            	//Subclass choices
		    	                     ArrayList<String> PactBoonSubclasschoice = occupation.getsubclasschoices();
		        	            	 JPanel PactdsubclasschoicePanel1 = new JPanel();
		        	            	 String[] options3 = new String[PactBoonSubclasschoice.size()];
		        	                 for(int i = 0; i< PactBoonSubclasschoice.size(); i++) {
		        	                	 options3[i] = PactBoonSubclasschoice.get(i);
		        	                 }
		        	                 JComboBox Pactsubclasschoice = new JComboBox(options3);
		        	                 PactdsubclasschoicePanel1.add(Pactsubclasschoice);
		        	                 JOptionPane.showConfirmDialog(null, PactdsubclasschoicePanel1, "Choose a Pact Boon for your Warlock:", JOptionPane.OK_OPTION);
		        	                 occupation.setChoicesub((String) Pactsubclasschoice.getSelectedItem());
		 	        	          }
			        			}
			        			break;
			                    case 4: {
			        				player.setexp(2700);
			        				 //Choose 2 Abilities to Increase
			        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
			        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
		        	            	 JPanel Abilitypoints4panel = new JPanel();
		        	            	 String[] options = new String[possibleabilitypoints.size()];
		        	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
		        	                	 options[i] = possibleabilitypoints.get(i);
		        	                 }
		        	                 String[] options2 = new String[possibleabilitypoints2.size()];
		        	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
		        	                	 options2[i] = possibleabilitypoints2.get(i);
		        	                 }
		        	                 JComboBox abilitypoints = new JComboBox(options);
		        	                 JComboBox abilitypoints2 = new JComboBox(options2);
		        	                 Abilitypoints4panel.add(abilitypoints);
		        	                 Abilitypoints4panel.add(abilitypoints2);
			                        JOptionPane.showConfirmDialog(null, Abilitypoints4panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
			                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
			                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
			                        player.addabilitypoint(abilitypoint1);
			                        player.addabilitypoint(abilitypoint2);
			        				}
			        			break;
			                    case 5: {
			        				player.setexp(6500);
			        				}
			        			break;
			                    case 6: {
			        				player.setexp(14000);
			        				if (Charclass.equals("Barbarian")){
			        					//Subclass choices
			        	                 if (player.getSubClass().contentEquals("Path of the Totem Warrior")) {
			        	                	 ArrayList<String> Subclasschoice = occupation.getsubclasschoices();
				        	            	 JPanel BarbariansubclasschoicePanel1 = new JPanel();
				        	            	 String[] options = new String[Subclasschoice.size()];
				        	                 for(int i = 0; i< Subclasschoice.size(); i++) {
				        	                	 options[i] = Subclasschoice.get(i);
				        	                 }
				        	                 JComboBox newsubclasschoice = new JComboBox(options);
				        	                 BarbariansubclasschoicePanel1.add(newsubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, BarbariansubclasschoicePanel1, "Choose a Totem Spirit for your Barbarian:", JOptionPane.OK_OPTION);
				        	                 occupation.setChoicesub((String) newsubclasschoice.getSelectedItem());
			        	                 }
			        				}
			        				if (Charclass.equals("Fighter")){
			        					 //Choose 2 Abilities to Increase
				        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
				        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
				       	            	 JPanel Abilitypoints4panel = new JPanel();
				       	            	 String[] options = new String[possibleabilitypoints.size()];
				       	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
				       	                	 options[i] = possibleabilitypoints.get(i);
				       	                 }
				       	                 String[] options2 = new String[possibleabilitypoints2.size()];
				       	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
				       	                	 options2[i] = possibleabilitypoints2.get(i);
				       	                 }
				       	                 JComboBox abilitypoints = new JComboBox(options);
				       	                 JComboBox abilitypoints2 = new JComboBox(options2);
				       	                 Abilitypoints4panel.add(abilitypoints);
				       	                 Abilitypoints4panel.add(abilitypoints2);
				                        JOptionPane.showConfirmDialog(null, Abilitypoints4panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
				                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
				                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
				                        player.addabilitypoint(abilitypoint1);
				                        player.addabilitypoint(abilitypoint2);
			        				}
			        				if (Charclass.equals("Ranger")) {
			        				 // Add Favored Enemy
			        		           ArrayList<String> Enemies = occupation.possibleFavoredEnemies(player);
			        		           String[] possibleenemies = new String[Enemies.size()];
			        		      	   for (int i = 0; i < Enemies.size(); i++) { 
			        		              possibleenemies[i] = Enemies.get(i);
			        		      		}
			        		           JPanel FavoredEnemyPanel = new JPanel();
			        		           JComboBox enemyList = new JComboBox(possibleenemies);
			        		           FavoredEnemyPanel.add(enemyList);
			        		           JOptionPane.showConfirmDialog(null, FavoredEnemyPanel, "Choose a Favored Enemy for the Ranger", JOptionPane.OK_OPTION);
			        		           occupation.Addfavoredenemy((String) enemyList.getSelectedItem(), player);
			        		           
			        		           //Choose lang of Favored Enemy
			        		           String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
			        		           
			        		           String EnemyLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language Of Favored Enemy", "Ranger Favored Enemy", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
			        		           
			        		           player.addLang(EnemyLang);
			        		           
			        		           // Add Natural Explorer
			        		           ArrayList<String> Terrain = occupation.possibleNaturalExplorer(player);
			        		           String[] possibleterrain = new String[Terrain.size()];
			        		      	   for (int i = 0; i < Terrain.size(); i++) { 
			        		      		 possibleterrain[i] = Terrain.get(i);
			        		      		}
			        		           JPanel NaturalExplorerPanel = new JPanel();
			        		           JComboBox TerrainList = new JComboBox(possibleterrain);
			        		           NaturalExplorerPanel.add(TerrainList);
			        		           JOptionPane.showConfirmDialog(null, NaturalExplorerPanel, "Choose a Natural Explorer for the Ranger", JOptionPane.OK_OPTION);
			        		           occupation.AddNaturalExplorer((String) TerrainList.getSelectedItem(), player);
			        				
			        				}
			        				if (Charclass.equals("Rogue")){
				        				 //get Expert skill 
			        	                 for(int y = 0; y < 2; y++) {
			        	                 ArrayList<String> bardexpert = occupation.possibleExpertskillsCharacter(player);
			        	            	 JPanel BardExpertPanel1 = new JPanel();
			        	            	 String[] Expert = new String[bardexpert.size()];
			        	                 for(int i = 0; i< bardexpert.size(); i++) {
			        	                	Expert[i] = bardexpert.get(i);
			        	                 }
			        	                 JComboBox newexpertbard = new JComboBox(Expert);
			        	                 BardExpertPanel1.add(newexpertbard);
			        	                 JOptionPane.showConfirmDialog(null, BardExpertPanel1, "Choose a Skill to Make Expert:", JOptionPane.OK_OPTION);
			        	                 player.setExpert((String) newexpertbard.getSelectedItem());
			        	                 }
			        				}
			        			}
			        			break;
			                    case 7: {
			        				player.setexp(23000);
			        				if (Charclass.equals("Fighter")){
				        				 if (player.getSubClass().contentEquals("Battle Master")) {
					        				for (int y = 0; y < 2; y++ ) {
					        					 ArrayList<String> maneuversSubclasschoice = occupation.getpossibleManeuvers(player);
					        	            	 JPanel MansubclasschoicePanel1 = new JPanel();
					        	            	 String[] optionsman = new String[maneuversSubclasschoice.size()];
					        	                 for(int i = 0; i< maneuversSubclasschoice.size(); i++) {
					        	                	optionsman[i] = maneuversSubclasschoice.get(i);
					        	                 }
					        	                 JComboBox Mansubclasschoice = new JComboBox(optionsman);
					        	                 MansubclasschoicePanel1.add(Mansubclasschoice);
					        	                 JOptionPane.showConfirmDialog(null, MansubclasschoicePanel1, "Choose a Maneuver for your BattleMaster", JOptionPane.OK_OPTION);
					        	                 occupation.setChoicesub((String) Mansubclasschoice.getSelectedItem());
					        	                 occupation.getGUImaneuvers(player);
				       	                 	}
				        				 }
			        				}
			        				
			        				if (Charclass.equals("Ranger")){
		 	        	              //Subclass choices
			        	                 if (player.getSubClass().contentEquals("Hunter")) {
			        	                	 JPanel huntersubclasschoicePanel1 = new JPanel();
				        	            	 String[] options4 = new String[3];
				        	                 options4[0] = "Escape the Horde";
				        	                 options4[1] = "Multiattack Defense";
				        	                 options4[2] = "Steel Will";
				        	                 JComboBox huntersubclasschoice = new JComboBox(options4);
				        	                 huntersubclasschoicePanel1.add(huntersubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, huntersubclasschoicePanel1, "Choose a Defensive Tactic for your Ranger:", JOptionPane.OK_OPTION);
				        	                 occupation.setChoicesub((String) huntersubclasschoice.getSelectedItem());
			        	                 }
			        	             
			        	             }
	
			        				}
			        			break;
			                    case 8: {
			        				player.setexp(34000);
			        				//Choose 2 Abilities to Increase
			        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
			        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
		        	            	 JPanel Abilitypoints8panel = new JPanel();
		        	            	 String[] options = new String[possibleabilitypoints.size()];
		        	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
		        	                	 options[i] = possibleabilitypoints.get(i);
		        	                 }
		        	                 String[] options2 = new String[possibleabilitypoints2.size()];
		        	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
		        	                	 options2[i] = possibleabilitypoints2.get(i);
		        	                 }
		        	                 JComboBox abilitypoints = new JComboBox(options);
		        	                 JComboBox abilitypoints2 = new JComboBox(options2);
		        	                 Abilitypoints8panel.add(abilitypoints);
		        	                 Abilitypoints8panel.add(abilitypoints2);
			                        JOptionPane.showConfirmDialog(null, Abilitypoints8panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
			                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
			                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
			                        player.addabilitypoint(abilitypoint1);
			                        player.addabilitypoint(abilitypoint2);
			        				}
			        			break;
			                    case 9: {
			        				player.setexp(48000);
			        				}
			        			break;
			                    case 10: {
			        				player.setexp(64000);
			        				if (Charclass.equals("Bard")){
				        				 //get Expert skill 
			        	                 for(int y = 0; y < 2; y++) {
			        	                 ArrayList<String> bardexpert = occupation.possibleExpertskillsCharacter(player);
			        	            	 JPanel BardExpertPanel1 = new JPanel();
			        	            	 String[] Expert = new String[bardexpert.size()];
			        	                 for(int i = 0; i< bardexpert.size(); i++) {
			        	                	Expert[i] = bardexpert.get(i);
			        	                 }
			        	                 JComboBox newexpertbard = new JComboBox(Expert);
			        	                 BardExpertPanel1.add(newexpertbard);
			        	                 JOptionPane.showConfirmDialog(null, BardExpertPanel1, "Choose a Skill to Make Expert:", JOptionPane.OK_OPTION);
			        	                 player.setExpert((String) newexpertbard.getSelectedItem());
			        	                 }
			        				}
			        				
			        				if (Charclass.equals("Fighter")){
				        				 if (player.getSubClass().contentEquals("Battle Master")) {
					        				for (int x = 0; x < 2; x++ ) {
					        					 ArrayList<String> maneuversSubclasschoice = occupation.getpossibleManeuvers(player);
					        	            	 JPanel MansubclasschoicePanel1 = new JPanel();
					        	            	 String[] optionsman = new String[maneuversSubclasschoice.size()];
					        	                 for(int i = 0; i< maneuversSubclasschoice.size(); i++) {
					        	                	optionsman[i] = maneuversSubclasschoice.get(i);
					        	                 }
					        	                 JComboBox Mansubclasschoice = new JComboBox(optionsman);
					        	                 MansubclasschoicePanel1.add(Mansubclasschoice);
					        	                 JOptionPane.showConfirmDialog(null, MansubclasschoicePanel1, "Choose a Maneuver for your BattleMaster", JOptionPane.OK_OPTION);
					        	                 occupation.setChoicesub((String) Mansubclasschoice.getSelectedItem());
					        	                 occupation.getGUImaneuvers(player);
				       	                 	}
				        				 }
			        				}
			        				
			        				if (Charclass.equals("Ranger")) {
				        				 // Add Natural Explorer
				        		           ArrayList<String> Terrain = occupation.possibleNaturalExplorer(player);
				        		           String[] possibleterrain = new String[Terrain.size()];
				        		      	   for (int i = 0; i < Terrain.size(); i++) { 
				        		      		 possibleterrain[i] = Terrain.get(i);
				        		      		}
				        		           JPanel NaturalExplorerPanel = new JPanel();
				        		           JComboBox TerrainList = new JComboBox(possibleterrain);
				        		           NaturalExplorerPanel.add(TerrainList);
				        		           JOptionPane.showConfirmDialog(null, NaturalExplorerPanel, "Choose a Natural Explorer for the Ranger", JOptionPane.OK_OPTION);
				        		           occupation.AddNaturalExplorer((String) TerrainList.getSelectedItem(), player);
			        				}
			        				
			        				if (Charclass.equals("Rogue")){
				        				//Choose 2 Abilities to Increase
				        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
				        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
				       	            	 JPanel Abilitypoints4panel = new JPanel();
				       	            	 String[] options = new String[possibleabilitypoints.size()];
				       	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
				       	                	 options[i] = possibleabilitypoints.get(i);
				       	                 }
				       	                 String[] options2 = new String[possibleabilitypoints2.size()];
				       	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
				       	                	 options2[i] = possibleabilitypoints2.get(i);
				       	                 }
				       	                 JComboBox abilitypoints = new JComboBox(options);
				       	                 JComboBox abilitypoints2 = new JComboBox(options2);
				       	                 Abilitypoints4panel.add(abilitypoints);
				       	                 Abilitypoints4panel.add(abilitypoints2);
				                        JOptionPane.showConfirmDialog(null, Abilitypoints4panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
				                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
				                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
				                        player.addabilitypoint(abilitypoint1);
				                        player.addabilitypoint(abilitypoint2);
				                   }	
			        				
		        				 if (Charclass.equals("Sorcerer")){
			        	            	//MetaMagic choices
		        	                  for (int y = 0; y < 1; y++) { 	 
		 	        	        	   	 ArrayList<String> MetamagicSubclasschoice = occupation.possiblemetamagic(player);
			        	            	 JPanel metamagicsubclasschoicePanel1 = new JPanel();
			        	            	 String[] options3 = new String[MetamagicSubclasschoice.size()];
			        	                 for(int i = 0; i< MetamagicSubclasschoice.size(); i++) {
			        	                	 options3[i] = MetamagicSubclasschoice.get(i);
			        	                 }
			        	                 JComboBox metamagicsubclasschoice = new JComboBox(options3);
			        	                 metamagicsubclasschoicePanel1.add(metamagicsubclasschoice);
			        	                 JOptionPane.showConfirmDialog(null, metamagicsubclasschoicePanel1, "Choose a Metamagic Spell:", JOptionPane.OK_OPTION);
			        	                 occupation.AddmMetaMagic((String) metamagicsubclasschoice.getSelectedItem(), player);
		        	                  }
		 	        	           }  
		        				}
			        			break;
			                    case 11: {
			        				player.setexp(85000);
			        				if (Charclass.equals("Ranger")){
			 	        	              //Subclass choices
				        	                 if (player.getSubClass().contentEquals("Hunter")) {
				        	                	 JPanel huntersubclasschoicePanel1 = new JPanel();
					        	            	 String[] options4 = new String[2];
					        	                 options4[0] = "Volley";
					        	                 options4[1] = "Whirlwind Attack";
					        	                 JComboBox huntersubclasschoice = new JComboBox(options4);
					        	                 huntersubclasschoicePanel1.add(huntersubclasschoice);
					        	                 JOptionPane.showConfirmDialog(null, huntersubclasschoicePanel1, "Choose a Multiattack for your Ranger:", JOptionPane.OK_OPTION);
					        	                 occupation.setChoicesub((String) huntersubclasschoice.getSelectedItem());
				        	                 }
				        	             }
			        				}
			        			break;
			        			case 12: {
			        				player.setexp(100000);
			        				//Choose 2 Abilities to Increase
			        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
			        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
		        	            	 JPanel Abilitypoints12panel = new JPanel();
		        	            	 String[] options = new String[possibleabilitypoints.size()];
		        	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
		        	                	 options[i] = possibleabilitypoints.get(i);
		        	                 }
		        	                 String[] options2 = new String[possibleabilitypoints2.size()];
		        	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
		        	                	 options2[i] = possibleabilitypoints2.get(i);
		        	                 }
		        	                 JComboBox abilitypoints = new JComboBox(options);
		        	                 JComboBox abilitypoints2 = new JComboBox(options2);
		        	                 Abilitypoints12panel.add(abilitypoints);
		        	                 Abilitypoints12panel.add(abilitypoints2);
			                        JOptionPane.showConfirmDialog(null, Abilitypoints12panel, "Choose 2 Different abilities to Increase by 1", JOptionPane.OK_OPTION);
			                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
			                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
			                        player.addabilitypoint(abilitypoint1);
			                        player.addabilitypoint(abilitypoint2);
		        				}
			        			break;
			        			case 13: {
			        				player.setexp(120000);
		        				}
			        			break;
			        			case 14: {
			        				player.setexp(140000);
			        				if (Charclass.equals("Barbarian")){
			        					//Subclass choices
			        	                 if (player.getSubClass().contentEquals("Path of the Totem Warrior")) {
			        	                	 ArrayList<String> Subclasschoice = occupation.getsubclasschoices();
				        	            	 JPanel BarbariansubclasschoicePanel1 = new JPanel();
				        	            	 String[] options = new String[Subclasschoice.size()];
				        	                 for(int i = 0; i< Subclasschoice.size(); i++) {
				        	                	 options[i] = Subclasschoice.get(i);
				        	                 }
				        	                 JComboBox newsubclasschoice = new JComboBox(options);
				        	                 BarbariansubclasschoicePanel1.add(newsubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, BarbariansubclasschoicePanel1, "Choose a Totem Spirit for your Barbarian:", JOptionPane.OK_OPTION);
				        	                 occupation.setChoicesub((String) newsubclasschoice.getSelectedItem());
			        	                 }
			        				}    
		        	                 if (Charclass.equals("Fighter")){
	 		        					 //Choose 2 Abilities to Increase
	 			        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
	 			        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
	 			       	            	 JPanel Abilitypoints14panel = new JPanel();
	 			       	            	 String[] options14 = new String[possibleabilitypoints.size()];
	 			       	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
	 			       	                	 options14[i] = possibleabilitypoints.get(i);
	 			       	                 }
	 			       	                 String[] options142 = new String[possibleabilitypoints2.size()];
	 			       	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
	 			       	                	 options142[i] = possibleabilitypoints2.get(i);
	 			       	                 }
	 			       	                 JComboBox ability14points = new JComboBox(options14);
	 			       	                 JComboBox ability14points2 = new JComboBox(options142);
	 			       	                 Abilitypoints14panel.add(ability14points);
	 			       	                 Abilitypoints14panel.add(ability14points2);
	 			                        JOptionPane.showConfirmDialog(null, Abilitypoints14panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
	 			                        String abilitypoint1 = (String) ability14points.getSelectedItem();
	 			                        String abilitypoint2 = (String) ability14points2.getSelectedItem();
	 			                        player.addabilitypoint(abilitypoint1);
	 			                        player.addabilitypoint(abilitypoint2);
		 	        				}	
			        	               
		        	                 if (Charclass.equals("Ranger")) {
				        				 // Add Favored Enemy
				        		           ArrayList<String> Enemies = occupation.possibleFavoredEnemies(player);
				        		           String[] possibleenemies = new String[Enemies.size()];
				        		      	   for (int i = 0; i < Enemies.size(); i++) { 
				        		              possibleenemies[i] = Enemies.get(i);
				        		      		}
				        		           JPanel FavoredEnemyPanel = new JPanel();
				        		           JComboBox enemyList = new JComboBox(possibleenemies);
				        		           FavoredEnemyPanel.add(enemyList);
				        		           JOptionPane.showConfirmDialog(null, FavoredEnemyPanel, "Choose a Favored Enemy for the Ranger", JOptionPane.OK_OPTION);
				        		           occupation.Addfavoredenemy((String) enemyList.getSelectedItem(), player);
				        		           
				        		           //Choose lang of Favored Enemy
				        		           String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
				        		           
				        		           String EnemyLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language Of Favored Enemy", "Ranger Favored Enemy", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
				        		           
				        		           player.addLang(EnemyLang);
				        		      }
			        				}
			        			break;
			        			case 15: {
			        				player.setexp(165000);
			        				if (Charclass.equals("Fighter")){
				        				 if (player.getSubClass().contentEquals("Battle Master")) {
					        				for (int y = 0; y < 2; y++ ) {
					        	                 ArrayList<String> maneuversSubclasschoice = occupation.getpossibleManeuvers(player);
					        	            	 JPanel MansubclasschoicePanel1 = new JPanel();
					        	            	 String[] optionsman = new String[maneuversSubclasschoice.size()];
					        	                 for(int i = 0; i< maneuversSubclasschoice.size(); i++) {
					        	                	optionsman[i] = maneuversSubclasschoice.get(i);
					        	                 }
					        	                 JComboBox Mansubclasschoice = new JComboBox(optionsman);
					        	                 MansubclasschoicePanel1.add(Mansubclasschoice);
					        	                 JOptionPane.showConfirmDialog(null, MansubclasschoicePanel1, "Choose a Maneuver for your BattleMaster", JOptionPane.OK_OPTION);
					        	                 occupation.setChoicesub((String) Mansubclasschoice.getSelectedItem());
					        	                 occupation.getGUImaneuvers(player);
				       	                 	}
				        				 }
			        				}
			        				
			        				
			        				if (Charclass.equals("Ranger")){
		 	        	              //Subclass choices
			        	                 if (player.getSubClass().contentEquals("Hunter")) {
			        	                	 JPanel huntersubclasschoicePanel1 = new JPanel();
				        	            	 String[] options4 = new String[3];
				        	                 options4[0] = "Evasion";
				        	                 options4[1] = "Stand Against the Tide";
				        	                 options4[2] = "Uncanny Dodge";
				        	                 JComboBox huntersubclasschoice = new JComboBox(options4);
				        	                 huntersubclasschoicePanel1.add(huntersubclasschoice);
				        	                 JOptionPane.showConfirmDialog(null, huntersubclasschoicePanel1, "Choose a Superior Hunter's Defense for your Ranger:", JOptionPane.OK_OPTION);
				        	                 occupation.setChoicesub((String) huntersubclasschoice.getSelectedItem());
			        	                 }
			        	             }
		        				}
			        			break;
			        			case 16: {
			        				player.setexp(195000);
			        				//Choose 2 Abilities to Increase
			                        //May need a way to stop the user from selecting the same ability twice
			        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
			        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
		        	            	 JPanel Abilitypoints16panel = new JPanel();
		        	            	 String[] options = new String[possibleabilitypoints.size()];
		        	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
		        	                	 options[i] = possibleabilitypoints.get(i);
		        	                 }
		        	                 String[] options2 = new String[possibleabilitypoints2.size()];
		        	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
		        	                	 options2[i] = possibleabilitypoints2.get(i);
		        	                 }
		        	                 JComboBox abilitypoints = new JComboBox(options);
		        	                 JComboBox abilitypoints2 = new JComboBox(options2);
		        	                 Abilitypoints16panel.add(abilitypoints);
		        	                 Abilitypoints16panel.add(abilitypoints2);
			                        JOptionPane.showConfirmDialog(null, Abilitypoints16panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
			                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
			                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
			                        player.addabilitypoint(abilitypoint1);
			                        player.addabilitypoint(abilitypoint2);
			        				}
			        			break;
			        			case 17: {
			        				player.setexp(225000);
			        				if (Charclass.equals("Sorcerer")){
			        	            	//MetaMagic choices
		        	                  for (int y = 0; y < 1; y++) { 	 
		 	        	        	   	 ArrayList<String> MetamagicSubclasschoice = occupation.possiblemetamagic(player);
			        	            	 JPanel metamagicsubclasschoicePanel1 = new JPanel();
			        	            	 String[] options3 = new String[MetamagicSubclasschoice.size()];
			        	                 for(int i = 0; i< MetamagicSubclasschoice.size(); i++) {
			        	                	 options3[i] = MetamagicSubclasschoice.get(i);
			        	                 }
			        	                 JComboBox metamagicsubclasschoice = new JComboBox(options3);
			        	                 metamagicsubclasschoicePanel1.add(metamagicsubclasschoice);
			        	                 JOptionPane.showConfirmDialog(null, metamagicsubclasschoicePanel1, "Choose a Metamagic Spell:", JOptionPane.OK_OPTION);
			        	                 occupation.AddmMetaMagic((String) metamagicsubclasschoice.getSelectedItem(), player);
		        	                  }
		 	        	           }  
			        				}
			        			break;
			        			case 18: {
			        				player.setexp(265000);
			        				}
			        			break;
			        			case 19: {
			        				player.setexp(305000);
			        				//Choose 2 Abilities to Increase
			                        //May need a way to stop the user from selecting the same ability twice
			        				 ArrayList<String> possibleabilitypoints = player.AvailableAbilitypoints();
			        				 ArrayList<String> possibleabilitypoints2 = player.AvailableAbilitypoints18();
		        	            	 JPanel Abilitypoints19panel = new JPanel();
		        	            	 String[] options = new String[possibleabilitypoints.size()];
		        	                 for(int i = 0; i< possibleabilitypoints.size(); i++) {
		        	                	 options[i] = possibleabilitypoints.get(i);
		        	                 }
		        	                 String[] options2 = new String[possibleabilitypoints2.size()];
		        	                 for(int i = 0; i< possibleabilitypoints2.size(); i++) {
		        	                	 options2[i] = possibleabilitypoints2.get(i);
		        	                 }
		        	                 JComboBox abilitypoints = new JComboBox(options);
		        	                 JComboBox abilitypoints2 = new JComboBox(options2);
		        	                 Abilitypoints19panel.add(abilitypoints);
		        	                 Abilitypoints19panel.add(abilitypoints2);
			                        JOptionPane.showConfirmDialog(null, Abilitypoints19panel, "Choose 2 Different Abilities to Increase by 1", JOptionPane.OK_OPTION);
			                        String abilitypoint1 = (String) abilitypoints.getSelectedItem();
			                        String abilitypoint2 = (String) abilitypoints2.getSelectedItem();
			                        player.addabilitypoint(abilitypoint1);
			        				}
			        			break;
			        			case 20: {
			        				player.setexp(355000);
	
			        				}
			        			break;
		                    }
		                    //(Requirement 7.1.1.2.3) Character has level checked
		                    player.checklvl(occupation);
		              
		                    
		                    try {
		        	    		String age = ageBox.getText();
		                        if(!(ageBox.getText().isEmpty())) {
		                        	player.setage(Integer.parseInt(age));
		                        }
		                       	player.setheight(heightBox.getText());
		               			player.setweight(weightBox.getText());
		               			player.setsize(sizeBox.getText());
		            			player.seteyes(eyesBox.getText()); //(Requirement 11.1.2.2) Text will be saved if character is saved or leveled
		            			player.sethair(hairBox.getText()); //(Requirement 11.1.1.2) Text will be saved if character is saved or leveled
		            			
		            			
		            			 //Retrieve Weapon1 info
		                        String name1 = weaponName1.getText();
		                        int attack1;
		                        if(!(weaponAtk1.getText().isEmpty())){
		                        	attack1 = Integer.parseInt(weaponAtk1.getText());
		                        } else attack1 = 0;
		                        String damage1 = weaponDmg1.getText();
		                        String type1 = weaponType1.getText();
		                        Weapons weap1 = new Weapons(name1, attack1, damage1, type1); 
		                        player.addtoweapons(weap1, 0);
		                        
		                        //Retrieve Weapon2 info
		                        String name2 = weaponName2.getText();
		                        int attack2;
		                        if(!(weaponAtk2.getText().isEmpty())){
		                        	attack2 = Integer.parseInt(weaponAtk2.getText());
		                        } else attack2 = 0;
		                        String damage2 = weaponDmg2.getText();
		                        String type2 = weaponType2.getText();
		                       
		                        Weapons weap2 = new Weapons(name2, attack2, damage2, type2); 
		                        player.addtoweapons(weap2, 1);
		                        
		                        
		                      //Retrieve Weapon3 info
		                        String name3 = weaponName3.getText();
		                        int attack3;
		                        if(!(weaponAtk3.getText().isEmpty())){
		                        	attack3 = Integer.parseInt(weaponAtk3.getText());
		                        } else attack3 = 0;
		                        String damage3 = weaponDmg3.getText();
		                        String type3 = weaponType3.getText();
		                       
		                        Weapons weap3 = new Weapons(name3, attack3, damage3, type3); 
		                        player.addtoweapons(weap3, 2);
		            			
		            			//Add Armor
		            			String Armorname = armorName1.getText();
		            			 int ArmorAC1value;
		                         if(!(armorAC1.getText().isEmpty())){
		                        	 ArmorAC1value = Integer.parseInt(weaponAtk3.getText());
		                         } else ArmorAC1value = 0;
		                         int ArmorAC1bonus;
		                         if(!(armorMagic1.getText().isEmpty())){
		                        	 ArmorAC1bonus = Integer.parseInt(armorMagic1.getText());
		                         } else ArmorAC1bonus = 0;
		            			    			
		            			Armor newarmor = new Armor(Armorname, ArmorAC1value, ArmorAC1bonus);
		            			player.Setarmor(newarmor);
		            		
		            			//(Requirement 7.1.1.2.3.4)  The character is saved
		            			here.saveCharacter(player);
							} catch (IOException e) {
								e.printStackTrace();
							}
	                   }    
	                    ClearMethods clear = new ClearMethods();
	                    //(Requirements 7.1.1.2.3.6) Graphical User interface is refreshed.
	                    clear.refreshAllAreas();
                   		}    
                    else {
                    	//(Requirement 7.1.1.1) If no character exists, the program will display a message box asking the user to create a character before leveling.
	                	JOptionPane.showMessageDialog(null, "Please build or load a character before trying to level.");
                    }
                }
            }
        }
    }
   
    private class ApplyListener implements ActionListener{

        @Override
        
        public void actionPerformed(ActionEvent e) {
            //(Requirement 3.6.1) The program shall check that a race, class, background and name have been chosen for the character
        	if(raceSelected == true && classSelected == true && backgroundSelected == true && nameentered == true)
            {
                //Clear Text Areas so they are not duplicated
                ClearMethods clear = new ClearMethods();
                clear.clearAllAreas();
                
                player = here.getRace(race); //(Requirement 3.6.1.2. its child requirements) Creates the active character
                here.getbackground(player, background); // (Requirement 3.6.3.1) The background features, gold and equipment will be applied to the character
                occupation = here.getClass(player, charclass); // (Requirement 3.6.2.1.) Class features including hit point calculations and saving throws are added
                player.setName(charname);
                
                //Set Alignment
                if(!(align == null)) {     
                	player.setAlignment(align);
                }
                
                //(Requirement 3.5.2)  User can roll their ability scores
                //Set ability points
                if(!(statarray == null)) {
	                player.setstr(statarray[0]+ player.getstr());
	        		player.setDex(statarray[1]+ player.getDex());
	        		player.setcon(statarray[2]+ player.getcon());
	        		player.setintel(statarray[3]+ player.getintel());
	        		player.setwis(statarray[4] + player.getwis());
	        		player.setchar(statarray[5]+ player.getchar());
	        		player.calcinitiative(); 
                }
          
                //player characteristics 
                String age = ageBox.getText();
                if(!(ageBox.getText().isEmpty())) {
                	player.setage(Integer.parseInt(age));
                }
               	player.setheight(heightBox.getText());
       			player.setweight(weightBox.getText());
       			player.setsize(sizeBox.getText());
    			player.seteyes(eyesBox.getText()); //(Requirement 11.1.2.1) Text  from eyes  text box is saved to character
    			player.sethair(hairBox.getText()); //(Requirement 11.1.1.1) Text from Hair Box is saved to character
    		    			
    			//Get String from infoarea
    			String info = info_area.getText();
    			player.setinfo(info);
    			
               //Show new ability point values
                str_score.setText(Integer.toString(player.getstr()));
                dex_score.setText(Integer.toString(player.getDex()));
                con_score.setText(Integer.toString(player.getcon()));
                int_score.setText(Integer.toString(player.getintel()));
                wis_score.setText(Integer.toString(player.getwis()));
                cha_score.setText(Integer.toString(player.getchar()));
                
                //Set ability mods
        	   	String[] ablilitymod = player.calcabilitymod();
        	    str_mod.setText(ablilitymod[0]);
        	    dex_mod.setText(ablilitymod[1]);
        	    con_mod.setText(ablilitymod[2]);
        	    int_mod.setText(ablilitymod[3]);
        	    wis_mod.setText(ablilitymod[4]);
        	    cha_mod.setText(ablilitymod[5]);

                //Show skills
                player.calcSkillmods();
            //    occupation.recalcClassmods(player);
                acroField.setText((player.displaymods(player.getAcromod())));
                animField.setText(player.displaymods(player.getAnimalmod()));
                arcaField.setText(player.displaymods(player.getArcanamod()));
                athlField.setText(player.displaymods(player.getAthleticsmod()));
                deceField.setText(player.displaymods(player.getDeceptionsmod()));
                histField.setText(player.displaymods(player.getHistorymod()));
                insiField.setText(player.displaymods(player.getInsightmod()));
                intiField.setText(player.displaymods(player.getIntimidatemod()));
                inveField.setText(player.displaymods(player.getInvestigatemod()));
                mediField.setText(player.displaymods(player.getMedicinemod()));
                natuField.setText(player.displaymods(player.getNaturemod()));
                percField.setText(player.displaymods(player.getPerceptionmod()));
                perfField.setText(player.displaymods(player.getPerformancenmod()));
                persField.setText(player.displaymods(player.getPersuasionmod()));
                reliField.setText(player.displaymods(player.getReligionmod()));
                sleiField.setText(player.displaymods(player.getSleightHandmod()));
                steaField.setText(player.displaymods(player.getStealthmod()));
                survField.setText(player.displaymods(player.getSurvivalmod()));
                
                // set health and other variables
                hp_current.setText(Integer.toString(player.gethitpoint()));
                hp_max.setText(Integer.toString(player.gethitpoint()));
                armorClass.setText(Integer.toString(player.getTotalAC()));
                player.calcinitiative();
                initiative.setText(player.getinitiative()); 
                speed.setText(Integer.toString(player.getSpeed()));
                profField.setText(Integer.toString(player.getProfiencyBonus()));
                exp.setText(Integer.toString(player.getexp()));
                warlockLeftBox.setText(Integer.toString(player.getspellslotsLeft()));
                warlockTotalBox.setText(Integer.toString(player.getspellslots()));
                kiLeftBox.setText(Integer.toString(player.getKipointsleft()));
                kiTotalBox.setText(Integer.toString(player.getKipoints()));
                sorceryLeftBox.setText(Integer.toString(player.getSorcerypointsleft()));
                sorceryTotalBox.setText(Integer.toString(player.getSorcerypoints()));
                subclassBox.setText(player.getSubClass());
                                
              //player show chararcteristics
                ageBox.setText(Integer.toString(player.getage()));
                heightBox.setText(player.getheight());
                weightBox.setText(player.getweight());
                sizeBox.setText(player.getsize());
                eyesBox.setText(player.geteyes());//(Requirement 11.1.1.2.1)  Eyes  color remains after refresh
                hairBox.setText(player.gethair()); //(Requirement 11.1.1.2.1) Hair color remains after refresh
                info_area.setText(player.getinfo());
            
               //Retrieve Weapon1 info
                String name1 = weaponName1.getText();
                int attack1;
                if(!(weaponAtk1.getText().isEmpty())){
                	attack1 = Integer.parseInt(weaponAtk1.getText());
                } else attack1 = 0;
                String damage1 = weaponDmg1.getText();
                String type1 = weaponType1.getText();
                Weapons weap1 = new Weapons(name1, attack1, damage1, type1); 
                player.addtoweapons(weap1, 0);
                
                //Retrieve Weapon2 info
                String name2 = weaponName2.getText();
                int attack2;
                if(!(weaponAtk2.getText().isEmpty())){
                	attack2 = Integer.parseInt(weaponAtk2.getText());
                } else attack2 = 0;
                String damage2 = weaponDmg2.getText();
                String type2 = weaponType2.getText();
               
                Weapons weap2 = new Weapons(name2, attack2, damage2, type2); 
                player.addtoweapons(weap2, 1);
                
                
              //Retrieve Weapon3 info
                String name3 = weaponName3.getText();
                int attack3;
                if(!(weaponAtk3.getText().isEmpty())){
                	attack3 = Integer.parseInt(weaponAtk3.getText());
                } else attack3 = 0;
                String damage3 = weaponDmg3.getText();
                String type3 = weaponType3.getText();
               
                Weapons weap3 = new Weapons(name3, attack3, damage3, type3); 
                player.addtoweapons(weap3, 2);
                
            	//Add Armor
    			String Armorname = armorName1.getText();
    			 int ArmorAC1value;
                 if(!(armorAC1.getText().isEmpty())){
                	 ArmorAC1value = Integer.parseInt(armorAC1.getText());
                 } else ArmorAC1value = 0;
                 int ArmorAC1bonus;
                 if(!(armorMagic1.getText().isEmpty())){
                	 ArmorAC1bonus = Integer.parseInt(armorMagic1.getText());
                 } else ArmorAC1bonus = 0;
    			    			
    			Armor newarmor = new Armor(Armorname, ArmorAC1value, ArmorAC1bonus);
    			player.Setarmor(newarmor);
                
                //Weapon display info 
                weaponName1.setText(player.getweaponname(0));
                weaponAtk1.setText(player.getweaponattackbonus(0));
                weaponDmg1.setText(player.getweapondamage(0));
                weaponType1.setText(player.getweapontype(0));
                weaponName2.setText(player.getweaponname(1));
                weaponAtk2.setText(player.getweaponattackbonus(1));;
                weaponDmg2.setText(player.getweapondamage(1));
                weaponType2.setText(player.getweapondamage(1));
                weaponName3.setText(player.getweaponname(2));
                weaponAtk3.setText(player.getweaponattackbonus(2));;
                weaponDmg3.setText(player.getweapondamage(2));;
                weaponType3.setText(player.getweapondamage(2)); 
                
                armorName1.setText(player.getarmorname());
                armorAC1.setText(Integer.toString(player.getarmorAC()));
    			armorMagic1.setText(Integer.toString(player.getarmorbonus()));
                
                //Character specific choices are made 
    			//(Requirements 3.7) Choice pop up boxes will appear to allow the user to make the appropriate choices for their character
                choice.raceChoice(); //(Requirements 3.7.1. Number and types of choice pop ups will depend on the race, background, class and subclass of character.) 
                choice.BackgroundChoice(); //(Requirements 3.7.1. Number and types of choice pop ups will depend on the race, background, class and subclass of character.)
                choice.ClassChoice(); //(Requirements 3.7.1. Number and types of choice pop ups will depend on the race, background, class and subclass of character.)
                hasapplied = true;
                levelList.setSelectedIndex(0);
               
                //Redisplay all values
                clear.refreshAllAreas();
                
            }
            else{
                
            	 //(Requirement 3.6.1.1) The program shall check that a race, class, background and name have been chosen for the character
            	JPanel applyErrorPane = new JPanel();
                String applyError = "Please Select the Following before Applying Again: ";
                if(raceSelected == false){
                    applyError = applyError.concat(" |Race|");
                }
                if(classSelected == false){
                    applyError = applyError.concat(" |Class|");
                }
                if(backgroundSelected == false){
                    applyError = applyError.concat(" |Background|");
                }
                if(nameentered == false){
                    applyError = applyError.concat(" |Name| (Make sure you hit the Pen Icon to set the name)");
                }
                
                JOptionPane.showMessageDialog(applyErrorPane,applyError, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    private class Choice extends Character{ 
        
        public void raceChoice(){
                    if("Dragonborn".equals(race)){
                        String[] breaths = {"Black", "Blue", "Brass", "Bronze", "Copper", "Gold", "Green", "Red", "Silver", "White"};
                        String dragonColor = (String) JOptionPane.showInputDialog(breathFrame, "Choose a color...", "Dragonborn Breath Weapon", JOptionPane.QUESTION_MESSAGE, null, breaths, breaths[0]);
                        
                        player.CheckandAddFeat(dragonColor + " Dragonborn");
                        
                    }
                    if("High Elf".equals(race)){
                    	//Choose Language
                    	//(Requirements 3.7.1.1.1) Choose Languages
                        String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]); 
                        //(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                        // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                        //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
                        
                        String elfHLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "High Elf Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
                        
                        //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                        player.checkandAddlang(elfHLang);
                        
                       //(Requirements 3.7.1.1.2) Choose Cantrip Spells
                        int cantripsknown = player.getracecantripsknown();
                        for(int j = 0; j < 1; j++ ) {
                     	   JPanel HighElfcantripPanel1 = new JPanel();
                     	   
                     	   //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
                     	   //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
                     	  // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
                     	   ArrayList<String> Cantripoptions = player.possibleSpells(player.getracepossiblecantrips(), 10);
           	   	          String[] options = new String[Cantripoptions.size()];
                          for(int i = 0; i< Cantripoptions.size(); i++) {
                       	   options[i] = Cantripoptions.get(i);
                          }
                          JComboBox cantripList = new JComboBox(options);
                          HighElfcantripPanel1.add(cantripList);
                          JOptionPane.showConfirmDialog(null, HighElfcantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);

                          //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
                          occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 10);
              	       }
                        
                    }
                    if("Half Elf".equals(race)){
                        //Choose Language
                    	//(Requirements 3.7.1.1.1) Choose Languages
                    	
                    	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                        // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                        //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
                        String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
                        
                    	
                        String halfElfLang = (String) JOptionPane.showInputDialog(halfElfLangFrame, "Choose a Language to Learn...", "Half Elf Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
                        //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                        player.checkandAddlang(halfElfLang);
                        
                        //Choose 2 Abilities to Increase
                        //May need a way to stop the user from selecting the same ability twice
                        halfElfAbilityPanel.add(abilityList1);
                        halfElfAbilityPanel.add(abilityList2);
                        JOptionPane.showConfirmDialog(null, halfElfAbilityPanel, "Choose 2 Different abilities to Increase by 1", JOptionPane.OK_OPTION);
                        player.addabilitypoint((String) abilityList1.getSelectedItem());
                        player.addabilitypoint((String) abilityList2.getSelectedItem());
                       
                      
                        int numberschoosenskills = player.getnumberofchoosenskills();
                        		
                        for (int y = 1; y <= numberschoosenskills; y++) {
	                        ArrayList<String> possibleskilllist = player.possibleskills(player.getnewskillslist());
	                        String[] allskills2 = new String[possibleskilllist.size()];
	                        for(int i = 0; i< possibleskilllist.size(); i++) {
	                        	allskills2[i] = possibleskilllist.get(i);
	                      }
                        JPanel halfElfSkillPanel1 = new JPanel();
                        JComboBox skillList3 = new JComboBox(allskills2);//Half Elf
	                    halfElfSkillPanel1.add(skillList3);
	                    JOptionPane.showConfirmDialog(null, halfElfSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
	                    player.addskill((String) skillList3.getSelectedItem());
	                    
                        }    
                    }
                    if("Human".equals(race)){
                    	
                    	 //Choose Language
                    	//(Requirements 3.7.1.1.1) Choose Languages
                    	
                    	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                        // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                        //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
                    	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
                        
                        String HumanLang = (String) JOptionPane.showInputDialog(halfElfLangFrame, "Choose a Language to Learn...", "Human Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
                        
                      //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                        player.checkandAddlang(HumanLang);
                    }
        		}
        
        public void BackgroundChoice(){
            if("Acolyte".equals(background)){
            	    		
                for (int y = 1; y <= 2; y++) {
                	 //Choose Language
                	//(Requirements 3.7.1.1.1) Choose Languages
                	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                        // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                    //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
                	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
	                String AcolyteLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Acolyte Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
	                
	              //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                    player.checkandAddlang(AcolyteLang);	            
                }
            }
            if("Guild Artisan".equals(background)){
            	 //Choose Language
            	//(Requirements 3.7.1.1.1) Choose Languages
            	
            	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
            	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
                String GuildLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Guild Artisan Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
              
                //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                player.addLang(GuildLang);
            }            
            if("Hermit".equals(background)){
            	//Choose Language
            	//(Requirements 3.7.1.1.1) Choose Languages
            	
            	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
            	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
                String HermitLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Hermit Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
                
              //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                player.addLang(HermitLang);
            }
            if("Noble".equals(background)){
            	//Choose Language
            	//(Requirements 3.7.1.1.1) Choose Languages
            	
            	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
            	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
                String NobleLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Noble Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
                
                //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                player.addLang(NobleLang);
            }
            if("Outlander".equals(background)){
            	//Choose Language
            	//(Requirements 3.7.1.1.1) Choose Languages
            	
            	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
            	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
                String OutlanderLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Outlander Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
                
                //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
                player.addLang(OutlanderLang);
            }
            if("Sage".equals(background)){
	    		
                for (int y = 1; y <= 2; y++) {
                	//Choose Language
                	//(Requirements 3.7.1.1.1) Choose Languages
                	
                	//(Requirements 3.7.1.1.1.1)  The language pop up box will be pre-populated with only languages the character does not know. 
                    // AND (Requirements 3.7.1.1.1.1.1) This list will be formed from a list of possible languages where applicable to the race or class
                    //AND (Requirements 3.7.1.1.1.3.)   The next language pop up box will not have the language previously chosen
	            	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
	                String SageLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Sage Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
	                
	              //(Requirements 3.7.1.1.1.2.)   The chosen language will be added to the characters known languages list
	                player.addLang(SageLang);
                }
            }
           
		}
        
        public void ClassChoice(){
        	if("Barbarian".equals(charclass)){
            	
        		// Choose Skills
        		//Requirement (3.7.1.1.3) Choose Skills
        		int numberclasskills = occupation.getnumberskills();	
            	for (int y = 1; y <= numberclasskills; y++) {
            		 
            		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
            		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
            		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
            		 ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                     String[] allskills1 = new String[possibleskilllist.size()];
                     for(int i = 0; i< possibleskilllist.size(); i++) {
                     	allskills1[i] = possibleskilllist.get(i);
                     }
                     JPanel BarbarianSkillPanel1 = new JPanel();
                     JComboBox skillList = new JComboBox(allskills1);//Half Elf
                     BarbarianSkillPanel1.add(skillList);
                     JOptionPane.showConfirmDialog(null, BarbarianSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                     
                     //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                     player.addskill((String) skillList.getSelectedItem());
            	}
            	
            	//Choose Equipment part 1
            	//(Requirement 3.7.1.1.4) Choose Equipment
            	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
            	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class
            	 ArrayList<String> newequip1 = occupation.getnewequip1();
            	 String[] allequip = new String[newequip1.size()];
            	 JPanel BarbarianEquipPanel1 = new JPanel();
                 for(int i = 0; i< newequip1.size(); i++) {
                  	allequip[i] = newequip1.get(i);
                 }
                 JComboBox skillList = new JComboBox(allequip);
                 BarbarianEquipPanel1.add(skillList);
     	
                 
               //Choose Equipment part 2
            	 ArrayList<String> newequip2 = occupation.getnewequip2();
            	 String[] allequip2 = new String[newequip2.size()];
                 for(int i = 0; i< newequip2.size(); i++) {
                  	allequip2[i] = newequip2.get(i);
                 }
                 JComboBox skillList2 = new JComboBox(allequip2);
                 BarbarianEquipPanel1.add(skillList2);
                 
                 //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
                 JOptionPane.showConfirmDialog(null, BarbarianEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
                 
                 //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
                 player.addEquip((String) skillList.getSelectedItem());
                 player.addEquip((String) skillList2.getSelectedItem());
            	
            }
        	
        	if("Bard".equals(charclass)){
            	
        		// Choose Skills
        		//Requirement (3.7.1.1.3) Choose Skills
        		int numberclasskills = occupation.getnumberskills();	
            	for (int y = 1; y <= numberclasskills; y++) {
            		
            		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
            		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
            		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
                     ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                     String[] allskills2 = new String[possibleskilllist.size()];
                     for(int i = 0; i< possibleskilllist.size(); i++) {
                     	allskills2[i] = possibleskilllist.get(i);
                     }
                     JPanel BardSkillPanel1 = new JPanel();
                     JComboBox skillList = new JComboBox(allskills2);//Half Elf
                     BardSkillPanel1.add(skillList);
                     JOptionPane.showConfirmDialog(null, BardSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                     
                   //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                     player.addskill((String) skillList.getSelectedItem());
               
            	 }
            	
            	//Choose Equipment part 1
            	//(Requirement 3.7.1.1.4) Choose Equipment
            	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
            	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class

            	 ArrayList<String> newequip1 = occupation.getnewequip1();
            	 String[] allequip = new String[newequip1.size()];
            	 JPanel BardEquipPanel1 = new JPanel();
                 for(int i = 0; i< newequip1.size(); i++) {
                  	allequip[i] = newequip1.get(i);
                 }
                 JComboBox skillList = new JComboBox(allequip);
                 BardEquipPanel1.add(skillList);
     	
                 
               //Choose Equipment part 2
            	 ArrayList<String> newequip2 = occupation.getnewequip2();
            	 String[] allequip2 = new String[newequip2.size()];
                 for(int i = 0; i< newequip2.size(); i++) {
                  	allequip2[i] = newequip2.get(i);
                 }
                 JComboBox skillList2 = new JComboBox(allequip2);
                 BardEquipPanel1.add(skillList2);
                 
                 
               //Choose Equipment part 3
            	 ArrayList<String> newequip3 = occupation.getnewequip3();
            	 String[] allequip3 = new String[newequip3.size()];
                 for(int i = 0; i< newequip3.size(); i++) {
                  	allequip3[i] = newequip3.get(i);
                 }
                 JComboBox skillList3 = new JComboBox(allequip3);
                 BardEquipPanel1.add(skillList3);
                 
               //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
                 JOptionPane.showConfirmDialog(null, BardEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
                 
               //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
                 player.addEquip((String) skillList.getSelectedItem());
                 player.addEquip((String) skillList2.getSelectedItem());
                 player.addEquip((String) skillList3.getSelectedItem());
                 
                 
                 //Choose a Cantrips
               //(Requirements 3.7.1.1.2) Choose Cantrip Spells
                 int cantripsknown = player.getcantripsknown();
                 for(int j = 1; j <= cantripsknown; j++ ) {
              	   JPanel BardcantripPanel1 = new JPanel();
              	   
              	  //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
             	  //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
             	  // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
              	   ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);
  		   	       String[] options = new String[Cantripoptions.size()];
  	               for(int i = 0; i< Cantripoptions.size(); i++) {
  	            	   options[i] = Cantripoptions.get(i);
  	               }
  	               JComboBox cantripList = new JComboBox(options);
  	               BardcantripPanel1.add(cantripList);
  	               
  	              //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
  	               JOptionPane.showConfirmDialog(null, BardcantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
  	               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
  	   	       }
            	
            }	
        	
        	if("Cleric".equals(charclass)){
            	
        		// Choose Skills
        		//Requirement (3.7.1.1.3) Choose Skills
        		int numberclasskills = occupation.getnumberskills();	
            	for (int y = 1; y <= numberclasskills; y++) {
            		
            		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
            		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
            		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
                     ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                     String[] allskills2 = new String[possibleskilllist.size()];
                     for(int i = 0; i< possibleskilllist.size(); i++) {
                     	allskills2[i] = possibleskilllist.get(i);
                     }
                     JPanel ClericSkillPanel1 = new JPanel();
                     JComboBox skillList = new JComboBox(allskills2);
                     ClericSkillPanel1.add(skillList);
                     JOptionPane.showConfirmDialog(null, ClericSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                   
                     //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                     player.addskill((String) skillList.getSelectedItem());
      
               
            	 }
            	
            	//Choose Equipment part 1
            	//(Requirement 3.7.1.1.4) Choose Equipment
            	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
            	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class
            	 ArrayList<String> newequip1 = occupation.getnewequip1();
            	 String[] allequip = new String[newequip1.size()];
            	 JPanel ClericEquipPanel1 = new JPanel();
                 for(int i = 0; i< newequip1.size(); i++) {
                  	allequip[i] = newequip1.get(i);
                 }
                 JComboBox skillList = new JComboBox(allequip);
                 ClericEquipPanel1.add(skillList);
     	
                 
               //Choose Equipment part 2
            	 ArrayList<String> newequip2 = occupation.getnewequip2();
            	 String[] allequip2 = new String[newequip2.size()];
                 for(int i = 0; i< newequip2.size(); i++) {
                  	allequip2[i] = newequip2.get(i);
                 }
                 JComboBox skillList2 = new JComboBox(allequip2);
                 ClericEquipPanel1.add(skillList2);
                 
                 
               //Choose Equipment part 3
            	 ArrayList<String> newequip3 = occupation.getnewequip3();
            	 String[] allequip3 = new String[newequip3.size()];
                 for(int i = 0; i< newequip3.size(); i++) {
                  	allequip3[i] = newequip3.get(i);
                 }
                 JComboBox skillList3 = new JComboBox(allequip3);
                 ClericEquipPanel1.add(skillList3);
                 
               //Choose Equipment part 4
            	 ArrayList<String> newequip4 = occupation.getnewequip4();
            	 String[] allequip4 = new String[newequip4.size()];
                 for(int i = 0; i< newequip4.size(); i++) {
                	 allequip4[i] = newequip4.get(i);
                 }
                 JComboBox skillList4 = new JComboBox(allequip4);
                 ClericEquipPanel1.add(skillList4);
                 
               //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
                 JOptionPane.showConfirmDialog(null, ClericEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
                 
               //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
                 player.addEquip((String) skillList.getSelectedItem());
                 player.addEquip((String) skillList2.getSelectedItem());
                 player.addEquip((String) skillList3.getSelectedItem());
                 player.addEquip((String) skillList4.getSelectedItem());
                 
                 //Choose a Subclass info
                 //(Requirement 3.7.1.1.5) Choose a Subclass

                 //(Requirement 3.7.1.1.5.1.) The subclass choice pop up box will be pre-populated with ONLY possible subclasses available to the class
            	 ArrayList<String> subclasslist = occupation.getdomainoptions();
            	 JPanel ClericsubclassPanel1 = new JPanel();
            	 String[] domain = new String[subclasslist.size()];
                 for(int i = 0; i< subclasslist.size(); i++) {
                	 domain[i] = subclasslist.get(i);
                 }
                 JComboBox newsubclass = new JComboBox(domain);
                 ClericsubclassPanel1.add(newsubclass);
                 JOptionPane.showConfirmDialog(null, ClericsubclassPanel1, "Choose a Divine Domain for your Cleric:", JOptionPane.OK_OPTION);
                 
                 //(Requirements 3.7.1.1.5.2.)   The chosen subclass will be added to the characters subclass variable
                 player.setSubClass((String) newsubclass.getSelectedItem());
                 occupation.GUIsubclassinfo(player);
                 
                 //Requirement 3.7.1.1.6.) Subclass choices
                 if(((String) newsubclass.getSelectedItem()).equals("Knowledge Domain")) {
                	 for (int y = 1; y <= 2; y++) {
                		
                		//(Requirement 3.7.1.1.6.1.)   The subclass choice pop up box will be pre-populated with ONLY information that pertains to a certain subclass and the character does not know.
                		//(Requirement 3.7.1.1.6.1.1.) This list will be formed from a list of possible subclass values.
                		//(Requirement 3.7.1.1.6.2.1.1) If applicable, the next subclass pop up box will not have the values previously chosen
     	            	String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
     	                String KnowledgeLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language to Learn...", "Knowledge Domain Languages", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
     	                
     	                //(Requirement 3.7.1.1.6.2.   The chosen subclass choice will be added to the correct location in the character.)
     	                player.addLang(KnowledgeLang);
                	 }
                 }
                 
                 if(((String) newsubclass.getSelectedItem()).equals("Knowledge Domain")) {
	                 int numbersubclasskills = occupation.getnumbersubskills();	
	              	for (int y = 1; y <= numbersubclasskills; y++) {
	                       ArrayList<String> possiblessubkilllist = occupation.possiblesubskillsCharacter(player, occupation.getsubclassskills());
	                       String[] allsubskills2 = new String[possiblessubkilllist.size()];
	                       for(int i = 0; i< possiblessubkilllist.size(); i++) {
	                     	  allsubskills2[i] = possiblessubkilllist.get(i);
	                       }
	                       JPanel ClericsubSkillPanel1 = new JPanel();
	                       JComboBox subskillList = new JComboBox(allsubskills2);//Half Elf
	                       ClericsubSkillPanel1.add(subskillList);
	                       JOptionPane.showConfirmDialog(null, ClericsubSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
	                       player.addskill((String) subskillList.getSelectedItem());
	                           
	              	 }
                 }
                 
                 if(((String) newsubclass.getSelectedItem()).equals("Nature Domain") ) {
	                   int numbersubclasskills = occupation.getnumbersubskills();	
              	       ArrayList<String> possiblessubkilllist = occupation.possiblesubskillsCharacter(player, occupation.getsubclassskills());
                       String[] allsubskills2 = new String[possiblessubkilllist.size()];
                       for(int i = 0; i< possiblessubkilllist.size(); i++) {
                     	  allsubskills2[i] = possiblessubkilllist.get(i);
                       }
                       JPanel ClericsubSkillPanel1 = new JPanel();
                       JComboBox subskillList = new JComboBox(allsubskills2);//Half Elf
                       ClericsubSkillPanel1.add(subskillList);
                       JOptionPane.showConfirmDialog(null, ClericsubSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                       player.addskill((String) subskillList.getSelectedItem());
                 }
                 
                 //Choose a Cantrips
                 int cantripsknown = player.getcantripsknown();
                 for(int j = 1; j <= cantripsknown; j++ ) {
              	   JPanel ClericcantripPanel1 = new JPanel();
              	   ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);
  		   	       String[] options = new String[Cantripoptions.size()];
  	               for(int i = 0; i< Cantripoptions.size(); i++) {
  	            	   options[i] = Cantripoptions.get(i);
  	               }
  	               JComboBox cantripList = new JComboBox(options);
  	               ClericcantripPanel1.add(cantripList);
  	               JOptionPane.showConfirmDialog(null, ClericcantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
  	               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
  	   	       }
            }
        	
        	if("Druid".equals(charclass)){
            	
        		// Choose Skills
        		//Requirement (3.7.1.1.3) Choose Skills
        		int numberclasskills = occupation.getnumberskills();	
            	for (int y = 1; y <= numberclasskills; y++) {
            		
            		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
            		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
            		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
                     ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                     String[] allskills1 = new String[possibleskilllist.size()];
                     for(int i = 0; i< possibleskilllist.size(); i++) {
                     	allskills1[i] = possibleskilllist.get(i);
                     }
                     JPanel DruidSkillPanel1 = new JPanel();
                     JComboBox skillList = new JComboBox(allskills1);//Half Elf
                     DruidSkillPanel1.add(skillList);
                     
                   //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                     JOptionPane.showConfirmDialog(null, DruidSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                     player.addskill((String) skillList.getSelectedItem());
               
            	 }
            	
            	//Choose Equipment part 1
            	//(Requirement 3.7.1.1.4) Choose Equipment
            	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
            	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class

            	 ArrayList<String> newequip1 = occupation.getnewequip1();
            	 String[] allequip = new String[newequip1.size()];
            	 JPanel DruidEquipPanel1 = new JPanel();
                 for(int i = 0; i< newequip1.size(); i++) {
                  	allequip[i] = newequip1.get(i);
                 }
                 JComboBox skillList = new JComboBox(allequip);
                 DruidEquipPanel1.add(skillList);
     	
                 
               //Choose Equipment part 2
            	 ArrayList<String> newequip2 = occupation.getnewequip2();
            	 String[] allequip2 = new String[newequip2.size()];
                 for(int i = 0; i< newequip2.size(); i++) {
                  	allequip2[i] = newequip2.get(i);
                 }
                 JComboBox skillList2 = new JComboBox(allequip2);
                 DruidEquipPanel1.add(skillList2);
               //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
                 JOptionPane.showConfirmDialog(null, DruidEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
               //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
                 player.addEquip((String) skillList.getSelectedItem());
                 player.addEquip((String) skillList2.getSelectedItem());
            	
                                 
                 //Choose a Cantrips
               //(Requirements 3.7.1.1.2) Choose Cantrip Spells
                 int cantripsknown = player.getcantripsknown();
                 for(int j = 1; j <= cantripsknown; j++ ) {
              	   JPanel DruidcantripPanel1 = new JPanel();
              	   
              	   //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
             	   //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
             	  // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
              	   ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);;
  		   	       String[] options = new String[Cantripoptions.size()];
  	               for(int i = 0; i< Cantripoptions.size(); i++) {
  	            	   options[i] = Cantripoptions.get(i);
  	               }
  	               JComboBox cantripList = new JComboBox(options);
  	               DruidcantripPanel1.add(cantripList);
  	               JOptionPane.showConfirmDialog(null, DruidcantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
  	               
  	               //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
  	               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
  	   	       }
            }
        	
        	if("Fighter".equals(charclass)){
            	
        		// Choose Skills
        		//Requirement (3.7.1.1.3) Choose Skills
        		int numberclasskills = occupation.getnumberskills();	
            	for (int y = 1; y <= numberclasskills; y++) {
            		
            		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
            		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
            		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
                     ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                     String[] allskills1 = new String[possibleskilllist.size()];
                     for(int i = 0; i< possibleskilllist.size(); i++) {
                     	allskills1[i] = possibleskilllist.get(i);
                     }
                     JPanel FighterSkillPanel1 = new JPanel();
                     JComboBox skillList = new JComboBox(allskills1);//Half Elf
                     FighterSkillPanel1.add(skillList);
                     JOptionPane.showConfirmDialog(null, FighterSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                     
                   //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                     player.addskill((String) skillList.getSelectedItem());
               
            	 }
            	
        	//Choose Equipment part 1
			//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class

           	 ArrayList<String> newequip1 = occupation.getnewequip1();
           	 String[] allequip = new String[newequip1.size()];
           	 JPanel FighterEquipPanel1 = new JPanel();
             for(int i = 0; i< newequip1.size(); i++) {
                 	allequip[i] = newequip1.get(i);
             }
             JComboBox skillList = new JComboBox(allequip);
             FighterEquipPanel1.add(skillList);
    	
                
              //Choose Equipment part 2
           	ArrayList<String> newequip2 = occupation.getnewequip2();
           	String[] allequip2 = new String[newequip2.size()];
            for(int i = 0; i< newequip2.size(); i++) {
             	allequip2[i] = newequip2.get(i);
            }
            JComboBox skillList2 = new JComboBox(allequip2);
            FighterEquipPanel1.add(skillList2);
                
                
              //Choose Equipment part 3
           	 ArrayList<String> newequip3 = occupation.getnewequip3();
           	 String[] allequip3 = new String[newequip3.size()];
             for(int i = 0; i< newequip3.size(); i++) {
                 	allequip3[i] = newequip3.get(i);
             }
            JComboBox skillList3 = new JComboBox(allequip3);
            FighterEquipPanel1.add(skillList3);
                
              //Choose Equipment part 4
           	 ArrayList<String> newequip4 = occupation.getnewequip4();
           	 String[] allequip4 = new String[newequip4.size()];
             for(int i = 0; i< newequip4.size(); i++) {
               	 allequip4[i] = newequip4.get(i);
            }
            JComboBox skillList4 = new JComboBox(allequip4);
            FighterEquipPanel1.add(skillList4);
            
          //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
            JOptionPane.showConfirmDialog(null, FighterEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
            
          //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
            player.addEquip((String) skillList.getSelectedItem());
            player.addEquip((String) skillList2.getSelectedItem());
            player.addEquip((String) skillList3.getSelectedItem());
            player.addEquip((String) skillList4.getSelectedItem());
        
           //Add Specialty
            ArrayList<String> Fightingstyles = occupation.getfightingStyle();
            String[] allstyles = new String[Fightingstyles.size()];
        	for (int i = 0; i < Fightingstyles.size(); i++) { 
                allstyles[i] = Fightingstyles.get(i);
            }
             JPanel FighterStylePanel = new JPanel();
             JComboBox styleList = new JComboBox(allstyles);
             FighterStylePanel.add(styleList);
             JOptionPane.showConfirmDialog(null, FighterStylePanel, "Choose a Fighting Style for your Fighter", JOptionPane.OK_OPTION);
             occupation.GUIaddspecialty((String) styleList.getSelectedItem(), player);
	       }
        	
        if("Monk".equals(charclass)){
        	
    		// Choose Skills
        	//Requirement (3.7.1.1.3) Choose Skills
    		int numberclasskills = occupation.getnumberskills();	
        	for (int y = 1; y <= numberclasskills; y++) {
        		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
        		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
        		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
        		 ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                 String[] allskills1 = new String[possibleskilllist.size()];
                 for(int i = 0; i< possibleskilllist.size(); i++) {
                 	allskills1[i] = possibleskilllist.get(i);
                 }
                 JPanel MonkSkillPanel1 = new JPanel();
                 JComboBox skillList = new JComboBox(allskills1);//Half Elf
                 MonkSkillPanel1.add(skillList);
                 JOptionPane.showConfirmDialog(null, MonkSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                 
               //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                 player.addskill((String) skillList.getSelectedItem());
           
        	 }
        	
        	//Choose Equipment part 1
			//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class

        	 ArrayList<String> newequip1 = occupation.getnewequip1();
        	 String[] allequip = new String[newequip1.size()];
        	 JPanel MonkEquipPanel1 = new JPanel();
             for(int i = 0; i< newequip1.size(); i++) {
              	allequip[i] = newequip1.get(i);
             }
             JComboBox skillList = new JComboBox(allequip);
             MonkEquipPanel1.add(skillList);
 	
             
           //Choose Equipment part 2
        	 ArrayList<String> newequip2 = occupation.getnewequip2();
        	 String[] allequip2 = new String[newequip2.size()];
             for(int i = 0; i< newequip2.size(); i++) {
              	allequip2[i] = newequip2.get(i);
             }
             JComboBox skillList2 = new JComboBox(allequip2);
             MonkEquipPanel1.add(skillList2);
           //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
             JOptionPane.showConfirmDialog(null, MonkEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
           //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
             player.addEquip((String) skillList.getSelectedItem());
             player.addEquip((String) skillList2.getSelectedItem());
        	
        }
        
        if("Paladin".equals(charclass)){
        	
    		// Choose Skills
        	//Requirement (3.7.1.1.3) Choose Skills
    		int numberclasskills = occupation.getnumberskills();	
        	for (int y = 1; y <= numberclasskills; y++) {
        		
        		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
        		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
        		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
        		 ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                 String[] allskills1 = new String[possibleskilllist.size()];
                 for(int i = 0; i< possibleskilllist.size(); i++) {
                 	allskills1[i] = possibleskilllist.get(i);
                 }
                 JPanel PaladinSkillPanel1 = new JPanel();
                 JComboBox skillList = new JComboBox(allskills1);//Half Elf
                 PaladinSkillPanel1.add(skillList);

                 JOptionPane.showConfirmDialog(null, PaladinSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                 //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                 player.addskill((String) skillList.getSelectedItem());
           
        	 }
        	
        	//Choose Equipment part 1
        	//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class
        	 ArrayList<String> newequip1 = occupation.getnewequip1();
        	 String[] allequip = new String[newequip1.size()];
        	 JPanel PaladinEquipPanel1 = new JPanel();
             for(int i = 0; i< newequip1.size(); i++) {
              	allequip[i] = newequip1.get(i);
             }
             JComboBox skillList = new JComboBox(allequip);
             PaladinEquipPanel1.add(skillList);
 	
             
           //Choose Equipment part 2
        	 ArrayList<String> newequip2 = occupation.getnewequip2();
        	 String[] allequip2 = new String[newequip2.size()];
             for(int i = 0; i< newequip2.size(); i++) {
              	allequip2[i] = newequip2.get(i);
             }
             JComboBox skillList2 = new JComboBox(allequip2);
             PaladinEquipPanel1.add(skillList2);
             
             ArrayList<String> newequip3 = occupation.getnewequip3();
           	 String[] allequip3 = new String[newequip3.size()];
             for(int i = 0; i< newequip3.size(); i++) {
                 	allequip3[i] = newequip3.get(i);
             }
             JComboBox skillList3 = new JComboBox(allequip3);
             PaladinEquipPanel1.add(skillList3);
             
           //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
             JOptionPane.showConfirmDialog(null, PaladinEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
             
           //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
             player.addEquip((String) skillList.getSelectedItem());
             player.addEquip((String) skillList2.getSelectedItem());
             player.addEquip((String) skillList3.getSelectedItem());
             
             
            //Choose a Cantrips
           //(Requirements 3.7.1.1.2) Choose Cantrip Spells
             int cantripsknown = player.getcantripsknown();
             for(int j = 1; j <= cantripsknown; j++ ) {
          	 JPanel PaladincantripPanel1 = new JPanel();
          	 
            //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
       	     //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
       	     // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
          	 ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);;
   	         String[] options = new String[Cantripoptions.size()];
             for(int i = 0; i< Cantripoptions.size(); i++) {
        	     options[i] = Cantripoptions.get(i);
             }
             JComboBox cantripList = new JComboBox(options);
             PaladincantripPanel1.add(cantripList);
             JOptionPane.showConfirmDialog(null, PaladincantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
             
           //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
             occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
	   	     }
             
          }
        
        if("Ranger".equals(charclass)){
        	
    		// Choose Skills
        	//Requirement (3.7.1.1.3) Choose Skills
    		int numberclasskills = occupation.getnumberskills();	
        	for (int y = 1; y <= numberclasskills; y++) {
        		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
        		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
        		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
        		 ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                 String[] allskills1 = new String[possibleskilllist.size()];
                 for(int i = 0; i< possibleskilllist.size(); i++) {
                 	allskills1[i] = possibleskilllist.get(i);
                 }
                 JPanel RangerSkillPanel1 = new JPanel();
                 JComboBox skillList = new JComboBox(allskills1);//Half Elf
                 RangerSkillPanel1.add(skillList);
                 JOptionPane.showConfirmDialog(null, RangerSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
               //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                 player.addskill((String) skillList.getSelectedItem());
           
        	 }
	        	
        	//Choose Equipment part 1
			//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class

	       	 ArrayList<String> newequip1 = occupation.getnewequip1();
	       	 String[] allequip = new String[newequip1.size()];
	       	 JPanel RangerEquipPanel1 = new JPanel();
	         for(int i = 0; i< newequip1.size(); i++) {
	             	allequip[i] = newequip1.get(i);
	         }
	         JComboBox skillList = new JComboBox(allequip);
	         RangerEquipPanel1.add(skillList);
		
	            
	         //Choose Equipment part 2
	       	 ArrayList<String> newequip2 = occupation.getnewequip2();
	       	 String[] allequip2 = new String[newequip2.size()];
	            for(int i = 0; i< newequip2.size(); i++) {
	             	allequip2[i] = newequip2.get(i);
	            }
	            JComboBox skillList2 = new JComboBox(allequip2);
	            RangerEquipPanel1.add(skillList2);
	            
	            
	          //Choose Equipment part 3
	       	 ArrayList<String> newequip3 = occupation.getnewequip3();
	       	 String[] allequip3 = new String[newequip3.size()];
	         for(int i = 0; i< newequip3.size(); i++) {
	             	allequip3[i] = newequip3.get(i);
	         }
            JComboBox skillList3 = new JComboBox(allequip3);
            RangerEquipPanel1.add(skillList3);
            
          //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
            JOptionPane.showConfirmDialog(null, RangerEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
            
          //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
            player.addEquip((String) skillList.getSelectedItem());
            player.addEquip((String) skillList2.getSelectedItem());
            player.addEquip((String) skillList3.getSelectedItem());
        
           // Add Favored Enemy
           ArrayList<String> Enemies = occupation.possibleFavoredEnemies(player);
           String[] possibleenemies = new String[Enemies.size()];
      	   for (int i = 0; i < Enemies.size(); i++) { 
              possibleenemies[i] = Enemies.get(i);
      		}
           JPanel FavoredEnemyPanel = new JPanel();
           JComboBox enemyList = new JComboBox(possibleenemies);
           FavoredEnemyPanel.add(enemyList);
           JOptionPane.showConfirmDialog(null, FavoredEnemyPanel, "Choose a Favored Enemy for the Ranger", JOptionPane.OK_OPTION);
           occupation.Addfavoredenemy((String) enemyList.getSelectedItem(), player);
           
           //Choose lang of Favored Enemy
           String[] langs = player.possibleLang().toArray(new String[player.possibleLang().size()]);
           
           String EnemyLang = (String) JOptionPane.showInputDialog(elfHLangFrame, "Choose a Language Of Favored Enemy", "Ranger Favored Enemy", JOptionPane.QUESTION_MESSAGE, null, langs, langs[0]);
           
           player.addLang(EnemyLang);
           
           // Add Natural Explorer
           ArrayList<String> Terrain = occupation.possibleNaturalExplorer(player);
           String[] possibleterrain = new String[Terrain.size()];
      	   for (int i = 0; i < Terrain.size(); i++) { 
      		 possibleterrain[i] = Terrain.get(i);
      		}
           JPanel NaturalExplorerPanel = new JPanel();
           JComboBox TerrainList = new JComboBox(possibleterrain);
           NaturalExplorerPanel.add(TerrainList);
           JOptionPane.showConfirmDialog(null, NaturalExplorerPanel, "Choose a Natural Explorer for the Ranger", JOptionPane.OK_OPTION);
           occupation.AddNaturalExplorer((String) TerrainList.getSelectedItem(), player);
            
       }
       if("Rogue".equals(charclass)){
    	   //(Requirement 3.7.1.1.7.1.2.) The Expert pop up box will only appear to classes that have the expert skill available

    	    // Choose Skills
   			//Requirement (3.7.1.1.3) Choose Skills
    		int numberclasskills = occupation.getnumberskills();	
        	for (int y = 1; y <= numberclasskills; y++) {
                 
        		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
        		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
        		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
        		 ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                 String[] allskills1 = new String[possibleskilllist.size()];
                 for(int i = 0; i< possibleskilllist.size(); i++) {
                 	allskills1[i] = possibleskilllist.get(i);
                 }
                 JPanel RogueSkillPanel1 = new JPanel();
                 JComboBox skillList = new JComboBox(allskills1);//Half Elf
                 RogueSkillPanel1.add(skillList);
                 JOptionPane.showConfirmDialog(null, RogueSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
               //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                 player.addskill((String) skillList.getSelectedItem());
           
        	 }
        	
        	//Choose Equipment part 1
			//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class
        	 ArrayList<String> newequip1 = occupation.getnewequip1();
	       	 String[] allequip = new String[newequip1.size()];
	       	 JPanel RogueEquipPanel1 = new JPanel();
	         for(int i = 0; i< newequip1.size(); i++) {
	             	allequip[i] = newequip1.get(i);
	         }
	         JComboBox skillList = new JComboBox(allequip);
	         RogueEquipPanel1.add(skillList);
		
	            
	         //Choose Equipment part 2
	       	 ArrayList<String> newequip2 = occupation.getnewequip2();
	       	 String[] allequip2 = new String[newequip2.size()];
	            for(int i = 0; i< newequip2.size(); i++) {
	             	allequip2[i] = newequip2.get(i);
	            }
	            JComboBox skillList2 = new JComboBox(allequip2);
	            RogueEquipPanel1.add(skillList2);
	            
	            
	          //Choose Equipment part 3
	       	 ArrayList<String> newequip3 = occupation.getnewequip3();
	       	 String[] allequip3 = new String[newequip3.size()];
	         for(int i = 0; i< newequip3.size(); i++) {
	             	allequip3[i] = newequip3.get(i);
	         }
            JComboBox skillList3 = new JComboBox(allequip3);
            RogueEquipPanel1.add(skillList3);
            
          //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
            JOptionPane.showConfirmDialog(null, RogueEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
            
          //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
            player.addEquip((String) skillList.getSelectedItem());
            player.addEquip((String) skillList2.getSelectedItem());
            player.addEquip((String) skillList3.getSelectedItem());
            
          //get Expert skill
           //(Requirement 3.7.1.1.7) Choose Expert Skills 
            for(int y = 0; y < 2; y++) {
            	//(Requirement 3.7.1.1.7.1.)   The expert skill choice pop up box will be pre-populated with ONLY skills the character already knows and is not an expert in
            	//(Requirement 3.7.1.1.7.1.1.)  This list will be formed from a list of possible skills where applicable to the class that the character already knows
	            //(Requirement 3.7.1.1.7.3.)   The next expert skills pop up box will not have the expert skills previously chosen
            	ArrayList<String> rogueexpert = occupation.possibleExpertskillsCharacter(player);
	       	    JPanel RogueExpertPanel1 = new JPanel();
	       	    String[] Expert = new String[rogueexpert.size()];
	            for(int i = 0; i< rogueexpert.size(); i++) {
	           	Expert[i] = rogueexpert.get(i);
	            }
	            JComboBox newexpertRogue = new JComboBox(Expert);
	            RogueExpertPanel1.add(newexpertRogue);
	            JOptionPane.showConfirmDialog(null, RogueExpertPanel1, "Choose a Skill to Make Expert:", JOptionPane.OK_OPTION);
	            //Requirement  3.7.1.1.7.2.   The chosen skills will
	            //Requirement 3.7.1.1.7.2.1.          have one added to the character�s skill variable
	            //Requirement 3.7.1.1.7.2.2.          remove the previous skill from weapons and armor proficiency list
            	//Requirement 3.7.1.1.7.2.3.          weapons and armor proficiency list with an expert tag
	            player.setExpert((String) newexpertRogue.getSelectedItem());
	            
            }
       } 	
       
        if("Sorcerer".equals(charclass)){
       	
            // Choose Skills
            //Requirement (3.7.1.1.3) Choose Skills
            int numberclasskills = occupation.getnumberskills();	
            for (int y = 1; y <= numberclasskills; y++) {
                //(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
                //(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
                // (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
                ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                String[] allskills2 = new String[possibleskilllist.size()];
                for(int i = 0; i< possibleskilllist.size(); i++) {
                    allskills2[i] = possibleskilllist.get(i);
                }
                JPanel SorcererSkillPanel1 = new JPanel();
                JComboBox skillList = new JComboBox(allskills2);
                SorcererSkillPanel1.add(skillList);
                JOptionPane.showConfirmDialog(null, SorcererSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);

                //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                player.addskill((String) skillList.getSelectedItem());


             }

            //Choose Equipment part 1
            //(Requirement 3.7.1.1.4)       Choose Equipment
            //(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
            //(Requirements 3.7.1.1.4.1.1.) This list will be formed from a list of possible equipment where applicable class
            ArrayList<String> newequip1 = occupation.getnewequip1();
            String[] allequip = new String[newequip1.size()];
            JPanel SorcererEquipPanel1 = new JPanel();
            for(int i = 0; i< newequip1.size(); i++) {
             	allequip[i] = newequip1.get(i);
            }
            JComboBox skillList = new JComboBox(allequip);
            SorcererEquipPanel1.add(skillList);
	
            
            //Choose Equipment part 2
            ArrayList<String> newequip2 = occupation.getnewequip2();
            String[] allequip2 = new String[newequip2.size()];
            for(int i = 0; i< newequip2.size(); i++) {
             	allequip2[i] = newequip2.get(i);
            }
            JComboBox skillList2 = new JComboBox(allequip2);
            SorcererEquipPanel1.add(skillList2);
            
            
          //Choose Equipment part 3
       	 	ArrayList<String> newequip3 = occupation.getnewequip3();
       	 	String[] allequip3 = new String[newequip3.size()];
            for(int i = 0; i< newequip3.size(); i++) {
             	allequip3[i] = newequip3.get(i);
            }
            JComboBox skillList3 = new JComboBox(allequip3);
            SorcererEquipPanel1.add(skillList3);
            
          //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
            JOptionPane.showConfirmDialog(null, SorcererEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
          
            //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
            player.addEquip((String) skillList.getSelectedItem());
            player.addEquip((String) skillList2.getSelectedItem());
            player.addEquip((String) skillList3.getSelectedItem());
            
          //Choose a Cantrips
          //(Requirements 3.7.1.1.2) Choose Cantrip Spells
            int cantripsknown = player.getcantripsknown();
            for(int j = 1; j <= cantripsknown; j++ ) {
         	   JPanel SorcerercantripPanel1 = new JPanel();
         	   
         	  //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
         	  //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
         	  // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
         	   ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);;
	   	       String[] options = new String[Cantripoptions.size()];
	           for(int i = 0; i< Cantripoptions.size(); i++) {
	          	   options[i] = Cantripoptions.get(i);
	           }
               JComboBox cantripList = new JComboBox(options);
               SorcerercantripPanel1.add(cantripList);
               JOptionPane.showConfirmDialog(null, SorcerercantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
               
               //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
	   	    }
            
            
          //Choose a Subclass info
            //(Requirement 3.7.1.1.5) Choose a Subclass

            //(Requirement 3.7.1.1.5.1.) The subclass choice pop up box will be pre-populated with ONLY possible subclasses available to the class
	       	ArrayList<String> subclasslist = occupation.getdomainoptions();
	       	JPanel SorcerersubclassPanel1 = new JPanel();
	       	String[] domain = new String[subclasslist.size()];
            for(int i = 0; i< subclasslist.size(); i++) {
           	 domain[i] = subclasslist.get(i);
            }
            JComboBox newsubclass = new JComboBox(domain);
            SorcerersubclassPanel1.add(newsubclass);
            JOptionPane.showConfirmDialog(null, SorcerersubclassPanel1, "Choose a Sorcererous Origin for your Sorcerer:", JOptionPane.OK_OPTION);
           
            //(Requirements 3.7.1.1.5.2.)   The chosen subclass will be added to the characters subclass variable
            player.setSubClass((String) newsubclass.getSelectedItem());
            occupation.GUIsubclassinfo(player);
            
          //Requirement 3.7.1.1.6.) Subclass choices
            if(((String) newsubclass.getSelectedItem()).equals("Draconic Bloodline")) {
           	 
            	//(Requirement 3.7.1.1.6.1.)   The subclass choice pop up box will be pre-populated with ONLY information that pertains to a certain subclass and the character does not know.
        		//(Requirement 3.7.1.1.6.1.1.) This list will be formed from a list of possible subclass values.
        		//(Requirement 3.7.1.1.6.2.1.1) If applicable, the next subclass pop up box will not have the values previously chosen
	            String[] breaths = {"Black", "Blue", "Brass", "Bronze", "Copper", "Gold", "Green", "Red", "Silver", "White"};
        		String dragonColor = (String) JOptionPane.showInputDialog(breathFrame, "Choose a color...", "Dragon Ancestor ", JOptionPane.QUESTION_MESSAGE, null, breaths, breaths[0]);
        		
        		//(Requirement 3.7.1.1.6.2.   The chosen subclass choice will be added to the correct location in the character.)
                player.checkandAddasubclassability("Dragon Ancestor " + dragonColor);
           	 }
            
        }
        
       if("Warlock".equals(charclass)){
          	
    	    // Choose Skills
   		    //Requirement (3.7.1.1.3) Choose Skills
      		int numberclasskills = occupation.getnumberskills();	
          	for (int y = 1; y <= numberclasskills; y++) {
          	    
          		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
        		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
        		// (Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
        	   ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
               String[] allskills2 = new String[possibleskilllist.size()];
               for(int i = 0; i< possibleskilllist.size(); i++) {
               	allskills2[i] = possibleskilllist.get(i);
               }
               JPanel WarlockSkillPanel1 = new JPanel();
               JComboBox skillList = new JComboBox(allskills2);//Half Elf
               WarlockSkillPanel1.add(skillList);
               JOptionPane.showConfirmDialog(null, WarlockSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
               
             //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
               player.addskill((String) skillList.getSelectedItem());
    
             
          	 }
          	
            //Choose Equipment part 1
			//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class
          	ArrayList<String> newequip1 = occupation.getnewequip1();
          	 String[] allequip = new String[newequip1.size()];
          	 JPanel WarlockEquipPanel1 = new JPanel();
               for(int i = 0; i< newequip1.size(); i++) {
                	allequip[i] = newequip1.get(i);
               }
               JComboBox skillList = new JComboBox(allequip);
               WarlockEquipPanel1.add(skillList);
   	
               
             //Choose Equipment part 2
          	 ArrayList<String> newequip2 = occupation.getnewequip2();
          	 String[] allequip2 = new String[newequip2.size()];
               for(int i = 0; i< newequip2.size(); i++) {
                	allequip2[i] = newequip2.get(i);
               }
               JComboBox skillList2 = new JComboBox(allequip2);
               WarlockEquipPanel1.add(skillList2);
               
               
                //Choose Equipment part 3
                        ArrayList<String> newequip3 = occupation.getnewequip3();
                        String[] allequip3 = new String[newequip3.size()];
                for(int i = 0; i< newequip3.size(); i++) {
                        allequip3[i] = newequip3.get(i);
                }
                JComboBox skillList3 = new JComboBox(allequip3);
                WarlockEquipPanel1.add(skillList3);
               
             //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class
                JOptionPane.showConfirmDialog(null, WarlockEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
               
             //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
                player.addEquip((String) skillList.getSelectedItem());
                player.addEquip((String) skillList2.getSelectedItem());
                player.addEquip((String) skillList3.getSelectedItem());
               
             //Choose a Cantrips
             //(Requirements 3.7.1.1.2) Choose Cantrip Spells

                int cantripsknown = player.getcantripsknown();
                for(int j = 1; j <= cantripsknown; j++ ) {
            	    JPanel WarlockcantripPanel1 = new JPanel();
            	   
            	  //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
             	  //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
             	    // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
             	    ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);;
                    String[] options = new String[Cantripoptions.size()];
                    for(int i = 0; i< Cantripoptions.size(); i++) {
                        options[i] = Cantripoptions.get(i);
                    }
                    JComboBox cantripList = new JComboBox(options);
                    WarlockcantripPanel1.add(cantripList);
                    JOptionPane.showConfirmDialog(null, WarlockcantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
	               
	             //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
	               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
	   	       }
	   	 
	   	       
               //Choose a Subclass info
               //(Requirement 3.7.1.1.5) Choose a Subclass

               //(Requirement 3.7.1.1.5.1.) The subclass choice pop up box will be pre-populated with ONLY possible subclasses available to the class
               ArrayList<String> subclasslist = occupation.getdomainoptions();
               JPanel WarlocksubclassPanel1 = new JPanel();
               String[] domain = new String[subclasslist.size()];
               for(int i = 0; i< subclasslist.size(); i++) {
              	 domain[i] = subclasslist.get(i);
               }
               JComboBox newsubclass = new JComboBox(domain);
               WarlocksubclassPanel1.add(newsubclass);
               JOptionPane.showConfirmDialog(null, WarlocksubclassPanel1, "Choose an Otherworldly Patron:", JOptionPane.OK_OPTION);
             
               //(Requirements 3.7.1.1.5.2.)   The chosen subclass will be added to the characters subclass variable
               player.setSubClass((String) newsubclass.getSelectedItem());
               occupation.GUIsubclassinfo(player);    
          } 
       
        if("Wizard".equals(charclass)){
        	
        	// Choose Skills
    		//Requirement (3.7.1.1.3) Choose Skills
    		int numberclasskills = occupation.getnumberskills();	
        	for (int y = 1; y <= numberclasskills; y++) {
        		
        		//(Requirement 3.7.1.1.3.1) The skill choice pop up box will be pre-populated with ONLY skills the character does not know
        		//(Requirement 3.7.1.1.3.2.) This list will be formed from a list of possible skills where applicable to the race or class
        		//(Requirement 3.7.1.1.3.4.) The next skills pop up box will not have the skills previously chosen
        		 ArrayList<String> possibleskilllist = occupation.possibleskillsCharacter(player);
                 String[] allskills1 = new String[possibleskilllist.size()];
                 for(int i = 0; i< possibleskilllist.size(); i++) {
                 	allskills1[i] = possibleskilllist.get(i);
                 }
                 JPanel WizardSkillPanel1 = new JPanel();
                 JComboBox skillList = new JComboBox(allskills1);//Half Elf
                 WizardSkillPanel1.add(skillList);
                 JOptionPane.showConfirmDialog(null, WizardSkillPanel1, "Choose a Skill to Increase by 1", JOptionPane.OK_OPTION);
                 
               //(Requirement 3.7.1.1.3.3.   The chosen skills will have one added to the character�s skill variable and weapons and armor proficiency list)
                 player.addskill((String) skillList.getSelectedItem());
           
        	 }
        	
        	//Choose Equipment part 1
			//(Requirement 3.7.1.1.4) Choose Equipment
        	//(Requirements 3.7.1.1.4.1.)   The equipment choice pop up box will be pre-populated with ONLY equipment available to the character
        	//(Requirements 3.7.1.1.4.1.1.)          This list will be formed from a list of possible equipment where applicable class
        	 ArrayList<String> newequip1 = occupation.getnewequip1();
        	 String[] allequip = new String[newequip1.size()];
        	 JPanel WizardEquipPanel1 = new JPanel();
             for(int i = 0; i< newequip1.size(); i++) {
              	allequip[i] = newequip1.get(i);
             }
             JComboBox skillList = new JComboBox(allequip);
             WizardEquipPanel1.add(skillList);
 	
             
            //Choose Equipment part 2
        	 ArrayList<String> newequip2 = occupation.getnewequip2();
        	 String[] allequip2 = new String[newequip2.size()];
             for(int i = 0; i< newequip2.size(); i++) {
              	allequip2[i] = newequip2.get(i);
             }
             JComboBox skillList2 = new JComboBox(allequip2);
             WizardEquipPanel1.add(skillList2);
                          
             //Choose Equipment part 3
          	 	ArrayList<String> newequip3 = occupation.getnewequip3();
          	 	String[] allequip3 = new String[newequip3.size()];
               for(int i = 0; i< newequip3.size(); i++) {
                	allequip3[i] = newequip3.get(i);
               }
               JComboBox skillList3 = new JComboBox(allequip3);
               WizardEquipPanel1.add(skillList3);
             
             //(Requirement 3.7.1.1.4.1.2.)    The pop up box will display all available equipment at the same time to applicable class  
             JOptionPane.showConfirmDialog(null, WizardEquipPanel1, "Choose a Piece of Equipment:", JOptionPane.OK_OPTION);
             
           //(Requirement 3.7.1.1.4.2.)   The chosen equipment will be added to the characters known equipment  list
             player.addEquip((String) skillList.getSelectedItem());
             player.addEquip((String) skillList2.getSelectedItem());
             player.addEquip((String) skillList3.getSelectedItem());
             
           //Choose Cantrips
           //(Requirements 3.7.1.1.2) Choose Cantrip Spells
             int cantripsknown = player.getcantripsknown();
             for(int j = 1; j <= cantripsknown; j++ ) {
          	   JPanel WizardcantripPanel1 = new JPanel();
          	
          	   //(Requirements 3.7.1.1.2.1)  The cantrip choice pop up box will be pre-populated with only cantrips spells  the character does not know.
         	   //AND (Requirement 3.7.1.1.2.1.1.)          This list will be formed from a list of possible cantrip spells where applicable to the race or class
         	  // AND (Requirement 3.7.1.1.2.3) The next cantrip pop up box will not have the cantrip previously chosen
         	   ArrayList<String> Cantripoptions = occupation.possiblespellsCharacter(player, occupation.getpossiblecantrips(), 0);
	   	       String[] options = new String[Cantripoptions.size()];
               for(int i = 0; i< Cantripoptions.size(); i++) {
            	   options[i] = Cantripoptions.get(i);
               }
               JComboBox cantripList = new JComboBox(options);
               WizardcantripPanel1.add(cantripList);
               JOptionPane.showConfirmDialog(null, WizardcantripPanel1, "Choose a Cantrip:", JOptionPane.OK_OPTION);
               
             //(Requirements 3.7.1.1.2.2.)   The chosen cantrip will be added to the characters known cantrip spells list
               occupation.addnewSpell(player, (String) cantripList.getSelectedItem(), 0);
   	       }
             
             
        }
        
        //Calc values for new players
        //(Requirement 3.8.)    The program will calculate all values for the character
        //(Requirement 3.8.1.) The program will only calculate the values based on the correct formula for class, subclass and ability scores
        //(Requirement 3.8.2.) The value will be placed in the correct variable
        String[] ablilitymod = player.calcabilitymod();
        player.calcSkillmods();
        player.calcinitiative();
       
        //(Requirement 3.9.)    Graphical User interface is refreshed.
        //Show new ability point values
        str_score.setText(Integer.toString(player.getstr()));
        dex_score.setText(Integer.toString(player.getDex()));
        con_score.setText(Integer.toString(player.getcon()));
        int_score.setText(Integer.toString(player.getintel()));
        wis_score.setText(Integer.toString(player.getwis()));
        cha_score.setText(Integer.toString(player.getchar()));
        
        //Set ability mods
	   	str_mod.setText(ablilitymod[0]);
	    dex_mod.setText(ablilitymod[1]);
	    con_mod.setText(ablilitymod[2]);
	    int_mod.setText(ablilitymod[3]);
	    wis_mod.setText(ablilitymod[4]);
	    cha_mod.setText(ablilitymod[5]);

        //Show skills
        occupation.recalcClassmods(player);
        acroField.setText((player.displaymods(player.getAcromod())));
        animField.setText(player.displaymods(player.getAnimalmod()));
        arcaField.setText(player.displaymods(player.getArcanamod()));
        athlField.setText(player.displaymods(player.getAthleticsmod()));
        deceField.setText(player.displaymods(player.getDeceptionsmod()));
        histField.setText(player.displaymods(player.getHistorymod()));
        insiField.setText(player.displaymods(player.getInsightmod()));
        intiField.setText(player.displaymods(player.getIntimidatemod()));
        inveField.setText(player.displaymods(player.getInvestigatemod()));
        mediField.setText(player.displaymods(player.getMedicinemod()));
        natuField.setText(player.displaymods(player.getNaturemod()));
        percField.setText(player.displaymods(player.getPerceptionmod()));
        perfField.setText(player.displaymods(player.getPerformancenmod()));
        persField.setText(player.displaymods(player.getPersuasionmod()));
        reliField.setText(player.displaymods(player.getReligionmod()));
        sleiField.setText(player.displaymods(player.getSleightHandmod()));
        steaField.setText(player.displaymods(player.getStealthmod()));
        survField.setText(player.displaymods(player.getSurvivalmod()));
        
        // set health and other variables
        hp_current.setText(Integer.toString(player.gethitpoint()));
        hp_max.setText(Integer.toString(player.gethitpoint()));
        armorClass.setText(Integer.toString(player.getTotalAC()));
        initiative.setText(player.getinitiative()); 
        speed.setText(Integer.toString(player.getSpeed()));
        profField.setText(Integer.toString(player.getProfiencyBonus()));
        exp.setText(Integer.toString(player.getexp()));
        subclassBox.setText(player.getSubClass());
                
        //Set spell variables
        spellSaveBox.setText(player.getSpellSaveDC());
        spellModBox.setText(player.getSpellattackmod());
        spellAbilBox.setText(player.getSpellability());
        
        //Set number of max spells a player can have
        int numbspellslvl[] = player.getnumberspellsLevel();
        level1TotalBox.setText(Integer.toString(numbspellslvl[0]));
        level2TotalBox.setText(Integer.toString(numbspellslvl[1]));
        level3TotalBox.setText(Integer.toString(numbspellslvl[2]));
        level4TotalBox.setText(Integer.toString(numbspellslvl[3]));
        level5TotalBox.setText(Integer.toString(numbspellslvl[4]));
        level6TotalBox.setText(Integer.toString(numbspellslvl[5]));
        level7TotalBox.setText(Integer.toString(numbspellslvl[6]));
        level8TotalBox.setText(Integer.toString(numbspellslvl[7]));
        level9TotalBox.setText(Integer.toString(numbspellslvl[8]));
        
      //Set number of spells a player has left
        player.rechargenumberspellsleft();
        int numbspellslvlleft[] = player.getnumberspellsLevelleft();
        level1CastBox.setText(Integer.toString(numbspellslvl[0]));
        level2CastBox.setText(Integer.toString(numbspellslvl[1]));
        level3CastBox.setText(Integer.toString(numbspellslvl[2]));
        level4CastBox.setText(Integer.toString(numbspellslvl[3]));
        level5CastBox.setText(Integer.toString(numbspellslvl[4]));
        level6CastBox.setText(Integer.toString(numbspellslvl[5]));
        level7CastBox.setText(Integer.toString(numbspellslvl[6]));
        level8CastBox.setText(Integer.toString(numbspellslvl[7]));
        level9CastBox.setText(Integer.toString(numbspellslvl[8]));
        
      //Set currency user has
        cpBox.setText(Integer.toString(player.getcopper()));
        spBox.setText(Integer.toString(player.getsilver()));
        epBox.setText(Integer.toString(player.getep()));
        gpBox.setText(Integer.toString(player.getgold()));
        ppBox.setText(Integer.toString(player.getpp()));
        
        }
                    
    }
    
    private class NameListener implements ActionListener{

        @Override
        //(Requirement 3.4) User shall enter name for character
        public void actionPerformed(ActionEvent e) {
            
            charname = getName();
            nameentered = true;
            
        }
        
    }
    
    @Override
    public String getName(){
        String characterName;
        characterName = name.getText();
        return characterName;
    }
    

public class ClearMethods{
    public void clearAllAreas(){
    	//(Requirement 8.1.1.2) All fields in the user interface are cleared. 
        item_area.setText("");
        info_area.setText("");
        rfeature_area.setText("");
        cfeature_area.setText("");
        language_area.setText("");
        proficiency_area.setText("");
        cantripTextArea.setText("");
        otherSpellTextArea.setText("");
        level1TextArea.setText("");
        level2TextArea.setText("");
        level3TextArea.setText("");
        level4TextArea.setText("");
        level5TextArea.setText("");
        level6TextArea.setText("");
        level7TextArea.setText("");
        level8TextArea.setText("");
        level9TextArea.setText("");
        hp_max.setText("");
    }
    
    public void refreshAllAreas(){
    	  // Clear EVERYTHING 
    	
        ClearMethods clear = new ClearMethods();
        clear.clearAllAreas(); 
        
        //Recalculate all values for the character
        // (Requirement 8.1.1.2.2) All character values calculated
        String[] ablilitymod = player.calcabilitymod(); 
        int[] savingthrows = player.recalcsavingthrows();
        player.calcSkillmods();
        if (player.getlevel() > 1) {
     	   occupation.recalcClassmodsabovelvl1(player);   
         } else {
         	occupation.recalcClassmods(player); //(Requirement 8.1.1.2.3) Recharge values that can be depleted
         }
        player.calcinitiative();
        player.settotalAC();
        int numbspellslvl[] = player.getnumberspellsLevel();
        player.rechargenumberspellsleft(); //(Requirement 8.1.1.2.3) Recharge values that can be depleted
        int numbspellslvlleft[] = player.getnumberspellsLevelleft();
        
        
        //(Requirement 8.1.1.2.4) Display most current values for character to the user interface
        //player show chararcteristics
        name.setText(player.getName());
        ageBox.setText(Integer.toString(player.getage()));
        heightBox.setText(player.getheight());
        weightBox.setText(player.getweight());
        sizeBox.setText(player.getsize());
        eyesBox.setText(player.geteyes());  //(Requirement 11.1.1.2.1) Eyes  color remains after refresh
        hairBox.setText(player.gethair()); //(Requirement 11.1.1.2.1) Hair color remains after refresh
        info_area.setText(player.getinfo());
        
     //Attempt to change saving throws checkboxes
		if(player.getCharClass() == "Monk" && player.getFeats().contains("Diamond Soul")) {
			strSaveProf.setSelected(true);
            dexSaveProf.setSelected(true);
            conSaveProf.setSelected(true);
            intSaveProf.setSelected(true);
            wisSaveProf.setSelected(true);
            chaSaveProf.setSelected(true);
		}
        
        
        //Show new ability point values
        str_score.setText(Integer.toString(player.getstr()));
        dex_score.setText(Integer.toString(player.getDex()));
        con_score.setText(Integer.toString(player.getcon()));
        int_score.setText(Integer.toString(player.getintel()));
        wis_score.setText(Integer.toString(player.getwis()));
        cha_score.setText(Integer.toString(player.getchar()));
        
        //Set ability mods
	   	str_mod.setText(ablilitymod[0]);
	    dex_mod.setText(ablilitymod[1]);
	    con_mod.setText(ablilitymod[2]);
	    int_mod.setText(ablilitymod[3]);
	    wis_mod.setText(ablilitymod[4]);
	    cha_mod.setText(ablilitymod[5]);

	    //Set ability saves
	    str_save.setText(Integer.toString(savingthrows[0]));
	    dex_save.setText(Integer.toString(savingthrows[1]));
	    con_save.setText(Integer.toString(savingthrows[2]));
	    int_save.setText(Integer.toString(savingthrows[3]));
	    wis_save.setText(Integer.toString(savingthrows[4]));
	    cha_save.setText(Integer.toString(savingthrows[5]));
	    
        //Show skills
        hitDice.setText(player.gethitdice());
        acroField.setText((player.displaymods(player.getAcromod())));
        animField.setText(player.displaymods(player.getAnimalmod()));
        arcaField.setText(player.displaymods(player.getArcanamod()));
        athlField.setText(player.displaymods(player.getAthleticsmod()));
        deceField.setText(player.displaymods(player.getDeceptionsmod()));
        histField.setText(player.displaymods(player.getHistorymod()));
        insiField.setText(player.displaymods(player.getInsightmod()));
        intiField.setText(player.displaymods(player.getIntimidatemod()));
        inveField.setText(player.displaymods(player.getInvestigatemod()));
        mediField.setText(player.displaymods(player.getMedicinemod()));
        natuField.setText(player.displaymods(player.getNaturemod()));
        percField.setText(player.displaymods(player.getPerceptionmod()));
        perfField.setText(player.displaymods(player.getPerformancenmod()));
        persField.setText(player.displaymods(player.getPersuasionmod()));
        reliField.setText(player.displaymods(player.getReligionmod()));
        sleiField.setText(player.displaymods(player.getSleightHandmod()));
        steaField.setText(player.displaymods(player.getStealthmod()));
        survField.setText(player.displaymods(player.getSurvivalmod()));
        
        // set health and other variables
        hp_current.setText(Integer.toString(player.getcurrenthitpoint()));
        hp_max.setText(Integer.toString(player.gethitpoint()));
        armorClass.setText(Integer.toString(player.getTotalAC()));
        initiative.setText(player.getinitiative()); 
        speed.setText(Integer.toString(player.getSpeed()));
        profField.setText(Integer.toString(player.getProfiencyBonus()));
        exp.setText(Integer.toString(player.getexp()));
        warlockLeftBox.setText(Integer.toString(player.getspellslotsLeft()));
        warlockTotalBox.setText(Integer.toString(player.getspellslots()));
        kiLeftBox.setText(Integer.toString(player.getKipointsleft()));
        kiTotalBox.setText(Integer.toString(player.getKipoints()));
        sorceryLeftBox.setText(Integer.toString(player.getSorcerypointsleft()));
        sorceryTotalBox.setText(Integer.toString(player.getSorcerypoints()));
        subclassBox.setText(player.getSubClass());
       
                
        //Set spell variables
        spellSaveBox.setText(player.getSpellSaveDC());
        spellModBox.setText(player.getSpellattackmod());
        spellAbilBox.setText(player.getSpellability());
       
      //Weapon display info 
        weaponName1.setText(player.getweaponname(0));
        weaponAtk1.setText(player.getweaponattackbonus(0));
        weaponDmg1.setText(player.getweapondamage(0));
        weaponType1.setText(player.getweapontype(0));
        weaponName2.setText(player.getweaponname(1));
        weaponAtk2.setText(player.getweaponattackbonus(1));;
        weaponDmg2.setText(player.getweapondamage(1));
        weaponType2.setText(player.getweapondamage(1));
        weaponName3.setText(player.getweaponname(2));
        weaponAtk3.setText(player.getweaponattackbonus(2));;
        weaponDmg3.setText(player.getweapondamage(2));;
        weaponType3.setText(player.getweapondamage(2)); 
        
       //Armor display info
        armorName1.setText(player.getarmorname());
        armorAC1.setText(Integer.toString(player.getarmorAC()));
        armorMagic1.setText(Integer.toString(player.getarmorbonus()));
        shield.setSelected(player.getshieldboolean());
        
        //Set number of max spells a player can have
        level1TotalBox.setText(Integer.toString(numbspellslvl[0]));
        level2TotalBox.setText(Integer.toString(numbspellslvl[1]));
        level3TotalBox.setText(Integer.toString(numbspellslvl[2]));
        level4TotalBox.setText(Integer.toString(numbspellslvl[3]));
        level5TotalBox.setText(Integer.toString(numbspellslvl[4]));
        level6TotalBox.setText(Integer.toString(numbspellslvl[5]));
        level7TotalBox.setText(Integer.toString(numbspellslvl[6]));
        level8TotalBox.setText(Integer.toString(numbspellslvl[7]));
        level9TotalBox.setText(Integer.toString(numbspellslvl[8]));
        
      //Set number of spells a player has left
        level1CastBox.setText(Integer.toString(numbspellslvl[0]));
        level2CastBox.setText(Integer.toString(numbspellslvl[1]));
        level3CastBox.setText(Integer.toString(numbspellslvl[2]));
        level4CastBox.setText(Integer.toString(numbspellslvl[3]));
        level5CastBox.setText(Integer.toString(numbspellslvl[4]));
        level6CastBox.setText(Integer.toString(numbspellslvl[5]));
        level7CastBox.setText(Integer.toString(numbspellslvl[6]));
        level8CastBox.setText(Integer.toString(numbspellslvl[7]));
        level9CastBox.setText(Integer.toString(numbspellslvl[8]));
        
      //Set currency user has
        cpBox.setText(Integer.toString(player.getcopper()));
        spBox.setText(Integer.toString(player.getsilver()));
        epBox.setText(Integer.toString(player.getep()));
        gpBox.setText(Integer.toString(player.getgold()));
        ppBox.setText(Integer.toString(player.getpp()));
        
        //Set text boxes on second tab
        String[] langarray = player.StringarrayLang();
        for (int i = 0; i < langarray.length; i++) {
        	language_area.append(langarray[i] + "\n" );
        }
        
        String[] itemarray = player.StringarrayEquip();
        for (int i = 0; i < itemarray.length; i++) {
        	item_area.append(itemarray[i] + "\n" );
        }
        
        String[] proarray = player.StringarrayArmorandWeaponsProf();
        for (int i = 0; i < proarray.length; i++) {
        	proficiency_area.append(proarray[i] + "\n" );
        }
        
        
        String[] featarray = player.StringarrayFeat();
        for (int i = 0; i < featarray.length; i++) {
        	rfeature_area.append(featarray[i] + "\n" );
        }
   
        String[] subfeatarray = player.StringarraySubclassability();
        for (int i = 0; i < subfeatarray.length; i++) {
        	cfeature_area.append(subfeatarray[i] + "\n" );
        }
        
        String[] Cantripspells = player.StringarrayCantrips();
        for (int i = 0; i < Cantripspells.length; i++) {
        	cantripTextArea.append(Cantripspells[i] + "\n" );
        }
        
        String[] racespells = player.Stringarrayracespells();
        for (int i = 0; i < racespells.length; i++) {
        	otherSpellTextArea.append(racespells[i] + "\n" );
        }
  
        String[] lvl1spells = player.Stringarraylvl1spells();
        for (int i = 0; i < lvl1spells.length; i++) {
        	level1TextArea.append(lvl1spells[i] + "\n" );
        }
        
        String[] lvl2spells = player.Stringarraylvl2spells();
        for (int i = 0; i < lvl2spells.length; i++) {
        	level2TextArea.append(lvl2spells[i] + "\n" );
        }
        
        String[] lvl3spells = player.Stringarraylvl3spells();
        for (int i = 0; i < lvl3spells.length; i++) {
        	level3TextArea.append(lvl3spells[i] + "\n" );
        }
        
        String[] lvl4spells = player.Stringarraylvl4spells();
        for (int i = 0; i < lvl4spells.length; i++) {
        	level4TextArea.append(lvl4spells[i] + "\n" );
        }
        
        String[] lvl5spells = player.Stringarraylvl5spells();
        for (int i = 0; i < lvl5spells.length; i++) {
        	level5TextArea.append(lvl5spells[i] + "\n" );
        }
        
        String[] lvl6spells = player.Stringarraylvl6spells();
        for (int i = 0; i < lvl6spells.length; i++) {
        	level6TextArea.append(lvl6spells[i] + "\n" );
        }
        
        String[] lvl7spells = player.Stringarraylvl7spells();
        for (int i = 0; i < lvl7spells.length; i++) {
        	level7TextArea.append(lvl7spells[i] + "\n" );
        }
        
        String[] lvl8spells = player.Stringarraylvl8spells();
        for (int i = 0; i < lvl8spells.length; i++) {
        	level8TextArea.append(lvl8spells[i] + "\n" );
        }
        
        String[] lvl9spells = player.Stringarraylvl9spells();
        for (int i = 0; i < lvl9spells.length; i++) {
        	level9TextArea.append(lvl9spells[i] + "\n" );
        }
    }
}

public class AddItem implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addItemButton){
            String itemToAdd = itemBox.getText();
            //Add Item to Back End Item List
            player.addEquip(itemToAdd);
            
            //Reprint Entries in the Text Area
            item_area.setText("");
            String[] itemsArray = player.StringarrayEquip();
            for (int i = 0; i < itemsArray.length; i++) {
                    item_area.append(itemsArray[i] + "\n" );
            }
            itemBox.setText("");
        }
    }
}

public class RemoveItem implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == removeItemButton){
            String itemToRemove = itemBox.getText();
            //Remove Item from Back End Item List
            player.removeEquip(itemToRemove);
            
            //Reprint Entries in the Text Area
            item_area.setText("");
            String[] itemsArray = player.StringarrayEquip();
            for (int i = 0; i < itemsArray.length; i++) {
                    item_area.append(itemsArray[i] + "\n" );
            }
            itemBox.setText("");
        }
    }
}

public class AddLangListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addLangButton){
            String langToAdd = langAddRemoveBox.getText();
            //Add Item to Back End Item List
            player.checkandAddlang(langToAdd);
            
            //Reprint Entries in the Text Area
            language_area.setText("");
            String[] langsArray = player.StringarrayLang();
            for (int i = 0; i < langsArray.length; i++) {
                    language_area.append(langsArray[i] + "\n" );
            }
            langAddRemoveBox.setText("");
        }
    }
}

public class RemoveLangListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == removeLangButton){
            String langToRemove = langAddRemoveBox.getText();
            //Add Item to Back End Item List
            player.removeLang(langToRemove);
            
            //Reprint Entries in the Text Area
            language_area.setText("");
            String[] langsArray = player.StringarrayLang();
            for (int i = 0; i < langsArray.length; i++) {
                    language_area.append(langsArray[i] + "\n" );
            }
            langAddRemoveBox.setText("");
        }
    }
}

public class AddProfListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addProfButton){
            String profToAdd = profAddRemoveBox.getText();
            //Add Item to Back End Item List
            player.CheckandAddWepPro(profToAdd);
            
            //Reprint Entries in the Text Area
            proficiency_area.setText("");
            String[] profsArray = player.StringarrayArmorandWeaponsProf();
            for (int i = 0; i < profsArray.length; i++) {
                    proficiency_area.append(profsArray[i] + "\n" );
            }
            profAddRemoveBox.setText("");
        }
    }
}

public class RemoveProfListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == removeProfButton){
            String profToRemove = profAddRemoveBox.getText();
            //Add Item to Back End Item List
            player.removeWeaponPro(profToRemove);
            
            //Reprint Entries in the Text Area
            proficiency_area.setText("");
            String[] profsArray = player.StringarrayArmorandWeaponsProf();
            for (int i = 0; i < profsArray.length; i++) {
                    proficiency_area.append(profsArray[i] + "\n" );
            }
            profAddRemoveBox.setText("");
        }
    }
}

public class InfoListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == setInfoButton){
            
            String s = info_area.getText();
            if(s == null){
                return;
            }
            player.setinfo(s);
        }
    }
}

public class AddSpell implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cantripAddSpellButton){//Cantrips
            String spellToAdd = cantripBox.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 0);
            
            //Reprint Entries in the Text Area
            cantripTextArea.setText("");
            String[] Cantripspells = player.StringarrayCantrips();
            for (int i = 0; i < Cantripspells.length; i++) {
                    cantripTextArea.append(Cantripspells[i] + "\n" );
            }
            cantripBox.setText("");
        }
        if(e.getSource() == level1AddSpellButton){//Level 1 Spells
            String spellToAdd = level1Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 1);
            
            //Reprint Entries in the Text Area
            level1TextArea.setText("");
            String[] lvl1spells = player.Stringarraylvl1spells();
            for (int i = 0; i < lvl1spells.length; i++) {
                    level1TextArea.append(lvl1spells[i] + "\n" );
            }
            level1Box.setText("");
        }
        if(e.getSource() == level2AddSpellButton){//Level 2 Spells
            String spellToAdd = level2Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 2);
            
            //Reprint Entries in the Text Area
            level2TextArea.setText("");
            String[] lvl2spells = player.Stringarraylvl2spells();
            for (int i = 0; i < lvl2spells.length; i++) {
                    level2TextArea.append(lvl2spells[i] + "\n" );
            }
            level2Box.setText("");
        }
        if(e.getSource() == level3AddSpellButton){//Level 3 Spells
            String spellToAdd = level3Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 3);
            
            //Reprint Entries in the Text Area
            level3TextArea.setText("");
            String[] lvl3spells = player.Stringarraylvl3spells();
            for (int i = 0; i < lvl3spells.length; i++) {
                    level3TextArea.append(lvl3spells[i] + "\n" );
            }
            level3Box.setText("");
        }
        if(e.getSource() == level4AddSpellButton){//Lvel 4 Spells
            String spellToAdd = level4Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 4);
            
            //Reprint Entries in the Text Area
            level4TextArea.setText("");
            String[] lvl4spells = player.Stringarraylvl4spells();
            for (int i = 0; i < lvl4spells.length; i++) {
                    level4TextArea.append(lvl4spells[i] + "\n" );
            }
            level4Box.setText("");
        }
        if(e.getSource() == level5AddSpellButton){//Level 5 Spells
            String spellToAdd = level5Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 5);
            
            //Reprint Entries in the Text Area
            level5TextArea.setText("");
            String[] lvl5spells = player.Stringarraylvl5spells();
            for (int i = 0; i < lvl5spells.length; i++) {
                    level5TextArea.append(lvl5spells[i] + "\n" );
            }
            level5Box.setText("");
        }
        if(e.getSource() == level6AddSpellButton){//level 6 Spells
            String spellToAdd = level6Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 6);
            
            //Reprint Entries in the Text Area
            level6TextArea.setText("");
            String[] lvl6spells = player.Stringarraylvl6spells();
            for (int i = 0; i < lvl6spells.length; i++) {
                    level6TextArea.append(lvl6spells[i] + "\n" );
            }
            level6Box.setText("");
        }
        if(e.getSource() == level7AddSpellButton){//Level 7 Spells
            String spellToAdd = level7Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 7);
            
            //Reprint Entries in the Text Area
            level7TextArea.setText("");
            String[] lvl7spells = player.Stringarraylvl7spells();
            for (int i = 0; i < lvl7spells.length; i++) {
                    level7TextArea.append(lvl7spells[i] + "\n" );
            }
            level7Box.setText("");
        }
        if(e.getSource() == level8AddSpellButton){//Level 8 Spells
            String spellToAdd = level8Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 8);
            
            //Reprint Entries in the Text Area
            level8TextArea.setText("");
            String[] lvl8spells = player.Stringarraylvl8spells();
            for (int i = 0; i < lvl8spells.length; i++) {
                    level8TextArea.append(lvl8spells[i] + "\n" );
            }
            level8Box.setText("");
        }
        if(e.getSource() == level9AddSpellButton){//Level 9 Spells
            String spellToAdd = level9Box.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 9);
            
            //Reprint Entries in the Text Area
            level9TextArea.setText("");
            String[] lvl9spells = player.Stringarraylvl9spells();
            for (int i = 0; i < lvl9spells.length; i++) {
                    level9TextArea.append(lvl9spells[i] + "\n" );
            }
            level9Box.setText("");
        }
        if(e.getSource() == otherAddSpellButton){//Race Spells
            String spellToAdd = otherBox.getText();
            //Add spell to Back End Spell List
            player.checkandAddSpell(spellToAdd, 10);
            
            //Reprint Entries in the Text Area
            otherSpellTextArea.setText("");
            String[] racespells = player.Stringarrayracespells();
            for (int i = 0; i < racespells.length; i++) {
                    otherSpellTextArea.append(racespells[i] + "\n" );
            }
            otherBox.setText("");
        }
                
        spellLvl = 11;
    }
}

public class RemoveSpell implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cantripRemoveSpellButton){//Cantrips
            String spellToRemove = cantripBox.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 0);
            
            //Reprint Entries in the Text Area
            cantripTextArea.setText("");
            String[] Cantripspells = player.StringarrayCantrips();
            for (int i = 0; i < Cantripspells.length; i++) {
                    cantripTextArea.append(Cantripspells[i] + "\n" );
            }
            cantripBox.setText("");
        }
        if(e.getSource() == level1RemoveSpellButton){//Level 1 Spells
            String spellToRemove = level1Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 1);
            
            //Reprint Entries in the Text Area
            level1TextArea.setText("");
            String[] lvl1spells = player.Stringarraylvl1spells();
            for (int i = 0; i < lvl1spells.length; i++) {
                    level1TextArea.append(lvl1spells[i] + "\n" );
            }
            level1Box.setText("");
        }
        if(e.getSource() == level2RemoveSpellButton){//Level 2 Spells
            String spellToRemove = level2Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 2);
            
            //Reprint Entries in the Text Area
            level2TextArea.setText("");
            String[] lvl2spells = player.Stringarraylvl2spells();
            for (int i = 0; i < lvl2spells.length; i++) {
                    level2TextArea.append(lvl2spells[i] + "\n" );
            }
            level2Box.setText("");
        }
        if(e.getSource() == level3RemoveSpellButton){//Level 3 Spells
            String spellToRemove = level3Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 3);
            
            //Reprint Entries in the Text Area
            level3TextArea.setText("");
            String[] lvl3spells = player.Stringarraylvl3spells();
            for (int i = 0; i < lvl3spells.length; i++) {
                    level3TextArea.append(lvl3spells[i] + "\n" );
            }
            level3Box.setText("");
        }
        if(e.getSource() == level4RemoveSpellButton){//Level 4 Spells
            String spellToRemove = level4Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 4);
            
            //Reprint Entries in the Text Area
            level4TextArea.setText("");
            String[] lvl4spells = player.Stringarraylvl4spells();
            for (int i = 0; i < lvl4spells.length; i++) {
                    level4TextArea.append(lvl4spells[i] + "\n" );
            }
            level4Box.setText("");
        }
        if(e.getSource() == level5RemoveSpellButton){//Level 5 Spells
            String spellToRemove = level5Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 5);
            
            //Reprint Entries in the Text Area
            level5TextArea.setText("");
            String[] lvl5spells = player.Stringarraylvl5spells();
            for (int i = 0; i < lvl5spells.length; i++) {
                    level5TextArea.append(lvl5spells[i] + "\n" );
            }
            level5Box.setText("");
        }
        if(e.getSource() == level6RemoveSpellButton){//Level 6 Spells
            String spellToRemove = level6Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 6);
            
            //Reprint Entries in the Text Area
            level6TextArea.setText("");
            String[] lvl6spells = player.Stringarraylvl6spells();
            for (int i = 0; i < lvl6spells.length; i++) {
                    level6TextArea.append(lvl6spells[i] + "\n" );
            }
            level6Box.setText("");
        }
        if(e.getSource() == level7RemoveSpellButton){//Level 7 Spells
            String spellToRemove = level7Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 7);
            
            //Reprint Entries in the Text Area
            level7TextArea.setText("");
            String[] lvl7spells = player.Stringarraylvl7spells();
            for (int i = 0; i < lvl7spells.length; i++) {
                    level7TextArea.append(lvl7spells[i] + "\n" );
            }
            level7Box.setText("");
        }
        if(e.getSource() == level8RemoveSpellButton){//Level 8 Spells
            String spellToRemove = level8Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 8);
            
            //Reprint Entries in the Text Area
            level8TextArea.setText("");
            String[] lvl8spells = player.Stringarraylvl8spells();
            for (int i = 0; i < lvl8spells.length; i++) {
                    level8TextArea.append(lvl8spells[i] + "\n" );
            }
            level8Box.setText("");
        }
        if(e.getSource() == level9RemoveSpellButton){//Level 9 Spells
            String spellToRemove = level9Box.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 9);
             
            //Reprint Entries in the Text Area
            level9TextArea.setText("");
            String[] lvl9spells = player.Stringarraylvl9spells();
            for (int i = 0; i < lvl9spells.length; i++) {
                    level3TextArea.append(lvl9spells[i] + "\n" );
            }
            level9Box.setText("");
        }
        if(e.getSource() == otherRemoveSpellButton){//Race Spells
            String spellToRemove = otherBox.getText();
            //Remove spell from Back End Spell List
            player.RemoveSpell(spellToRemove, 10);
            
            //Reprint Entries in the Text Area
            otherSpellTextArea.setText("");
            String[] racespells = player.Stringarrayracespells();
            for (int i = 0; i < racespells.length; i++) {
                    otherSpellTextArea.append(racespells[i] + "\n" );
            }
            otherBox.setText("");
        }
                
        spellLvl = 11;
    }
}
public class RefreshListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        //(Requirement 8.1.1) Program will check if active character exists
    	if(!(player == null)) {
	    	ClearMethods clear = new ClearMethods();
	        clear.refreshAllAreas();
        }    
        else {
        	//(Requirement 8.1.1.1) If no character exists, program will display message box asking the user to create a character before refreshing. 
        	JOptionPane.showMessageDialog(null, "Please build or load a character before trying to refresh.");
        }
    }
}

public class LoadListener implements ActionListener{
	@Override
    public void actionPerformed(ActionEvent e){        
		
        //(Requirement 6.1.1) Program will check if the file path to the save location has been declared
        String filepath = here.getfilepath();
    	if(filepath == "" || filepath == null) {
    		
    		//(Requirement 6.1.1.1) If no save location has been declared, a message box will pop up asking the user to determine one 
    		JFileChooser filebox = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    		
    		filebox.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    		
    		int r = filebox.showOpenDialog(null);
    		
    		if (r == JFileChooser.APPROVE_OPTION) {
    			filepath = filebox.getSelectedFile().getAbsolutePath();
    			here.setfilepath(filepath);
    			
    		}else {
    			JOptionPane.showMessageDialog(null, "Please select a folder to load characters from.");
    			return;
    		}
    			
    	}
		//(Requirement 6.1.2) Index File is read in to check for all saved characters
		ArrayList<String> oldchar = here.getCharacterlist();
		if(!(oldchar == null)) {
			String characterList[] = new String[oldchar.size()];        
			for(int i = 0; i< oldchar.size(); i++) {
				characterList[i] = oldchar.get(i);
		    }
			
			//(Requirement 6.1.3) Message box will appear with pre-populated list of saved characters
		    JComboBox characterLoadBox = new JComboBox(characterList);
		    int input = JOptionPane.showConfirmDialog(null, characterLoadBox, "Select a Character to Load", JOptionPane.PLAIN_MESSAGE);
		            
		    	if(input == JOptionPane.OK_OPTION){
		            int index = characterLoadBox.getSelectedIndex();
		            String characterToLoad = characterList[index];
		            
		            // Load Commands for loading "characterToLoad"  
		            player = null;
		            occupation = null;
		            try {
		            	//(Requirement 6.1.4) User selects character to load
		            	player = here.getCharacterfromfile(characterToLoad);
						
		            	//(Requirement 6.1.4.2.2) User selects character to load
		            	occupation = here.retrieveClass(player.getCharClass(), player);
						Loadflag = true;
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
		             ClearMethods clear = new ClearMethods();
		             
		             //(Requirement 6.1.4.2.2.1) Graphical user interface refreshed
		             clear.refreshAllAreas();
		             
		            int playerlvl = player.getlevel();
		            switch(playerlvl) {
		            	case 1:{
		            		levelList.setSelectedIndex(0);
		            		break;
		            	}
		            	case 2:{
		            		levelList.setSelectedIndex(1);
		            		break;
		            	}
		            	case 3:{
		            		levelList.setSelectedIndex(2);
		            		break;
		            	}
		            	case 4:{
		            		levelList.setSelectedIndex(3);
		            		break;
		            	}
		            	case 5:{
		            		levelList.setSelectedIndex(4);
		            		break;
		            	}
		            	case 6:{
		            		levelList.setSelectedIndex(5);
		            		break;
		            	}
		            	case 7:{
		            		levelList.setSelectedIndex(6);
		            		break;
		            	}
		            	case 8:{
		            		levelList.setSelectedIndex(7);
		            		break;
		            	}
		            	case 9:{
		            		levelList.setSelectedIndex(8);
		            		break;
		            	}
		            	case 10:{
		            		levelList.setSelectedIndex(9);
		            		break;
		            	}
		            	case 11:{
		            		levelList.setSelectedIndex(10);
		            		break;
		            	}
		            	case 12:{
		            		levelList.setSelectedIndex(11);
		            		break;
		            	}
		            	case 13:{
		            		levelList.setSelectedIndex(12);
		            		break;
		            	}
		            	case 14:{
		            		levelList.setSelectedIndex(13);
		            		break;
		            	}
		            	case 15:{
		            		levelList.setSelectedIndex(14);
		            		break;
		            	}
		            	case 16:{
		            		levelList.setSelectedIndex(15);
		            		break;
		            	}
		            	case 17:{
		            		levelList.setSelectedIndex(16);
		            		break;
		            	}
		            	case 18:{
		            		levelList.setSelectedIndex(17);
		            		break;
		            	}
		            	case 19:{
		            		levelList.setSelectedIndex(18);
		            		break;
		            	}
		            	case 20:{
		            		levelList.setSelectedIndex(19);
		            		break;
		            	}
		            }	
		            String playerrace = player.GetRace();
		            switch(playerrace) {
		            	case "Dragonborn":{
		            		raceList.setSelectedIndex(1);
		            		break;
		            	}
		            	case "HillDwarf":{
		            		raceList.setSelectedIndex(2);
		            		break;
		            	}
		            	case "MountainDwarf":{
		            		raceList.setSelectedIndex(3);
		            		break;
		            	}
		            	case "HighElf":{
		            		raceList.setSelectedIndex(4);
		            		break;
		            	}
		            	case "WoodElf":{
		            		raceList.setSelectedIndex(5);
		            		break;
		            	}
		            	case "Drow":{
		            		raceList.setSelectedIndex(6);
		            		break;
		            	}
		            	case "Forest Gnome":{
		            		raceList.setSelectedIndex(7);
		            		break;
		            	}
		            	case "Rock Gnome":{
		            		raceList.setSelectedIndex(8);
		            		break;
		            	}
		            	case "Half-Elf":{
		            		raceList.setSelectedIndex(9);
		            		break;
		            	}
		            	case "Lightfoot Halfling":{
		            		raceList.setSelectedIndex(10);
		            		break;
		            	}
		            	case "Stout Halfling":{
		            		raceList.setSelectedIndex(11);
		            		break;
		            	}
		            	case "Half-Orc":{
		            		raceList.setSelectedIndex(12);
		            		break;
		            	}
		            	case "Human":{
		            		raceList.setSelectedIndex(13);
		            		break;
		            	}
		            	case "Tiefling":{
		            		raceList.setSelectedIndex(14);
		            		break;
		            	}
		            
		            }	
		            
		            String playerClass = player.getCharClass();
		            switch(playerClass) {
		            	case "Barbarian":{
		            		classList.setSelectedIndex(1);
		            		break;
		            	}
		            	case "Bard":{
		            		classList.setSelectedIndex(2);
		            		break;
		            	}
		            	case "Cleric":{
		            		classList.setSelectedIndex(3);
		            		break;
		            	}
		            	case "Druid":{
		            		classList.setSelectedIndex(4);
		            		break;
		            	}
		            	case "Fighter":{
		            		classList.setSelectedIndex(5);
		            		break;
		            	}
		            	case "Monk":{
		            		classList.setSelectedIndex(6);
		            		break;
		            	}
		            	case "Paladin":{
		            		classList.setSelectedIndex(7);
		            		break;
		            	}
		            	case "Ranger":{
		            		classList.setSelectedIndex(8);
		            		break;
		            	}
		            	case "Rogue":{
		            		classList.setSelectedIndex(9);
		            		break;
		            	}
		            	case "Sorcerer":{
		            		classList.setSelectedIndex(10);
		            		break;
		            	}
		            	case "Warlock":{
		            		classList.setSelectedIndex(11);
		            		break;
		            	}
		            	case "Wizard":{
		            		classList.setSelectedIndex(12);
		            		break;
		            	}
		            }
		            
		            String playerbackground = player.getbackground();
		            switch(playerbackground) {
		            	case "Acolyte":{
		            		backgrList.setSelectedIndex(1);
		            		break;
		            	}
		            	case "Charlatan":{
		            		backgrList.setSelectedIndex(2);
		            		break;
		            	}
		            	case "Criminal":{
		            		backgrList.setSelectedIndex(3);
		            		break;
		            	}
		            	case "Entertainer":{
		            		backgrList.setSelectedIndex(4);
		            		break;
		            	}
		            	case "Folk Hero":{
		            		backgrList.setSelectedIndex(5);
		            		break;
		            	}
		            	case "Guild Artisan":{
		            		backgrList.setSelectedIndex(6);
		            		break;
		            	}
		            	case "Hermit":{
		            		backgrList.setSelectedIndex(7);
		            		break;
		            	}
		            	case "Noble":{
		            		backgrList.setSelectedIndex(8);
		            		break;
		            	}
		            	case "Outlander":{
		            		backgrList.setSelectedIndex(9);
		            		break;
		            	}
		            	case "Sage":{
		            		backgrList.setSelectedIndex(10);
		            		break;
		            	}
		            	case "Sailor":{
		            		backgrList.setSelectedIndex(11);
		            		break;
		            	}
		            	case "Soldier":{
		            		backgrList.setSelectedIndex(12);
		            		break;
		            	}
		            	case "Urchin":{
		            		backgrList.setSelectedIndex(13);
		            		break;
		            	}
		            }
		            
		            String playeralignment = player.getAlignment();
		            switch(playeralignment) {
		            	case "Lawful Good":{
		            		allignList.setSelectedIndex(1);
		            		break;
		            	}
		            	case "Neutral Good":{
		            		allignList.setSelectedIndex(2);
		            		break;
		            	}
		            	case "Chaotic Good":{
		            		allignList.setSelectedIndex(3);
		            		break;
		            	}
		            	case "Lawful Neutral":{
		            		allignList.setSelectedIndex(4);
		            		break;
		            	}
		            	case "Neutral":{
		            		allignList.setSelectedIndex(5);
		            		break;
		            	}
		            	case "Chaotic Neutral":{
		            		allignList.setSelectedIndex(6);
		            		break;
		            	}
		            	case "Lawful Evil":{
		            		allignList.setSelectedIndex(7);
		            		break;
		            	}
		            	case "Neutral Evil":{
		            		allignList.setSelectedIndex(8);
		            		break;
		            	}
		            	case "Chaotic Evil":{
		            		allignList.setSelectedIndex(9);
		            		break;
		            	}
		            
		            }
		            Loadflag = false; 
		        }
		        else{
		            JOptionPane.showMessageDialog(null, "You must Hit OK for the character to be loaded. Please Try Again.");
		        }
        }   
        else{
        	//(Requirement 6.1.2.1) If there are no saved characters in index, Message box will pop up and inform user there are no saved characters
            JOptionPane.showMessageDialog(null, "There are no saved characters to be loaded. Please build a character and save it.");
        }    
    }
}

public class SaveListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        //Save Commands
    	//(Requirement 4.1.1.)
    	if(!(player == null)) {
	    	
    		//(Requirement 4.12)    		
	    	String filepath = here.getfilepath();
	    	if(filepath == "" || filepath == null) {
	    		
	    		JFileChooser filebox = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	    		
	    		filebox.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    		
	    		int r = filebox.showSaveDialog(null);
	    		
	    		if (r == JFileChooser.APPROVE_OPTION) {
	    			filepath = filebox.getSelectedFile().getAbsolutePath();
	    			here.setfilepath(filepath);
	    			
	    		}else {
	    			//(Requirement 4.1.2.1)
	    			JOptionPane.showMessageDialog(null, "Please select a folder to save characters to.");
	    			return;
	    		}
	    	}			    	
	    	try {
				here.readindex();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}	
//	    	
	    	try {
	    		String age = ageBox.getText();
                if(!(ageBox.getText().isEmpty())) {
                    player.setage(Integer.parseInt(age));
                }
               	player.setheight(heightBox.getText());
                player.setweight(weightBox.getText());
                player.setsize(sizeBox.getText());
                player.seteyes(eyesBox.getText()); //Requirement 11.1.2.2.) Text will be saved if character is saved or leveled
                player.sethair(hairBox.getText()); //(Requirement 11.1.1.2)   Text will be saved if character is saved or leveled
    			
    		//Retrieve Weapon1 info
                String name1 = weaponName1.getText();
                int attack1;
                if(!(weaponAtk1.getText().isEmpty())){
                    attack1 = Integer.parseInt(weaponAtk1.getText());
                } else attack1 = 0;
                String damage1 = weaponDmg1.getText();
                String type1 = weaponType1.getText();
                Weapons weap1 = new Weapons(name1, attack1, damage1, type1); 
                player.addtoweapons(weap1, 0);
                
                //Retrieve Weapon2 info
                String name2 = weaponName2.getText();
                int attack2;
                if(!(weaponAtk2.getText().isEmpty())){
                    attack2 = Integer.parseInt(weaponAtk2.getText());
                } else attack2 = 0;
                String damage2 = weaponDmg2.getText();
                String type2 = weaponType2.getText();
                Weapons weap2 = new Weapons(name2, attack2, damage2, type2); 
                player.addtoweapons(weap2, 1);
                
                
                //Retrieve Weapon3 info
                String name3 = weaponName3.getText();
                int attack3;
                if(!(weaponAtk3.getText().isEmpty())){
                    attack3 = Integer.parseInt(weaponAtk3.getText());
                } else attack3 = 0;
                String damage3 = weaponDmg3.getText();
                String type3 = weaponType3.getText();
                Weapons weap3 = new Weapons(name3, attack3, damage3, type3); 
                player.addtoweapons(weap3, 2);
    			
                //Add Armor
                String Armorname = armorName1.getText();
                int ArmorAC1value;
                if(!(armorAC1.getText().isEmpty())){
                    ArmorAC1value = Integer.parseInt(weaponAtk3.getText());
                } else ArmorAC1value = 0;
                int ArmorAC1bonus;
                if(!(armorMagic1.getText().isEmpty())){
                    ArmorAC1bonus = Integer.parseInt(armorMagic1.getText());
                } else ArmorAC1bonus = 0;

                Armor newarmor = new Armor(Armorname, ArmorAC1value, ArmorAC1bonus);
                player.Setarmor(newarmor);

                here.saveCharacter(player);

                //(Requirement 4.2) 
                JOptionPane.showMessageDialog(null, "The character has been saved");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
    	} else {
    		//(Requirement 4.1.1.1)
    		JOptionPane.showMessageDialog(null, "You must create a character before you can save it. Please Try Again.");
    	}
    }
}

public class DeleteListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
    	
    	//(Requirement 5.1.1) Program checks if save location has been declared
    	String filepath = here.getfilepath();
    	
    	//(Requirement 5.1.1.1) If no save location has been declared, the user will be asked to determine one.
    	if(filepath == "" || filepath == null) {
    		
    		JFileChooser filebox = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    		
    		filebox.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    		
    		int r = filebox.showOpenDialog(null);
    		
    		if (r == JFileChooser.APPROVE_OPTION) {
    			filepath = filebox.getSelectedFile().getAbsolutePath();
    			here.setfilepath(filepath);
    			
    		}else {
    			
    			JOptionPane.showMessageDialog(null, "Please select a folder to delete characters from.");
    			return;
    		}
    			
    	}	
    	
    	//(Requirement 5.1.2) Index is read to check for existing characters
    	ArrayList<String> oldchar = here.getCharacterlist();
    	
    	//(Requirement 5.1.2.1) Check if there are existing characters
    	if(!(oldchar == null)) {
			String characterList[] = new String[oldchar.size()];        
			for(int i = 0; i< oldchar.size(); i++) {
				characterList[i] = oldchar.get(i);
		    }
		
			JComboBox characterLoadBox = new JComboBox(characterList);
		    //(Requirement 5.1.3) Message box pop up prepopulated list of saved characters
			int input = JOptionPane.showConfirmDialog(null, characterLoadBox, "Select a Character to Delete", JOptionPane.PLAIN_MESSAGE);
		    
			//(Requirement 5.1.4) User selects character to delete
			if(input == JOptionPane.OK_OPTION){
		            int index = characterLoadBox.getSelectedIndex();
		            String characterToDelete = characterList[index];
		            //Delete Command
		            try {
		            	here.DeleteCharacter(characterToDelete);
		            	
		            	//(Requirement 5.2) Message appears confirming the character was deleted
		            	JOptionPane.showMessageDialog(null, "The character has been deleted.");
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        }
		        else{
		            JOptionPane.showMessageDialog(null, "You must Hit OK for the character to be deleted. Please Try Again.");
		        }
        }   
        else{
        	//(Requirement 5.1.2.1) If no existing characters exist, message box pop up. 
            JOptionPane.showMessageDialog(null, "There are no saved characters to be deleted.");
        }    
    }
}
    	

public class ExitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        //Exit Commands
    	//(Requirement 10.1.1) The program ends and the graphical user interface will disappear. 
    	System.exit(0);  	
    }
}

public class SaveExitListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        //Exit Commands
    	
    	// (Requirement 9.1.1) Saving a character just like Requirement 4
    	if(!(player == null)) {
    		
    		String filepath = here.getfilepath();
	    	if(filepath == "" || filepath == null) {
	    		
	    		JFileChooser filebox = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	    		
	    		filebox.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    		
	    		int r = filebox.showSaveDialog(null);
	    		
	    		if (r == JFileChooser.APPROVE_OPTION) {
	    			filepath = filebox.getSelectedFile().getAbsolutePath();
	    			here.setfilepath(filepath);
	    			
	    		}else {
	    			JOptionPane.showMessageDialog(null, "Please select a folder to save characters to.");
	    			return;
	    		}
	    	}
    		try {
				here.readindex();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
	    	try {
	    		
	    		String age = ageBox.getText();
                if(!(ageBox.getText().isEmpty())) {
                	player.setage(Integer.parseInt(age));
                }
               	player.setheight(heightBox.getText());
       			player.setweight(weightBox.getText());
       			player.setsize(sizeBox.getText());
    			player.seteyes(eyesBox.getText());//(Requirement 11.1.2.2.)  Text will be saved if character is saved or leveled
    			player.sethair(hairBox.getText()); //(Requirement 11.1.1) Text from Hair Box is saved to character
	    		
    			 //Retrieve Weapon1 info
                String name1 = weaponName1.getText();
                int attack1;
                if(!(weaponAtk1.getText().isEmpty())){
                	attack1 = Integer.parseInt(weaponAtk1.getText());
                } else attack1 = 0;
                String damage1 = weaponDmg1.getText();
                String type1 = weaponType1.getText();
                Weapons weap1 = new Weapons(name1, attack1, damage1, type1); 
                player.addtoweapons(weap1, 0);
                
                //Retrieve Weapon2 info
                String name2 = weaponName2.getText();
                int attack2;
                if(!(weaponAtk2.getText().isEmpty())){
                	attack2 = Integer.parseInt(weaponAtk2.getText());
                } else attack2 = 0;
                String damage2 = weaponDmg2.getText();
                String type2 = weaponType2.getText();
               
                Weapons weap2 = new Weapons(name2, attack2, damage2, type2); 
                player.addtoweapons(weap2, 1);
                
                
              //Retrieve Weapon3 info
                String name3 = weaponName3.getText();
                int attack3;
                if(!(weaponAtk3.getText().isEmpty())){
                	attack3 = Integer.parseInt(weaponAtk3.getText());
                } else attack3 = 0;
                String damage3 = weaponDmg3.getText();
                String type3 = weaponType3.getText();
               
                Weapons weap3 = new Weapons(name3, attack3, damage3, type3); 
                player.addtoweapons(weap3, 2);
    			
    			//Add Armor
    			String Armorname = armorName1.getText();
    			 int ArmorAC1value;
                 if(!(armorAC1.getText().isEmpty())){
                	 ArmorAC1value = Integer.parseInt(weaponAtk3.getText());
                 } else ArmorAC1value = 0;
                 int ArmorAC1bonus;
                 if(!(armorMagic1.getText().isEmpty())){
                	 ArmorAC1bonus = Integer.parseInt(armorMagic1.getText());
                 } else ArmorAC1bonus = 0;
    			    			
    			Armor newarmor = new Armor(Armorname, ArmorAC1value, ArmorAC1bonus);
    			player.Setarmor(newarmor);

    			here.saveCharacter(player);
				JOptionPane.showMessageDialog(null, "The character has been saved");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}
    	//Close the program
    	//(Requirement 9.1.2)
    	System.exit(0);
    }
}

public class RollSettingListener implements ActionListener{//{"Rolled Auto Assigned", "Rolled User Assigned", "Standard Array"};
    @Override
    //(Requirement 2.1) User clicks button that looks like a cogwheel
    public void actionPerformed(ActionEvent e){
        JPanel rollSettings = new JPanel();
        JComboBox rollSettingBox = new JComboBox(rollChoices);
        rollSettings.add(rollSettingBox);
        //Requirement 2.1.1) Message box appears with a drop down to allow user to pick one of the ways to assign ability scores and hits ok
        JOptionPane.showMessageDialog(null, rollSettingBox, "Please Select One of the Following Roll Settings", JOptionPane.QUESTION_MESSAGE);
        rollChoice = rollChoices[rollSettingBox.getSelectedIndex()];
    }
}

public class RollAssignListener implements ActionListener{
    @Override
    //(Requirement 2.3) User clicks button that looks like a refresh symbol
    public void actionPerformed(ActionEvent e){
        AutoAssignRolls aar = new AutoAssignRolls();
        AssignRolls uar = new AssignRolls();
        StandardArray sa = new StandardArray();
        //(Requirement 2.3.2)  If Rolled Auto Assigned was Selected
    	if("Rolled Auto Assigned".equals(rollChoice)){
            //(Requirement 2.3.2.1)  A message box will pop up if the user tries to reassign the rolls to inform the user that it is not possible to reassign these rolls
           JOptionPane.showMessageDialog(null, "Sorry, it seems you have selected a roll setting that does not allow reassigning rolls.");
        }
        //(Requirement 2.3.3) If Rolled User Assigned was selected
    	if("Rolled User Assigned".equals(rollChoice)){
           uar.UserAssignRolls(false);
        }
        //(Requirement 2.3.1) If Standard Array was selected
        if("Standard Array".equals(rollChoice)){
            sa.StandardArray(false);
        }
    }
}

private class RollListener implements ActionListener{
    @Override
    //(Requirement 2.2) User clicks button that looks like a dice
    public void actionPerformed(ActionEvent e) {
        AutoAssignRolls aar = new AutoAssignRolls();
        AssignRolls uar = new AssignRolls();
        StandardArray sa = new StandardArray();
        //(Requirement 2.2.2) If Rolled Auto Assigned Auto Assigned was selected
    	if("Rolled Auto Assigned".equals(rollChoice)){
           aar.AutoAssignRolls();
        }
        //(Requirement 2.2.3) If Rolled Auto Assigned Auto Assigned was selected
    	if("Rolled User Assigned".equals(rollChoice)){
           uar.UserAssignRolls(true);
        }
        //(Requirement 2.2.1) If Rolled Auto Assigned Auto Assigned was selected
        if("Standard Array".equals(rollChoice)){
            sa.StandardArray(true);
        }
    }
    
}

private class AutoAssignRolls{
    public void AutoAssignRolls(){
        //(Requirement 2.2.2.1) Program will roll 6 values; one for each ability score
    	statarray =  here.GUIinputgeneratedvalues();
    	
    	//Display current ability point values
        str_score.setText(Integer.toString(statarray[0]));
        dex_score.setText(Integer.toString(statarray[1]));
        con_score.setText(Integer.toString(statarray[2]));
        int_score.setText(Integer.toString(statarray[3]));
        wis_score.setText(Integer.toString(statarray[4]));
        cha_score.setText(Integer.toString(statarray[5]));
            	
    	//If player exists, apply to character
        //(Requirement 2.2.2.3)  If character exists, rolls are assigned to correct ability score on character and applies any modifiers
    	//(Requirement 3.5.2.2)  User can decide to reroll their ability scores after generation of character
    	if(!(player ==null) && hasapplied == false){
           	if(!(statarray == null)) {
                    player.setstr(statarray[0]+ player.getstr());
                    player.setDex(statarray[1]+ player.getDex());
                    player.setcon(statarray[2]+ player.getcon());
                    player.setintel(statarray[3]+ player.getintel());
                    player.setwis(statarray[4] + player.getwis());
                    player.setchar(statarray[5]+ player.getchar());
                }
           	 
            ClearMethods clear = new ClearMethods();
            clear.refreshAllAreas();
        }
        //(Requirement 2.2.2.2)  Program will assign the rolls in the order they are made
    	//(Requirement 3.5.2.2.1)  When scores are applied after initial generation, class, and racial bonuses to the ability scores will be reapplied
    	if(!(player ==null) && hasapplied == true){
            if(!(statarray == null)) {
                    player.setstr(statarray[0]);
                    player.setDex(statarray[1]);
                    player.setcon(statarray[2]);
                    player.setintel(statarray[3]);
                    player.setwis(statarray[4]);
                    player.setchar(statarray[5]);
                    player.recalcskillpoints();
            }
           	 
            ClearMethods clear = new ClearMethods();
            clear.refreshAllAreas();
        }
    }
}

private class AssignRolls{
    Integer[] statTemp = new Integer[6];
    int[] statTempPrim = new int[6];
    
    JFrame frame = new JFrame();
    JLabel assignMessage = new JLabel("Assign your Rolls(Selecting Each Only Once)");
    JPanel rollAssignBorder = new JPanel();
    JPanel rollAssign = new JPanel();
    JLabel streLabel = new JLabel("Strength");
    JComboBox streBox = new JComboBox();
    JLabel dextLabel = new JLabel("Dexterity");
    JComboBox dextBox = new JComboBox();
    JLabel consLabel = new JLabel("Constitution");
    JComboBox consBox = new JComboBox();
    JLabel inteLabel = new JLabel("Intelligence");
    JComboBox inteBox = new JComboBox();
    JLabel wisdLabel = new JLabel("Wisdom");
    JComboBox wisdBox = new JComboBox();
    JLabel charLabel = new JLabel("Charisma");
    JComboBox charBox = new JComboBox();
    public void UserAssignRolls(boolean newRoll){
    
    BorderLayout assignBorderLayout = new BorderLayout();
    rollAssignBorder.setLayout(assignBorderLayout);
    GridLayout assignLayout = new GridLayout(0,2);
    rollAssign.setLayout(assignLayout);
    
    
    //(Requirement 2.2.3.1) Program will roll 6 values; one for each ability score
    if(newRoll != false){
    statarray = here.GUIinputgeneratedvalues();
    }
    
    for(int i = 0; i < 6; i++){
        statTemp[i]=statarray[i];
    }
    Arrays.sort(statTemp, Collections.reverseOrder());
 
        streBox.setModel(new DefaultComboBoxModel(statTemp));
        dextBox.setModel(new DefaultComboBoxModel(statTemp));
        consBox.setModel(new DefaultComboBoxModel(statTemp));
        inteBox.setModel(new DefaultComboBoxModel(statTemp));
        wisdBox.setModel(new DefaultComboBoxModel(statTemp));
        charBox.setModel(new DefaultComboBoxModel(statTemp));

        
        rollAssignBorder.add(assignMessage, BorderLayout.PAGE_START);
        rollAssign.add(streLabel);
        rollAssign.add(streBox);
        rollAssign.add(dextLabel);
        rollAssign.add(dextBox);
        rollAssign.add(consLabel);
        rollAssign.add(consBox);
        rollAssign.add(inteLabel);
        rollAssign.add(inteBox);
        rollAssign.add(wisdLabel);
        rollAssign.add(wisdBox);
        rollAssign.add(charLabel);
        rollAssign.add(charBox);
        rollAssignBorder.add(rollAssign, BorderLayout.CENTER);
        Dimension d = new Dimension(200,200);
        rollAssignBorder.setSize(d);
        JOptionPane rolly = new JOptionPane();
        rolly.setSize(new Dimension(200,200));
        rolly.setPreferredSize(new Dimension(400, roll.getPreferredSize().height));
        
        //(Requirement 2.2.3.2) Roll Assignment box pops up to allow user to assign rolls
        //(Requirement 2.3.3.1) Roll Assignment box pops up to allow user to reassign the values
        //(Requirement 2.2.3.3) User assigns values in the pop up and hits ok
        //(Requirement 2.3.3.2) User reassigns values in the pop up and clicks ok
        int input = rolly.showConfirmDialog(null, rollAssignBorder,  "Roll Assignment", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(input == JOptionPane.OK_OPTION){
            //Store the selections in an array
            int[] indexes = new int[6];
            indexes[0] = streBox.getSelectedIndex();
            indexes[1] = dextBox.getSelectedIndex();
            indexes[2] = consBox.getSelectedIndex();
            indexes[3] = inteBox.getSelectedIndex();
            indexes[4] = wisdBox.getSelectedIndex();
            indexes[5] = charBox.getSelectedIndex(); 
            Integer[] uniqueCheck = new Integer[6];
            for(int i = 0; i <5; i++){
                uniqueCheck[i] = statTemp[indexes[i]];
            }
            
            Unique u = new Unique();
            boolean noRepeats = u.checkUnique(uniqueCheck);
            
            if(noRepeats = true){
                //Assign Rolls and close Window
                statarray[0] = statTemp[indexes[0]];
                statarray[1] = statTemp[indexes[1]];
                statarray[2] = statTemp[indexes[2]];
                statarray[3] = statTemp[indexes[3]];
                statarray[4] = statTemp[indexes[4]];
                statarray[5] = statTemp[indexes[5]];
                
               //Display current ability point values
                str_score.setText(Integer.toString(statarray[0]));
                dex_score.setText(Integer.toString(statarray[1]));
                con_score.setText(Integer.toString(statarray[2]));
                int_score.setText(Integer.toString(statarray[3]));
                wis_score.setText(Integer.toString(statarray[4]));
                cha_score.setText(Integer.toString(statarray[5]));
                
                
                //If player exists, apply to character
                //(Requirement 2.2.3.4)  The program assigns new values to the ability scores
                //(Requirement 2.3.3.3) The program reassigns new values to the ability scores
                //(Requirement 3.5.2.2)  User can decide to reroll their ability scores after generation of character
                if((!(player ==null) && hasapplied == false)){
                  	 if(!(statarray == null)) {
                  		player.setstr(statarray[0]+ player.getstr());
       	        		player.setDex(statarray[1]+ player.getDex());
       	        		player.setcon(statarray[2]+ player.getcon());
       	        		player.setintel(statarray[3]+ player.getintel());
       	        		player.setwis(statarray[4] + player.getwis());
       	        		player.setchar(statarray[5]+ player.getchar());
       	        		player.calcinitiative(); 
                      }
                  	 
                  	ClearMethods clear = new ClearMethods();
                    clear.refreshAllAreas();
                  }
                
                //(Requirement 2.2.3.5)  If character exists, rolls are assigned to correct ability score on character and applies any modifiers
                //(Requirement 2.3.3.4)  If character exists rolls are assigned to correct ability score on character and applies any modifiers
                //(Requirement 3.5.2.2.1)  When scores are applied after initial generation, class, and racial bonuses to the ability scores will be reapplied
                if(!(player ==null) && hasapplied == true){
                  	 if(!(statarray == null)) {
                  		player.setstr(statarray[0]);
               		player.setDex(statarray[1]);
               		player.setcon(statarray[2]);
               		player.setintel(statarray[3]);
               		player.setwis(statarray[4]);
               		player.setchar(statarray[5]);
                  		player.recalcskillpoints();
                      }
                  	 
                  	 ClearMethods clear = new ClearMethods();
                    clear.refreshAllAreas();
                  }

                
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry, it seems you selected the same index more then once. Keep in mind that even though the numbers may be the same they are treated as seperate indexes");
            }
            
            }
        }
    }

private class Unique{
    private boolean checkUnique(Integer[] arr){
        int[] array = new int[6];
        for(int i = 0; i < 5; i++){
            array[i] = arr[i];
        }
        
        
        return Arrays.equals(array, statarray);
    }
}

private class StandardArray{//Same as Assign but the Array is the standard instead of being rolled
    Integer[] statTemp = new Integer[6];
    int[] statTempPrim = new int[6];
    
    JFrame frame = new JFrame();
    JLabel assignMessage = new JLabel("Assign your Rolls(Selecting Each Only Once)");
    JPanel rollAssignBorder = new JPanel();
    JPanel rollAssign = new JPanel();
    JLabel streLabel = new JLabel("Strength");
    JComboBox streBox = new JComboBox();
    JLabel dextLabel = new JLabel("Dexterity");
    JComboBox dextBox = new JComboBox();
    JLabel consLabel = new JLabel("Constitution");
    JComboBox consBox = new JComboBox();
    JLabel inteLabel = new JLabel("Intelligence");
    JComboBox inteBox = new JComboBox();
    JLabel wisdLabel = new JLabel("Wisdom");
    JComboBox wisdBox = new JComboBox();
    JLabel charLabel = new JLabel("Charisma");
    JComboBox charBox = new JComboBox();
    public void StandardArray(boolean newRoll){//[15,14,13,12,10,8]
        
    BorderLayout assignBorderLayout = new BorderLayout();
    rollAssignBorder.setLayout(assignBorderLayout);
    GridLayout assignLayout = new GridLayout(0,2);
    rollAssign.setLayout(assignLayout);
    
    //(Requirement 2.2.1.1)  The Program loads the scores {15, 14, 13, 12, 10, 8]
    int[] standardArray = {15,14,13,12,10,8};
    
    if(newRoll = true){
        System.arraycopy(standardArray, 0, statarray, 0, 6);
    }
    
    for(int i = 0; i < 6; i++){
        statTemp[i]=statarray[i];
    }
    Arrays.sort(statTemp, Collections.reverseOrder());
 
        streBox.setModel(new DefaultComboBoxModel(statTemp));
        dextBox.setModel(new DefaultComboBoxModel(statTemp));
        consBox.setModel(new DefaultComboBoxModel(statTemp));
        inteBox.setModel(new DefaultComboBoxModel(statTemp));
        wisdBox.setModel(new DefaultComboBoxModel(statTemp));
        charBox.setModel(new DefaultComboBoxModel(statTemp));

        
        rollAssignBorder.add(assignMessage, BorderLayout.PAGE_START);
        rollAssign.add(streLabel);
        rollAssign.add(streBox);
        rollAssign.add(dextLabel);
        rollAssign.add(dextBox);
        rollAssign.add(consLabel);
        rollAssign.add(consBox);
        rollAssign.add(inteLabel);
        rollAssign.add(inteBox);
        rollAssign.add(wisdLabel);
        rollAssign.add(wisdBox);
        rollAssign.add(charLabel);
        rollAssign.add(charBox);
        rollAssignBorder.add(rollAssign, BorderLayout.CENTER);
        Dimension d = new Dimension(200,200);
        rollAssignBorder.setSize(d);
        JOptionPane rolly = new JOptionPane();
        rolly.setSize(new Dimension(200,200));
        rolly.setPreferredSize(new Dimension(400, roll.getPreferredSize().height));
        //First Pane
        //(Requirement 2.2.1.2)  Roll Assignment box pops up to allow user to assign the values
        //(Requirement 2.3.1.1)  Roll Assignment box pops up to allow user to reassign the values
        //(Requirement 2.2.1.3)  User assigns values in the pop up and clicks ok
        //(Requirement 2.3.1.2)  User reassigns values in the pop up and clicks ok
        int input = rolly.showConfirmDialog(null, rollAssignBorder,  "Roll Assignment", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(input == JOptionPane.OK_OPTION){
            //Store the selections in an array
            int[] indexes = new int[6];
            indexes[0] = streBox.getSelectedIndex();
            indexes[1] = dextBox.getSelectedIndex();
            indexes[2] = consBox.getSelectedIndex();
            indexes[4] = wisdBox.getSelectedIndex();
            indexes[3] = inteBox.getSelectedIndex();
            indexes[5] = charBox.getSelectedIndex(); 
            Integer[] uniqueCheck = new Integer[6];
            for(int i = 0; i <5; i++){
                uniqueCheck[i] = statTemp[indexes[i]];
            }
            
            Unique u = new Unique();
            boolean noRepeats = u.checkUnique(uniqueCheck);
            
            if(noRepeats = true){
                //Assign Rolls and close Window
                statarray[0] = statTemp[indexes[0]];
                statarray[1] = statTemp[indexes[1]];
                statarray[2] = statTemp[indexes[2]];
                statarray[3] = statTemp[indexes[3]];
                statarray[4] = statTemp[indexes[4]];
                statarray[5] = statTemp[indexes[5]];
                
                //Display current ability point values
                str_score.setText(Integer.toString(statarray[0]));
                dex_score.setText(Integer.toString(statarray[1]));
                con_score.setText(Integer.toString(statarray[2]));
                int_score.setText(Integer.toString(statarray[3]));
                wis_score.setText(Integer.toString(statarray[4]));
                cha_score.setText(Integer.toString(statarray[5]));
                
                
                //If player exists, apply to character
                //(Requirement 2.2.1.4)  The program reassigns new values to the ability scores
                //(Requirement 2.3.1.3)  The program reassigns new values to the ability scores
                //(Requirement 3.5.2.2)  User can decide to reroll their ability scores after generation of character
                if((!(player ==null) && hasapplied == false)){
                  	 if(!(statarray == null)) {
                  		player.setstr(statarray[0]+ player.getstr());
       	        		player.setDex(statarray[1]+ player.getDex());
       	        		player.setcon(statarray[2]+ player.getcon());
       	        		player.setintel(statarray[3]+ player.getintel());
       	        		player.setwis(statarray[4] + player.getwis());
       	        		player.setchar(statarray[5]+ player.getchar());
       	        		player.calcinitiative(); 
                      }
                  	 
                  	ClearMethods clear = new ClearMethods();
                    clear.refreshAllAreas();
                  }
                
                //(Requirement 2.2.1.5) If character exists, rolls are assigned to correct ability score on character and applies any modifiers
                //(Requirement 2.3.1.4) If character exists, rolls are assigned to correct ability score on character and applies any modifiers
                //(Requirement 3.5.2.2.1)  When scores are applied after initial generation, class, and racial bonuses to the ability scores will be reapplied
                if(!(player ==null) && hasapplied == true){
                  	if(!(statarray == null)) {
                            player.setstr(statarray[0]);
                            player.setDex(statarray[1]);
                            player.setcon(statarray[2]);
                            player.setintel(statarray[3]);
                            player.setwis(statarray[4]);
                            player.setchar(statarray[5]);
                            player.recalcskillpoints();
                        }
                  	 
                  	ClearMethods clear = new ClearMethods();
                        clear.refreshAllAreas();
                }


            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry, it seems you selected the same index more then once. Keep in mind that even though the numbers may be the same they are treated as seperate indexes");
            }
            
            }
    }
}



}
