package com.example.myapplication;

import com.example.myapplication.main.Item;
import com.example.myapplication.main.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constants {
    List<Item> PC_ITEMS = Arrays.asList(
        new Item("Monitor"     , R.drawable.monitorbg),
        new Item("CPU Cabinet" , R.drawable.cabinetbg),
        new Item("Motherboard" , R.drawable.motherboardbg),
        new Item("Graphic Card", R.drawable.graphiccardbg),
        new Item("CD Driver"   , R.drawable.cddriverbg),
        new Item("Gamepad"     , R.drawable.gamepadbg),
        new Item("Processor"   , R.drawable.processorbg),
        new Item("RAM"         , R.drawable.rambg),
        new Item("Hard Drive"  , R.drawable.hardiskbg),
        new Item("SMPS"        , R.drawable.smpsbg),
        new Item("Keyboard"    , R.drawable.keyboardbg),
        new Item("Mouse"       , R.drawable.mousebg),
        new Item("Speaker"    , R.drawable.speakersbg),
        new Item("Connector"  , R.drawable.connectorbg),
        new Item("Router"  , R.drawable.routerbg)
    );

    List<Item> Motherboard_ITEMS = Arrays.asList(
            new Item(" GIGABYTE AMD A320, AM4 Socket,Ultra Durable Motherboard with Fast Onboard Storage with NVMe,PCIe Gen3 x4 110mm M.2, 4K Ultra HD Support (GA-A320M-S2H).","₹4,614","Rating:4.5/5", R.drawable.motherboardone),
            new Item(" ASUS EX-A320M Gaming AMD Motherboard","₹5,300","Rating:4.5/5", R.drawable.motherboardtwo),
            new Item(" GIGABYTE B450 AORUS PRO Motherboard with Hybrid Digital PWM, Dual M.2 with Dual Thermal Guards, Audio ALC1220-VB,RGB Fusion 2.0","₹11,064","Rating:4.5/5", R.drawable.motherboardthree),
            new Item("Gigabyte B450M DS3H (AMD Ryzen AM4/M.2/HMDI/DVI/USB 3.1/DDR4/Micro ATX/Motherboard). ","₹6,599","Rating:4/5", R.drawable.motherboardfour),
            new Item(" MSI B450 Tomahawk MAX Gaming Motherboard.","₹9,999","Rating:4.5/5", R.drawable.motherboardfive),
            new Item(" AORUS GIGABYTE AMD B450 AORUS Elite V2 Motherboard with 8+2 Phases Digital Team Power Design, Dual M.2 with One Thermal Guard, GIGABYTE Gaming LAN with Bandwidth Management, RGB Fusion 2.0","₹8,100","Rating:4.5/5", R.drawable.motherboardsix),
            new Item("MSI H310M PRO M2 Plus mATX Motherboard (9th / 8th Gen Intel Core,LGA 1151 Socket, DDR4, M.2 and NVMe,DVI-D/VGA/HDMI) ","₹5,000","Rating:4.5/5", R.drawable.motherboardseven),
            new Item(" Creality Motherboard Replacement V1.1.4","₹11,358","Rating:4/5", R.drawable.motherboardeight),
            new Item(" ASUS Intel 8th Gen DDR4 HDMI VGA Micro ATX Motherboards (Prime H310M-E R2.0).","₹4,798","Rating:4.5/5", R.drawable.motherboardnine),
            new Item(" ASUS Prime B550M-A AM4 PCIe 4.0 DDR4 (4600 O.C.) 2X M.2 WiFi 6 USB 3.2 Gen2 mATX Motherboard with Aura Sync RGB Support","₹13,090","Rating:4/5", R.drawable.motherboardten),
            new Item(" RF Technologies Redsail Motherboard","₹3,800","Rating:2/5", R.drawable.motherboardeleven),
            new Item("InfCloud ASRock H81- DGS Motherboard (OEM with IO Shield Only). ","₹5,199","Rating:3/5", R.drawable.motherboardtwelve),
            new Item(" MSI ProSeries AMD A320 1st, 2nd, 3rd Gen Ryzen Compliant AM4 DDR4 HDMI DVI M.2 USB 3 Micro-ATX Motherboard (A320M-A PRO MAX).","₹3,980","Rating:4.5/5", R.drawable.motherboardthirteen),
            new Item("MSI H410M PRO-VH mATX Motherboard (10th Gen Intel Core, LGA 1200 Socket, DDR4, USB 3.2 Gen 1, Intel Gigabit LAN, VGA/HDMI) ","₹6,150","Rating:4.5/5", R.drawable.motherboardfourteen),
            new Item("GIGABYTE B550M DS3H Ultra Durable Motherboard with Pure Digital VRM Solution, PCIe 4.0 x16 Slot, RGB Fusion 2.0, Q-Flash Plus. ","₹8,699","Rating:4.5/5", R.drawable.motherboardfifteen)
    );

    List<Item> Monitor_ITEMS = Arrays.asList(
            new Item("Dell E2420HS 24 Inch FHD (1920 x 1080) LED Backlit LCD IPS Monitor with Display Port,HDMI Port,VGA Ports and inbuilt Speaker.","₹9,749","Rating:4/5", R.drawable.monitorone),
            new Item("HP 22 inch(54.61 cm) Ultra-Slim Anti Glare Full HD LED Monitor - 3 Side Micro Bezel, IPS Panel with VGA, HDMI Ports - HP 22m Display - 3WL45AA (Black)" ,"₹8,499","Rating:4.5/5", R.drawable.monitortwo),
            new Item("LG 22 inch (55cm) IPS Monitor - Full HD, IPS Panel with VGA, HDMI, DVI, Audio Out Ports - 22MP68VQ" ,"₹9,499","Rating:4.5/5", R.drawable.monitorthree),
            new Item("Lenovo 54.6 cm (21.5 inch) Near Edgeless Monitor with LED Display, VA Panel, AMD Free Synch, HDMI and VGA inputs, TUV Certified Eye Comfort - L22e-20 (Raven Black)","₹7,679","Rating:4.5/5", R.drawable.monitorfour),
            new Item("Acer 23.8 Inch Full HD IPS Ultra Slim (6.6mm Thick) Monitor I Frameless Design I AMD Free Sync I Eye Care Features I Stereo Speakers (HA240Y)"   , "₹9,999","Rating:4.5/5",R.drawable.monitorfive),
            new Item("HP 21.5-inch (54.6 cm) Ultra-Slim LED Backlit Gaming Monitor - 16:9 FHD, Micro-Edge, 75 Hz Refresh Rate, AMD Free Sync- HP 22F Display - 3AJ92AA#ACJ (Silver)"     ,"₹10,899","Rating:4.5/5", R.drawable.monitorsix),
            new Item("Acer 21.5 inch LED Backlit Computer Monitor I IPS Full HD I Zero Frame Design I VGA, HDMI Port I Acer Eye Care Features and Built-in Stereo Speakers ET221Q (Black)"   , "₹8,441","Rating:4.5/5",R.drawable.monitorseven),
            new Item("AOPEN Acer 24-inch (60.96 cm) Aopen Curve Gaming Monitor - 24HC1QR (Black)"         ,"₹12,427","Rating:4", R.drawable.monitoreight),
            new Item("LG 60.96 cm (24 inch) Gaming Monitor - 1ms, 75Hz, AMD Freesync, Full HD, IPS Panel with VGA, HDMI, Display Port, 24MP59G (Black)"  ,"₹10,199","Rating:4.5/5", R.drawable.monitornine),
            new Item("Lenovo Legion Y-Series Y25f-10 24.5-inch FHD Gaming Near Edgeless Monitor, TUV Certified Eye Comfort (Black)"        , "₹19,199","Rating:4/5",R.drawable.monitorten),
            new Item("Samsung 24 Inch LS24R350FHWXXL FHD Monitor with Bezel-Less Design, AMD Freesync and 75hz Refresh Rate"    ,"₹9,900","Rating:4.5/5", R.drawable.monitoreleven),
            new Item("AOC 23.6-inch Curved Gaming LED Monitor with VGA Port, HDMI*2 Port, Display Port, 144Hz Refresh Rate - C24G1"       , "₹16,900","Rating:4.5/5",R.drawable.monitortwelve),
            new Item("Dell 24 inch Monitor-S2421H in-Plane Switching (IPS), in built Speakers, Flicker-Free Screen with Comfort View, Full HD (1080p) 1920 x 1080 at 75 Hz with AMD Free Sync"    ,"₹10,590","Rating:4.5/5", R.drawable.monitorthirteen),
            new Item("BenQ PD2500Q 25 inch 2K DesignVue Designer Monitor, 1440p QHD, IPS, 100% Rec.709 and sRGB, Factory Calibrated, Eye-Care, Anti-Glare, Ultra Slim Bezel Design, Height Adjustable, HDMI, DP- Black"  , "₹24,440","Rating:4.5/5",R.drawable.monitorfourteen)
    );


    List<Item> CPUCabinet_ITEMS = Arrays.asList(
            new Item("Corsair Carbide Series CC-9011050-WW Mid-Tower Steel Gaming Case with Red LED (Black)."     ,"₹3,301","Rating:4.5", R.drawable.cpuone),
            new Item("MSI MAG FORGE 100R Mid Tower Gaming PC Case (Black, 2 x 120mm ARGB fans, 1 x 120mm Rear fan, 2 x USB 3.2 Gen1 Type-A, Tempered Glass Panel, Magnetic Dust Filter, Mystic Light RGB, ATX, m-ATX, Mini-ITX."     ,"₹4,599","Rating:4.5/5", R.drawable.cputwo),
            new Item("Ant Esports ICE-200TG Mid Tower Gaming Cabinet Computer case with RGB Front Panel Supports ATX, Micro-ATX, Mini-ITX Motherboard with Transparent Tempered Glass Side Panel,1 x 120 mm Rainbow Fan."     ,"₹3,185","Rating:4.5/5", R.drawable.cputhree),
            new Item("Coconut X5 Mid-tower Gaming Cabinet for PC with Sleek RGB Strip on front panel supporting Mini-ITX / Micro-ATX / ATX Motherboard with 4mm Crystalline transparent tempered glass side panel | Gaming Computer Case with 3 x 120mm aRGB Fan Pre Installed with remote."     ,"₹7,999","Rating:4.5/5", R.drawable.cpufour),
            new Item("CHIPTRONEX MX2 RGB Mid Tower Cabinet USB 3.0 Tempered Glass RGB Fan Preinstalled"     ,"₹2,619","Rating:4/5", R.drawable.cpufive),
            new Item("CHIPTRONEX X310B Mid Tower ATX Cabinet USB 3.0 (case Without SMPS)"     ,"₹2,007","Rating:4/5", R.drawable.cpusix),
            new Item("Antec Torque Mid Tower Aluminum Gaming Cabinet I Computer Case I Support E-ATX, ATX, Micro-ATX, ITX Motherboard with Tempered Glass (Both Sides) - Black White."     ,"₹35,354","Rating:5/5", R.drawable.cpuseven),
            new Item("Antec Torque Mid Tower Aluminum Gaming Cabinet I Computer Case Support E-ATX, ATX, Micro-ATX, ITX Motherboard with Tempered Glass (Both Sides)."     ,"₹30,312","Rating:4.5/5", R.drawable.cpueight),
            new Item("Zebronics Zeb-Cronus Premium Gaming Cabinet with Mirror Finish Tempered Glass On Front,Tempered Glass On Side & 4 x120mm Rainbow Double Ring LED Fans."     ,"₹2,764","Rating:4/5", R.drawable.cpunine),
            new Item("ZEBRONICS Zeb-Ivar Premium Gaming Cabinet with ATX/mATX Motherboard Support, USB 3.0, AIO Cooler Support, 120mm Multicolor LED Fan, Tempered Glass Panel, dust Filter and mesh for air Flow."     ,"₹4,717","Rating:4/5", R.drawable.cputen),
            new Item("DEEPCOOL MATREXX 55 MESH ADD-RGB 4F Mid-Tower Gaming Cabinet/Computer Case with 4 ARGB Fans Pre-Install | Support Mini-ITX/Micro-ATX/ATX/E-ATX (DP-ATX-MATREXX55-MESH-AR-4F)."     ,"₹5,481","Rating:4/5", R.drawable.cpueleven),
            new Item("Antec Striker Mini Tower Gaming Cabinet Aluminium + Steel (SPCC)  Supports ITX with Custom Water-Cooling System of Your Own."     ,"₹20,567","Rating:4.5/5", R.drawable.cputwelve),
            new Item("Cooler Master MasterBox TD500 Mesh Triple ARGB Full Tower Gaming Cabinet with Dual 360mm Radiator Support and Crystalline Tempered Glass (White)."     ,"₹9,249","Rating:5/5", R.drawable.cputhirteen),
            new Item("Antec NX310 Mid-Tower Motherboard Support ATX, Micro-ATX, ITX Computer Cabinet ‘with’ 1 x 120mm ARGB Fan."     ,"₹3,752","Rating:4/5", R.drawable.cpufourteen),
            new Item("Cooler Master MasterBox K501L RGB V2 Mid Tower Gaming Case with Pre-Installed RGB Fan, PSU Shroud and Tempered Glass Side Panel."     ,"₹4,499","Rating:4.5/5", R.drawable.cpufifteen)
            );

    List<Item> GraphicCard_ITEMS = Arrays.asList(
            new Item("Asus GeForce GT 710 2GB GDDR5 HDMI VGA DVI Graphics Card Graphic Cards GT710-SL-2GD5-CSM."     ,"₹3,599","Rating:4.5/5", R.drawable.gcardone),
            new Item("Gigabyte Nvidia GeForce GTX 1050 Over clocking Dual Fan 4GB Graphics Card (GV-N105TOC-4GD)."     ,"₹18,999","Rating:4.5/5", R.drawable.gcardtwo),
            new Item("Gigabyte Nvidia GeForce RTX 2060 OC 6GB GDDR5 Graphic Cards (GV-N2060OC-6GD)."     ,"₹54,400","Rating:4.5/5", R.drawable.gcardthree),
            new Item("ZOTAC GeForce GT 710 2GB DDR3 Zone Edition Graphics Card with GeForce Experience."     ,"₹3,442","Rating:4/5", R.drawable.gcardfour),
            new Item("MSI GT 710 2GD3H LP DDR3 Gaming Graphic Card."     ,"₹3,800","Rating:4/5", R.drawable.gcardfive),
            new Item("MSI GeForce GTX-1050-TI-4GT-OC 4GB GDDR5 PCI-e Graphics Card"     ,"₹21,266","Rating:4/5", R.drawable.gcardsix),
            new Item("Gigabyte GeForce GT 710 2GB Graphic Cards and Support PCI Express 2.0 X8 Bus Interface. Graphic Cards Gv-N710D5-2Gil"     ,"₹4,335","Rating:4/5", R.drawable.gcardseven),
            new Item("Gigabyte GeForce GV-N710D3-2GL 2GB PCI-Express Graphics Card (Black)"     ,"₹3,799","Rating:4/5", R.drawable.gcardeight),
            new Item("ZOTAC GeForce GT 730 4GB DDR3 ZONE Edition Graphics Card with GeForce Experience."     ,"₹6,999","Rating:4/5", R.drawable.gcardnine),
            new Item("Gigabyte Nvidia GeForce RTX 3080 AORUS Xtreme 10GB GDDR6X Graphics Card (GV-N3080AORUS X-10GD)."     ,"₹2,10,000","Rating:4/5", R.drawable.gcardten),
            new Item("ASUS Geforce Dual GTX 1050 Ti 4GB Dual-Fan Edition V2 DVI-D HDMI DP Gaming Graphics Card (DUAL-GTX1050TI-O4G-V2)."     ,"₹20,500","Rating:4.5/5", R.drawable.gcardeleven),
            new Item("INNO3D GEFORCE GT 710 2GB DDR3 LP PCIe 3.0 Gaming Graphics Card- N710-1SDV-E3BX."     ,"₹3,161","Rating:4.5/5", R.drawable.gcardtwelve),
            new Item("NVIDIA Quadro P1000 4GB GDDR5 128bit PCI Express 3.0 x16 Graphics Card (VCQP1000-PB)."     ,"₹28,000","Rating:4/5", R.drawable.gcardthirteen),
            new Item("ASUS Cerberus GeForce GTX 1050 Ti 4GB OC Edition GDDR5 Gaming Graphics Card (Cerberus-GTX1050Ti-O4G)."     ,"₹18,249","Rating:4.5/5", R.drawable.gcardfourteen),
            new Item("ASUS PH-550-2G Phoenix Radeon 550 GDDR5 2GB 64-Bit DVI HDMI Gaming Graphics Card."     ,"₹6,899","Rating:3.5/5", R.drawable.gcardfifteen)
    );


    List<Item> CDDriver_ITEMS = Arrays.asList(
            new Item("HP F6V97AA#ACJ External USB DVD-RW Drive."     ,"₹1,625","Rating:4.5/5", R.drawable.cdone),
            new Item("NK STAR External USB 2.0 Portable Slim CD/DVD-ROM +-R-R-RW Burner Writer for Laptop Desktop Notebook Windows and Mac OS (Black)."     ,"₹1,299","Rating:3/5", R.drawable.cdtwo),
            new Item("Rts External Drive USB 3.0 Portable CD DVD RW Optical Drive Burner Writer for Windows10/8/7 Laptop Desktop PC (Black)."     ,"₹1,699","Rating:3.5/5", R.drawable.cdthree),
            new Item("Asus Internal DVD Writer DRW-24D5MT."     ,"₹1,137","Rating:4/5", R.drawable.cdfour),
            new Item("Dell DW316 USB DVD-RW Drive."     ,"₹2,249","Rating:4.5/5", R.drawable.cdfive),
            new Item("CP-Tech High Speed USB 2.0 Slim Portable External CD/DVD Drive, Data Transfer External CD/DVD-RW Drive/ Writer/ Burner/ Rewriter/ Player for Laptop,PC,MacBook Pro (Black) (1 Year Warranty)."     ,"₹1,199","Rating:5/5", R.drawable.cdsix),
            new Item("Lite-On Internal IHAS124-16 24X DVD Sata Writer."     ,"₹1,900","Rating:4/5", R.drawable.cdseven),
            new Item("Hitachi-LG Multi Ultra Slim Portable DVD Writer External Drive with m-DISC Support (Black)"     ,"₹1,999","Rating:4.5/5", R.drawable.cdeight),
            new Item("InfiDeals External DVD Writer, Portable USB 2.0 CD Burner Ultra Slim CD-RW Player Optical DVD Drive Plug and Play for Laptop and Desktop (Not for TV)."     ,"₹1,299","Rating:1/5", R.drawable.cdnine),
            new Item("VIBOTON External DVD CD Writer USB 3.0 Burner Drive Player High Speed Data Transfer for Laptop/Desktop/MacBook/Windows 10/8/7 - (Black)."     ,"₹1,399","Rating:3.5/5", R.drawable.cdten)
    );


    List<Item> Connector_ITEMS = Arrays.asList(
            new Item("MAEnt ATX 24 Pin Male to 24Pin Female & ATX 4 Pin Male to 4Pin Female Combo SMPS Power Supply Extension Cable Internal PC PSU TW Power Lead Connector Wire(9 Inch)"     ,"₹699","Rating:4/5", R.drawable.conone),
            new Item("L Type HDMI Male to HDMI Female Jointer Connector (Black)-1 PCS 0 m HDMI Adapter (Compatible with LED Tv, Laptop, Black, One Cable)"     ,"₹189","Rating:2/5", R.drawable.contwo),
            new Item("AmazonBasics Male to Female Stereo Audio Cable (Aux Extension Cable) with Gold Plated Connectors- 6 Feet (3.5mm)"     ,"₹399","Rating:4.5/5", R.drawable.conthree),
            new Item("NISHTECH Male to Male VGA Cable 1 Meter, Support PC/Monitor/LCD/LED, Plasma, Projector, TFT"     ,"₹199","Rating:3.5/5", R.drawable.confour),
            new Item("Storite VGA to HDMI with Power and Audio Compatible with Metal Connector, VGA to HDMI Cable- Unidirectional for Computer, Desktop Monitor, Projector, HDTV LCD/LED TV - (Grey,1.8M)"     ,"₹1,499","Rating:4/5", R.drawable.confive),
            new Item("Blendia HDMI-Male to HDMI-Female Gold Plated Connector for PC HDTV Projector Camera HDMI Adapter (Black) USB Adapter HDMI Cable (Computer, TV, Gaming Console, Black)"     ,"₹299","Rating:3/5", R.drawable.consix),
            new Item("Zeffcon® - Combo Pack of 10 Pc BNC Connector with Copper Wire Moulded - 18CM and 10 Pc DC Power Pigtail Male Cables with 2.1mm Connectors Barrel Jack for Surveillance CCTV Camera (White)"     ,"₹178","Rating:3.5/5", R.drawable.conseven),
            new Item("Sabrent 4-Port USB 2.0 Hub with Individual Power Switches and LEDs (HB-UMLS)"     ,"₹999","Rating:4.5/5", R.drawable.coneight),
            new Item("DTECH VGA to VGA 10m Cable Thin Flat Type VGA Cable Standard 15 Pin Male to Male VGA Wire for Computer Monitor 33 Feet"     ,"₹1,580","Rating:4.5/5", R.drawable.connine),
            new Item("Rebel Micro USB Female to USB Male Cable OTG for Morpho 1300 E2, E3, Fingerprint Scanner, Mantra, Morpho, Startek, Cogent to Laptop Pc Mobile and Tablet (Pack of 1)"     ,"₹139","Rating:4/5", R.drawable.conten),
            new Item("AmazonBasics HL-007289 RJ45 Cat7 Network Ethernet Patch/LAN Cable - 15 Feet (White)"     ,"₹709","Rating:4.5/5", R.drawable.coneleven),
            new Item("Storite 2 Pack Straight SATA III Data Cable Compatible for SATA HDD, SSD, CD Driver, CD Writer (61cm) - Red"     ,"₹269","Rating:4/5", R.drawable.contwelve),
            new Item("SATA III (Sata 3) Cable with Locking Latch + 4 Pin Molex to 15 Pin Power Cable Combo | (Pack of 1+1)"     ,"₹189","Rating:3.5/5", R.drawable.conthirteen),
            new Item("Storite 5 Pack Molex to SATA Cable, 15 Pin SATA to 4 Pin Molex Power Adapter Cable Cord for SATA Hard Drives and CD ROM Drives"     ,"₹299","Rating:4/5", R.drawable.confourteen),
            new Item("rts USB Hub 2.0 480Mbps USB Combo Card Reader All in One Multi USB Splitter for MS, M2, SD/MMC, TF Portable for PC Laptop Smart Tv Game and ETS"     ,"₹374","Rating:4/5", R.drawable.confifteen)
              );


    List<Item> Router_ITEMS = Arrays.asList(
            new Item("TP-Link AC750 Dual Band Wireless Cable Router, 4 10/100 LAN + 10/100 WAN Ports, Support Guest Network and Parental Control, 750Mbps Speed Wi-Fi, 3 Antennas (Archer C20)"     ,"₹1,499","Rating:4/5", R.drawable.routerone),
            new Item("TP-link N300 WiFi Wireless Router TL-WR845N | 300Mbps Wi-Fi Speed | Three 5dBi high gain Antennas | IPv6 Compatible | AP/RE/WISP Mode | Parental Control | Guest Network"     ,"₹1,199","Rating:4/5", R.drawable.routertwo),
            new Item("Mi Smart Router 4C, 300 Mbps with 4 high-Performance Antenna & App Control"     ,"₹999","Rating:4/5", R.drawable.routerthree),
            new Item("TP-Link Archer C6 Gigabit MU-MIMO Wireless Router, Dual Band 1200 Mbps Wi-Fi Speed, 5 Gigabit Ports, 4 External Antennas and 1 Internal Antenna WiFi Coverage with Access Point Mode, Qualcomm Chipset"     ,"₹2,499","Rating:4.5/5", R.drawable.routerfour),
            new Item("D-Link DIR-615 Wireless-N300 Router (Black, Not a Modem)"     ,"₹1,099","Rating:4/5", R.drawable.routerfive),
            new Item("D-Link DIR-650IN Wireless N300 Router (Black, Not a Modem)"     ,"₹1,098","Rating:4/5", R.drawable.routersix),
            new Item("TP-Link Archer C50 AC1200 Dual Band Wireless Cable Router, Wi-Fi Speed Up to 867 Mbps/5 GHz + 300 Mbps/2.4 GHz, Supports Parental Control, Guest Wi-Fi, VPN"     ,"₹1,999","Rating:4/5", R.drawable.routerseven),
            new Item("Mercusys MW325R 300Mbps Enhanced Wireless Wi-Fi WiFi Router | Four 5dBi High Gain Antennas | Coverage Upto 500 sq. ft | Parental Control | Guest Network | Advanced Encryption"     ,"₹949","Rating:4/5", R.drawable.routereight),
            new Item("MERCUSYS AC1200 Wireless Dual Band WiFi Router Mercusys AC10 | 1200 Mbps Wi-Fi Speed | 4 High Gain Antennas | Parental Control | IPTV and IPv6 Supported"     ,"₹1,599","Rating:4/5", R.drawable.routernine),
            new Item("Tenda N301 Wireless-N300 Easy Setup Router (White, Not a Modem)"     ,"₹899","Rating:4/5", R.drawable.routerten),
            new Item("D-Link DIR-819 Wireless AC750 Dual Band Router (Black, Not a Modem)"     ,"₹1,499","Rating:4/5", R.drawable.routereleven),
            new Item("TP-Link TL-WR820N 300 Mbps Speed Wireless WiFi Router, Easy Setup, IPv6 Compatible, Supports Parent Control, Guest Network, Multi-Mode Wi-Fi Router"     ,"₹897","Rating:4/5", R.drawable.routertwelve),
            new Item("Tenda AC10 AC1200 Wireless Smart Dual-Band Gigabit WiFi Router, MU-MIMO, 4 Gigabit Ports, 867Mbps/5 GHz+ 300Mbps /2.4GHz, Support VPN Server, WiFi Schedule, (Black, Not a Modem)"     ,"₹2,625","Rating:4/5", R.drawable.routerthirteen),
            new Item("Tenda AC5 AC1200 Dual Band WiFi Router 300Mbps 2.4G & 867Mbps 5G, 1GHZ CPU, APP Management, Easy Setup, MU-MIMO"     ,"₹1,699","Rating:4/5", R.drawable.routerfourteen),
            new Item("TP-Link N300 Wireless Ceiling Mount Access Point, Support PoE 802.3af/at and Direct Current, Easily Mount to Wall or Ceiling, Simply Managed by Free EAP Controller Software (EAP115)"     ,"₹2,599","Rating:4.5/5", R.drawable.routerfifteen)
    );


    List<Item> Gamepad_ITEMS = Arrays.asList(
            new Item("Redgear Pro Wireless Gamepad (Compatible with Windows 7/8/8.1/10 only)."     ,"₹1,699","Rating:4/5", R.drawable.gone),
            new Item("Redgear Zonik Wired Gamepad for PC Games."     ,"₹999","Rating:3.5/5", R.drawable.gtwo),
            new Item("Cosmic Byte C3070W Nebula 2.4G Wireless Gamepad for PC/PS3 supports Windows XP/7/8/10, Rubberized Texture."     ,"₹1,699","Rating:4/5", R.drawable.gthree),
            new Item("CLAW Shoot Wireless 2.4Ghz USB Gamepad Controller for PC Supports Windows XP/7/8/10 with Rubberized Textured Grip and Dual Vibration Motors."     ,"₹1,415","Rating:4/5", R.drawable.gfour),
            new Item("Hyperkin X91 Wired Gaming Controller - Red - for Xbox One and Windows 10 (PC and Tablet) via USB with Retro Design, 3.5mm Headset Jack, and 9 Ft. Cable."     ,"₹2,234","Rating:4/5", R.drawable.gfive),
            new Item("Elite Wireless Controller Series 2"     ,"₹22,899","Rating:4.5/5", R.drawable.gsix),
            new Item("GameSir T4W PC Controller Wired Game Controller for Windows 10/8.1/8/7 Dual Shock Game Gamepad"     ,"₹3,999","Rating:4/5", R.drawable.gseven),
            new Item("Cosmic Byte Callisto Wireless Gamepad with Programmable Buttons for Windows PC."     ,"₹1,339","Rating:4/5", R.drawable.geight),
            new Item("Redgear Elite Wireless Gamepad for PC Games(Black)"     ,"₹1,063","Rating:4/5", R.drawable.gnine),
            new Item("Logitech F310 Gamepad - AP (PC USB Cable Connection)."     ,"₹1,895","Rating:4.5/5", R.drawable.gten),
            new Item("Ant Esports GP100 Controller Joysticks for PC (Windows 7/8/8.1/10) / PS3 / Andriod/Steam Gaming Wired Gamepad."     ,"₹1,001","Rating:4/5", R.drawable.geleven),
            new Item("Quantum QHM7468 USB Gamepad with Dual Vibration (Black)"     ,"₹623","Rating:3.5/5", R.drawable.gtwelve),
            new Item("Live Tech Spy Gamepad for PC/Laptop/PS3, Wired Gaming Controller with Dual Vibration and Turbo, Joystick Game Controller Compatible with Windows 10/8/7/XP, Steam, Play Station 3, 1.7 M USB Cable."     ,"₹934","Rating:5/5", R.drawable.gthirteen),
            new Item("Turbo USB Dual Play Vibration Joystick Wired USB 2.0 PC Computer Gamepad Controller (Random Color)."     ,"₹650","Rating:5/5", R.drawable.gfourteen),
            new Item("Cosmic Byte C3070W Nebula 2.4G Wireless Gamepad for PC/PS3 supports Windows XP/7/8/10, Rubberized Texture"     ,"₹1,699","Rating:4/5", R.drawable.gfifteen)
    );



    List<Item> HardDrive_ITEMS = Arrays.asList(
            new Item("Seagate BarraCuda 1 TB Internal Hard Drive HDD – 3.5 Inch SATA 6 Gb/s 7200 RPM 64 MB Cache for Computer Desktop PC (ST1000DM010)"     ,"₹3,530","Rating:4/5", R.drawable.hardone),
            new Item("Western Digital WD10EZEX 1TB Internal Hard Drive for Desktop (Blue)"     ,"₹3,389","Rating:4/5", R.drawable.hardtwo),
            new Item("Consistent 1 TB Hard Disk for Desktop"     ,"₹2,990","Rating:3.5/5", R.drawable.hardthree),
            new Item("Western Digital WD 500GB 32MB Cache SATA 3.0Gb/s 3.5 Inch Internal Hard Drive (CCTV DVR, PC)"     ,"₹2,399","Rating:4/5", R.drawable.hardfour),
            new Item("Consistent Hard Disk 320GB, Desktop"     ,"₹1,199","Rating:3.5", R.drawable.hardfive),
            new Item("Toshiba 1TB Desktop 7200rpm Internal Hard Drive"     ,"₹3,300","Rating:4/5", R.drawable.hardsix),
            new Item("Blue Feather 500 Gb Surveillance Hard Disk Drive 3.5 Inch SATA | Indian Company | 2 Years Warranty |"     ,"₹1,768","Rating:4/5", R.drawable.hardseven),
            new Item("Seagate Barracuda 500GB Internal Hard Drive HDD – 2.5 Inch SATA 6 Gb/s 5400 RPM 128MB Cache for PC Laptop (ST500LM030)"     ,"₹3,739","Rating:4/5", R.drawable.hardeight),
            new Item("Western Digital Blue 4TB Internal Hard Drive (Western Digital40EZRZ)"     ,"₹9,999","Rating:4/5", R.drawable.hardnine),
            new Item("WD 320 GB AV-GP SATA 3 Gb/s Intellipower 8 MB Cache Bulk/OEM AV Hard Drive- WD3200AVVS"     ,"₹1,390","Rating:4/5", R.drawable.hardten),
            new Item("Western Digital Purple 2TB SATA Internal Surveillance Hard Drive (WD20PURZ)"     ,"₹4,999","Rating:4/5", R.drawable.hardeleven),
            new Item("Toshiba 2TB Desktop 7200rpm Internal Hard Drive"     ,"₹5,323","Rating:4/5", R.drawable.hardtwelve),
            new Item("Transcend TS1TSJ25M3S StoreJet 1TB Portable External Hard Drive (Gray)"     ,"₹5,199","Rating:4.5/5", R.drawable.hardthirteen),
            new Item("Transcend StoreJet 25H3P 2.5-inch 2TB Portable External Hard Drive (Purple)"     ,"₹6,403","Rating:4.5/5", R.drawable.hardfourteen),
            new Item("Western Digital WD 4TB My Passport Portable External Hard Drive, Black - with Automatic Backup, 256Bit AES Hardware Encryption & Software Protection"     ,"₹8,149","Rating:4.5/5", R.drawable.hardfifteen)
    );




    List<Item> Keyboard_ITEMS = Arrays.asList(
            new Item("Logitech MK270r Wireless Keyboard and Mouse Combo for Windows, 2.4 GHz Wireless, 3 Year Warranty, 8 Multimedia & Shortcut Keys, 2-Year Battery Life, PC/Laptop- Black"     ,"₹1,395","Rating:4/5", R.drawable.keyone),
            new Item("Redgear Shadow Blade Mechanical Keyboard with Spectrum LED Lights, Media Control Knob and Wrist Support (Black), Full Size (MK853)"     ,"₹2,499","Rating:4.5/5", R.drawable.keytwo),
            new Item("Zebronics ZEB-KM2100 Multimedia USB Keyboard Comes with 114 Keys Including 12 Dedicated Multimedia Keys & with Rupee Key"     ,"₹399","Rating:3.5/5", R.drawable.keythree),
            new Item("Dell KB216 Wired Multimedia USB Keyboard"     ,"₹618","Rating:4.5/5", R.drawable.keyfour),
            new Item("HP 100 Wired USB Keyboard"     ,"₹599","Rating:4.5/5", R.drawable.keyfive),
            new Item("Cosmic Byte CB-GK-02 Corona Wired Gaming Keyboard, 7 Color RGB Backlit with Effects, Anti-Ghosting (Black)"     ,"₹1,284","Rating:4/5", R.drawable.keysix),
            new Item("Logitech Plug and Play USB Keyboard K120"     ,"₹585","Rating:4.5/5", R.drawable.keyseven),
            new Item("Quantum QHM-7406 Full-Sized Keyboard with (₹) Rupee Symbol, Hotkeys and 3-pieces LED function for Desktop/Laptop/Smart TV Spill-Resistant Wired USB Keyboard with 10 million keystrokes lifespan (Black)"     ,"₹372","Rating:4/5", R.drawable.keyeight),
            new Item("HP K500F Gaming Keyboard (7ZZ97AA)"     ,"₹1,234","Rating:4.5/5", R.drawable.keynine),
            new Item("Amkette Xcite Pro USB Keyboard (Black)"     ,"₹449","Rating:4/5", R.drawable.keyten),
            new Item("Evo Fox (by Amkette) Fireblade Gaming Wired Keyboard with LED Backlit, 19 Anti-Ghosting Keys and Windows Lock Key (TKL) (Black)"     ,"₹999","Rating:4/5", R.drawable.keyeleven),
            new Item("Redgear Grim Wired Semi-Mechanical RGB Backlit Gaming Keyboard with Floating Key Cap and Double Injection keycaps for PC Gaming"     ,"₹799","Rating:4/5", R.drawable.keytwelve),
            new Item("Live Tech Evon Wired Gaming Combo with LED Backlit Keyboard & Mouse (Gold Plated USB, Braided Cable)"     ,"₹895","Rating:4/5", R.drawable.keythirteen),
            new Item("iBall Winner V2.0 Wired USB Desktop Keyboard (Black)"     ,"₹355","Rating:4/5", R.drawable.keyfourteen),
            new Item("i GEAR KeyBee Retro Typewriter Inspired 2.4GHz Wireless Keyboard and Mouse Combo with USB Support, Single Nano Receiver, Round Keycaps, Cleaning Brush (Black Pink)"     ,"₹2,750","Rating:4/5", R.drawable.keyfifteen)
               );



    List<Item> Mouse_ITEMS = Arrays.asList(
            new Item("Logitech M221 Wireless Mouse, Silent Buttons, 2.4 GHz with USB Mini Receiver, 1000 DPI Optical Tracking, 18-Month Battery Life, Ambidextrous PC/Mac/Laptop - Charcoal Grey"     ,"₹745","Rating:4.5/5", R.drawable.mouseone),
            new Item("elevn ergo11 2.4GHz Premium Wireless Optical Mouse for Laptop, Desktop, PC, MacBook – Black"     ,"₹499","Rating:4.5/5", R.drawable.mousetwo),
            new Item("HP X1000 Wired Mouse (Black/Grey)"     ,"₹349","Rating:4.5/5", R.drawable.mousethree),
            new Item("Lenovo 300 Wired Plug & Play USB Mouse, High Resolution 1600 DPI Optical Sensor, 3-Button Design with clickable Scroll Wheel, Ambidextrous, Ergonomic Mouse for Comfortable All-Day Grip (GX30M39704)"     ,"₹249","Rating:4.5/5", R.drawable.mousefour),
            new Item("Zebronics Zeb-Transformer-M Optical USB Gaming Mouse with LED Effect(Black)"     ,"₹424","Rating:4.5/5", R.drawable.mousefive),
            new Item("Dell MS116 1000DPI USB Wired Optical Mouse"     ,"₹259","Rating:4.5/5", R.drawable.mousesix),
            new Item("Redgear A-15 Wired Gaming Mouse with RGB, Semi-Honeycomb Design and Upto 6400 dpi for Windows PC Gamers"     ,"₹499","Rating:4.5/5", R.drawable.mouseseven),
            new Item("QUANTUM QHM262W Nano USB 2.4 Ghz Receiver Cordless Wireless Mouse (Black and Grey)"     ,"₹325","Rating:3.5/5", R.drawable.mouseeight),
            new Item("Redgear A-10 Wired Gaming Mouse with LED, Lightweight, Durable and DPI Upto 2400 for Windows PC Gamers."     ,"₹349","Rating:4.5/5", R.drawable.mousenine),
            new Item("Quantum QHM222 3-Button 1000DPI Wired Optical Mouse (Black)"     ,"₹149","Rating:3.5/5", R.drawable.mouseten),
            new Item("Zebronics Zeb-Alex Wired USB Optical Mouse with 3 Buttons"     ,"₹210","Rating:4/5", R.drawable.mouseeleven),
            new Item("HP 200 Wireless Mouse (Black)"     ,"₹699","Rating:4.5/5", R.drawable.mousetwelve),
            new Item("iBall FreeGo G20 Wireless Optical Mouse (Black)"     ,"₹479","Rating:4/5", R.drawable.mousethirteen),
            new Item("AmazonBasics Compact Ergonomic Wireless PC Mouse with Fast Scrolling - Black"     ,"₹1,042","Rating:4/5", R.drawable.mousefourteen),
            new Item("Logitech G502 Hero High Performance Wired Gaming Mouse, Hero 16K Sensor, 16,000 DPI, RGB, Adjustable Weights, 11 Programmable Buttons, On-Board Memory, PC/Mac - Black"     ,"₹4,295","Rating:4.5/5", R.drawable.mousefifteen)
               );



    List<Item> Processor_ITEMS = Arrays.asList(
            new Item("Intel® Coreâ¢ i5-10400F Processor (12M Cache, up to 4.30 GHz)"     ,"₹16,500","Rating:4.5/5", R.drawable.proone),
            new Item("Intel® Core™ i7-9700K Processor (12M Cache, up to 4.90 GHz)"     ,"₹27,699","Rating:5/5", R.drawable.protwo),
            new Item("AMD Athlon 3000G with Radeon Vega 3 Graphics Desktop Processor 2 Cores 3.5GHz 5MB Cache AM4 Socket (YD3000C6FHBOX)"     ,"₹7,999","Rating:4.5/5", R.drawable.prothree),
            new Item("AMD Ryzen 7 3700X Desktop Processor 8 Cores up to 4.4GHz 36MB Cache AM4 Socket (100-100000071BOX)"     ,"₹32,600","Rating:5/5", R.drawable.profour),
            new Item("AMD Ryzen 3 3200G with RadeonVega 8 Graphics Desktop Processor 4 Cores up to 4GHz 6MB Cache AM4 Socket (YD320GC5FHBOX)"     ,"₹14,000","Rating:4.5/5", R.drawable.profive),
            new Item("AMD Ryzen 5 3500X Desktop Processor 6 cores up to 4.1GHz 35MB Cache AM4 Socket (100-100000158BOX)"     ,"₹16,900","Rating:4.5/5", R.drawable.prosix),
            new Item("Intel Core i3-2120 2nd Gen Desktop Processor 3.5 GHz LGA 1151"     ,"₹2,500","Rating:5/5", R.drawable.proseven),
            new Item("Quantum QHM6056B Thin Client with 1 GHz Dual-Core (A7) Processor, 512 MB RAM with 4GB ROM | Energy Saving, high-Powered Performance Zero lags (Black)"     ,"₹2,374","Rating:3.5/5", R.drawable.proeight),
            new Item("INTEL Pentium Processor G2010 3M Cache, 2.80 GHz LGA1155, Dual Core and Ivy Bridge(BX80637G2010)"     ,"₹2,000","Rating:4/5", R.drawable.pronine),
            new Item("InfCloud 3M Cache, 3.40 GHz Intel i3-3240 Processor (LGA 1155)\n"     ,"₹2,899","Rating:4/5", R.drawable.proten),
            new Item("AMD Ryzen 7 2700X Desktop Processor 8 Cores up to 4.3GHz 20MB Cache AM4 Socket (YD270XBGAFBOX)"     ,"₹26,499","Rating:5/5", R.drawable.proeleven),
            new Item("AMD 3000 Series Ryzen 7 3800XT Desktop Processor 8 cores 16 Threads 36MB Cache 3.9GHz Upto 4.7GHz AM4 Socket 400 & 500 Series Chipset (100-100000279WOF)"     ,"₹34,900","Rating:5/5", R.drawable.protwelve)
           );




    List<Item> RAM_ITEMS = Arrays.asList(
            new Item("Crucial RAM 8GB DDR4 2666 MHz CL19 Laptop Memory CT8G4SFRA266"     ,"₹3,266","Rating:4.5/5", R.drawable.ramone),
            new Item("Crucial Ballistix 2666 MHz DDR4 DRAM Desktop Gaming Memory Kit 32GB (16GBx2) CL16 BL2K16G26C16U4R (RED)"     ,"₹13,950","Rating:4.5/5", R.drawable.ramtwo),
            new Item("HyperX Fury 8GB 3200MHz DDR4 CL16 DIMM 1Rx8  Black XMP Desktop Memory (HX432C16FB3/8)"     ,"₹4,530","Rating:4.5/5", R.drawable.ramthree),
            new Item("Corsair Vengeance LPX 8GB (1x8GB) DDR4 3200MHZ C16 Desktop RAM (Black)"     ,"₹4,479","Rating:4.5/5", R.drawable.ramfour),
            new Item("G.SKILL Trident Z RGB 16GB (2 * 8GB) DDR4 3200 MHz CL16-18-18-38 1.35V Desktop Memory RAM - F4-3200C16D-16GTZR"     ,"₹11,600","Rating:5/5", R.drawable.ramfive),
            new Item("Corsair Vengeance LPX 16GB (2x8GB) DDR4 DRAM 3200MHz C16 Desktop Memory Kit - Black (CMK16GX4M2B3200C16)"     ,"₹18,725","Rating:4.5/5", R.drawable.ramsix),
            new Item("XPG ADATA GAMMIX D30 DDR4 8GB (1x8GB) 3200MHz U-DIMM Desktop Memory -AX4U320038G16A-SR30"    ,"₹4,074","Rating:4.5/5", R.drawable.ramseven),
            new Item("Ballistix RGB 3000 MHz DDR4 DRAM Desktop Gaming Memory Kit 16GB (8GBx2) CL15 BL2K8G30C15U4RL (RED)"     ,"₹8,470","Rating:4.5/5", R.drawable.rameight),
            new Item("Simmtronics 4GB DDR3 Desktop RAM 1333 MHz (PC 10600) with 3 Year Warranty"     ,"₹2,348","Rating:4/5", R.drawable.ramnine),
            new Item("G.SKILL Trident Z RGB 16GB (2 * 8GB) 4133 MHz DDR4 Desktop Memory RAM - F4-4133C19D-16GTZKW"     ,"₹14,143","Rating:5/5", R.drawable.ramten),
            new Item("Alketron DDR2 2GB RAM for Desktop PC | 2GB 800MHz Long-DIMM CL-6"     ,"₹565","Rating:4/5", R.drawable.rameleven),
            new Item("Kingston ValueRAM 8GB 2400MHz DDR4 Non-ECC CL17 DIMM 1Rx8 Desktop Memory KVR24N17S8 8"     ,"₹3,998","Rating:4/5", R.drawable.ramtwelve),
            new Item("XPG HyperX Kingston Technology Impact 8GB 3200MHz DDR4 CL20 SODIMM Memory HX432S20IB2/8, Black (8GB DDR 4 3200MHZ)"     ,"₹5,879","Rating:4.5/5", R.drawable.ramthirteen),
            new Item("Corsair Vengeance 8GB DDR3 Memory Kit (CMZ8GX3M1A1600C10)"     ,"₹3,890","Rating:4.5/5", R.drawable.ramfourteen),
            new Item("G.SKILL Ripjaws V 16GB (1 * 16GB) DDR4 3200 MHz CL16-18-18-38 1.35V Desktop Memory RAM - F4-3200C16S-16GVK"     ,"₹8,628","Rating:4.5/5", R.drawable.ramfifteen)
    );






    List<Item> SMPS_ITEMS = Arrays.asList(
            new Item("Zebronics 450 W Power Supply SMPS"     ,"₹699","Rating:3.5/5", R.drawable.smpsone),
            new Item("Artis VIP400R+ 400W SMPS/Power Supply Unit"     ,"₹719","Rating:4/5", R.drawable.smpstwo),
            new Item("Artis 500 Watt Super Silent Gaming PC SMPS/Power Supply Unit"     ,"₹2,089","Rating:4/5", R.drawable.smpsthree),
            new Item("Live Tech 450 Watt Economic Series Power Supply Model PS450W (SMPS with 20+4 pin)"     ,"₹699","Rating:4/5", R.drawable.smpsfour),
            new Item("Clarion 800 Watts SMPS JM-PS-920"     ,"₹1,499","Rating:4.5/5", R.drawable.smpsfive),
            new Item("CIRCLE Desktop Power Supply SMPS (CPH698)"     ,"₹1,320","Rating:4/5", R.drawable.smpssix),
            new Item("iBall 230 V AC SMPS ATX Computer Power Supply (ZPS-281)"     ,"₹999","Rating:4/5", R.drawable.smpsseven),
            new Item("Corsair VS Series VS500 80 Plus Certified Non-Modular ATX Power Supply"     ,"₹3,420","Rating:4.5/5", R.drawable.smpseight),
            new Item("Corsair CV450, CV Series, 80 Plus Bronze Certified, 450 Watt Non-Modular Power Supply - Black"     ,"₹3,350","Rating:4.5/5", R.drawable.smpsnine),
            new Item("Frontech PS-0005 Computer Power Supply as 230V/450W SMPS"     ,"₹607","Rating:4/5", R.drawable.smpsten),
            new Item("Ant Esports VS500L Power Supply"     ,"₹1898","Rating:4.5/5", R.drawable.smpseleven),
            new Item("Enter E-500B 500-Watt Computer Power Supply (Black)"     ,"₹729","Rating:3.5/5", R.drawable.smpstwelve),
            new Item("DIGIBYTE 8Channel Multi Port CCTV SMPS Power Supply (12 Volt 10 Amp. Heavy Industrial Quality, 2Year Warranty)"     ,"₹549","Rating:4.5/5", R.drawable.smpsthirteen),
            new Item("Zebronics Gaming High Efficiency 500watts Power Supply with 80+ Certification, Comes with Dual PCIe and Long Cables - PGP500W"     ,"₹3,055","Rating:4.5/5", R.drawable.smpsfourteen),
            new Item("Corsair RM1000x 1000 W 80+ Gold Certified Modular Power Supply Unit - Black"     ,"₹19,040","Rating:4/5", R.drawable.smpsfifteen)

    );




    List<Item> Speaker_ITEMS = Arrays.asList(
            new Item("Zebronics Zeb Wonderbar 10 USB Powered 2.0 Computer Speaker with RGB "     ,"₹899","Rating:4/5", R.drawable.speakerone),
            new Item("ZEBRONICS Zeb-Warrior II 2.0 Speaker for PC, Laptops, Desktop with RGB Lights, USB Powered, AUX Input, Volume Control Pod."     ,"₹699","Rating:4/5", R.drawable.speakertwo),
            new Item("AmazonBasics USB-Powered PC Computer Speakers with Dynamic Sound | Black"     ,"₹1,099","Rating:4.5/5", R.drawable.speakerthree),
            new Item("iBall Decor 9-2.0 USB Powered Computer Multimedia Speakers with in-line Volume Controller, Black"     ,"₹600","Rating:4/5", R.drawable.speakerfour),
            new Item("Creative Pebble 2.0 USB-Powered Desktop Speakers with Far-Field Drivers and Passive Radiators for PCs and Laptops (Black)"     ,"₹1,839","Rating:4.5/5", R.drawable.speakerfive),
            new Item("Zinq Technologies Beast Portable Laptop/Desktop USB 2.0 Powered Multimedia Speaker with AUX Input, deep bass, LED Lights, 3.5mm Audio Input (Black)"     ,"₹449","Rating:4/5", R.drawable.speakersix),
            new Item("HP Multimedia USB 2.0 Speaker DHS-2101 with 3.5mm Audio Jack for Extra Connectivity"     ,"₹1,499","Rating:4.5/5", R.drawable.speakerseven),
            new Item("HP Multimedia DHS-2101 HD Speaker with 3.5mm Audio Jack for Desktop Office Home Stereo Small Speaker"     ,"₹1,450","Rating:4/5", R.drawable.speakereight),
            new Item("Artis Mini 2.0 USB Multimedia Speakers (Red)"     ,"₹399","Rating:4/5", R.drawable.speakernine),
            new Item("havit SK563 2.0 Stereo PC Gaming Speakers with Dynamic RGB Light, Black"     ,"₹879","Rating:5/5", R.drawable.speakerten),
            new Item("Zebronics Zeb-S999 2.0 Multimedia Speaker with Aux Connectivity,USB Powered and Volume Control"     ,"₹629","Rating:4/5", R.drawable.speakereleven),
            new Item("Terabyte E-02B 2.0 Multimedia Computer Speakers for Laptop, PC, MP3/MP4 Players Black"     ,"₹350","Rating:4/5", R.drawable.speakertwelve),
            new Item("Zebronics S990 Speakers"     ,"₹529","Rating:4/5", R.drawable.speakerthirteen),
            new Item("Live Tech SP08 Black Wooden USB Speakers with Rich Bass Experience for Multimedia Devices (Black)"     ,"₹440","Rating:3.5/5", R.drawable.speakerfourteen),
            new Item("elevn max 2.0 USB Powered Computer Multimedia Speakers with AUX and in-line Volume Controller (Black)\n"     ,"₹549","Rating:4.5/5", R.drawable.speakerfifteen)

            );
}
