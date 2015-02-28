����   3 �  UI  javax/swing/JComponent board LGameManager; x LPlayer; y turn Z 
winnerName Ljava/lang/String; againstComp <init> (LGameManager;)V Code
     ()V  Player  %What is the name of the first player?
    javax/swing/JOptionPane   showInputDialog &(Ljava/lang/Object;)Ljava/lang/String;
     ! (ILjava/lang/String;)V	  #   % ,Would you like to play against the computer? ' 	Question.
  ) * + showOptionDialog t(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;IILjavax/swing/Icon;[Ljava/lang/Object;Ljava/lang/Object;)I - AIPlayer / Artificial Intelligence
 ,  	  2 	 	  4   6 &What is the name of the second player?
 8 : 9 GameManager ; < 
setPlayer1 (LPlayer;)V
 8 > ? < 
setPlayer2	  A  	  C 
  E No one.	  G   LineNumberTable LocalVariableTable this LUI; GM StackMapTable reset
  P Q R getName ()Ljava/lang/String; name U java/lang/String isAgainstComp ()Z 	getPlayer (I)LPlayer; i I getGM ()LGameManager; 
changeTurn 
isFinished
 8 a b c getBoard ()[[LPlayer;
  e f g getID ()I playerArena 
[[LPlayer; j o diagonal diagonalBack vertical 
horizontal t testerVertical testerHorizontal testerDiagonal i paintComponent (Ljava/awt/Graphics;)V x java/awt/Graphics2D z java/awt/RenderingHints	 y | } ~ KEY_RENDERING Ljava/awt/RenderingHints$Key;	 y � � � VALUE_RENDER_QUALITY Ljava/lang/Object;
 y �  � 2(Ljava/awt/RenderingHints$Key;Ljava/lang/Object;)V	 y � � ~ KEY_ANTIALIASING	 y � � � VALUE_ANTIALIAS_ON
 y � � � put 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
 w � � � setRenderingHints (Ljava/util/Map;)V �yInstructions: 
 Player one either faces a human opponent or an Artificial Intelligence, indicated either by an inputted name or by 'Artificial Intellingence'. 
 The objective of the game is to get four tokens in a row, either horizontally, vertically, or diagonally. 
 To play, the user(s) must press a number between 1 and 7 or click on a column corresponding to the column the user wishes to drop a token in. 
 After alternating turns, a player will emerge victorious after they have lined up four tokens. 
 The game can be reset by pressing the 'r' key on the keyboard. 
 Enjoy! 
 Produced by BigDaddyStudios (AKA Rohin Bhargava). � 

 T � � � split '(Ljava/lang/String;)[Ljava/lang/String;
 w � � � getFontMetrics ()Ljava/awt/FontMetrics;
 � � � java/awt/FontMetrics � g 	getHeight
 w � � � 
drawString (Ljava/lang/String;II)V
 w � � � drawRect (IIII)V	 � � � java/awt/Color � � YELLOW Ljava/awt/Color;
 w � � � setColor (Ljava/awt/Color;)V
 w � � � fillRect	 � � � � BLACK
 w � � � drawOval	 � � � � RED
 w � � � fillOval	 � � � � WHITE
  � _ W � java/lang/StringBuilder � Player 
 � �  � (Ljava/lang/String;)V
 � � � � append (I)Ljava/lang/StringBuilder; � : 
 � � � � -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 � � � R toString
 T � �  valueOf � 	 has won! g Ljava/awt/Graphics; g2 Ljava/awt/Graphics2D; rh Ljava/awt/RenderingHints; yPos line id � java/awt/Graphics � [Ljava/lang/String; 
SourceFile UI.java InnerClasses � java/awt/RenderingHints$Key Key !                 	     
                      �     r*� *� Y� � � "$&� (� *� ,Y.� 0� 1*� 3� *� Y5� � � 1*� 3+*� "� 7+*� 1� =*+� @*� B*D� F�    H   :         %  3  8  ;  L  Q ! Y " a # f $ k % q & I       r J K     r L   M    � ;   8    N      �     0*� 1� OL*� 1� ,� *� ,Y+� 0� 1� *� Y+� � 1�    H       *  +  , " . / / I       0 J K    ( S   M   	 � " T  V W     /     *� 3�    H       3 I        J K    X Y     T     � *� "�*� 1�    H       8  9 
 : I        J K      Z [  M    
  \ ]     /     *� @�    H       ? I        J K    ^      U     *� B� *� B� *� B�    H       D  E  G  H I        J K   M      _ W    �    *� @� `L=� >� �+22:� �66666	� �� "+	`22:

� 
� d� d� �� "+2	`2:

� 
� d� d� �� *� %+	`2	`2:

� 
� d� d� �� *� %+	`2	d2:

� 
� d� d� ��		��Z� � � 	� *� O� F��+2����+��� �    H   � !   L  M  N  P  Q  S ! T $ U ' V * W 0 Z 5 \ ? ] Q ^ T a Y c c d u e x h � j � k � l � o � q � r � s � W � v � x � y � N M } I   �    J K   
 h i  
 Z [   � j [   � k   ! � l [  $ � m [  ' � n [  * � o [  - � p [ 	 ?  q  
 c  r  
 �  s  
 �  s  
 M   ? �  t� �  
  t   ##++� � 
   t  � 
  u v    �  	  +� wM� yY� {� � �N-� �� �� �W,-� �6��� �Y:�66� "2:,,� �� �`Y6� �����, � ��'� �,� �� �, � ��&� �6� �6� �,� �� �, �Zh` �Zh`QQ� �*� @� `22� [*� @� `22� d*� "� d� 
,� �� �, �Zh`�ZhdPP� �, �Zh`�ZhdPP� ç $,� ƶ �, �Zh`�ZhdPP� Ä*� @� `2���G�*� @� `���16:*� B� ,� �� �*� "� d6*� "� O:� ,� �� �*� 1� d6*� 1� O:*� ɚ +,� �Yͷ �� �ֶ �� ض � � �� �� B*� F*� "� O� ,� �� �� 
,� �� �,� �Y*� F� ޷ �� ض � � �� ��    H   � *   �  �  �  � # � ' � A � V � ` � p � w � � � � � � � � � � � � � � � � � � � � �# �= �O �_ �b �e �l �s �| �� �� �� �� �� �� �� �� �� �� � � I   f 
   J K     � �   � �  � � �  '� � [  A  �   � � Z [  � � j [ b � � [ e � S   M   J � : 	  � w y  �  � 3   � w y  � � Q6 � � 5 T.  �    � �   
  � y �	