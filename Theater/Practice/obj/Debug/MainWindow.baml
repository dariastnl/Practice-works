   M S B A M L   `   `   `  ����C  ?Practice, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null#clr-namespace:PracticePractice  5   G       Practice.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35a ]DevExpress.Xpf.Core.v19.2, Version=19.2.5.0, Culture=neutral, PublicKeyToken=b88d1754d700e49aW SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   b ^MaterialDesignThemes.Wpf, Version=4.1.0.2556, Culture=neutral, PublicKeyToken=df2a72020bd7962aFmaterialDesign1http://materialdesigninxaml.net/winfx/xaml/themes  5   	   ;dx2http://schemas.devexpress.com/winfx/2008/xaml/core  5      "localclr-namespace:Practice  6G   k gDevExpress.Xpf.ReportDesigner.v19.2, Version=19.2.5.0, Culture=neutral, PublicKeyToken=b88d1754d700e49aNdxrudBhttp://schemas.devexpress.com/winfx/2008/xaml/reports/userdesigner  5   	   f bDevExpress.Xpf.PdfViewer.v19.2, Version=19.2.5.0, Culture=neutral, PublicKeyToken=b88d1754d700e49a=dxpdf1http://schemas.devexpress.com/winfx/2008/xaml/pdf  6Z   `	 \DevExpress.Xpf.Map.v19.2, Version=19.2.5.0, Culture=neutral, PublicKeyToken=b88d1754d700e49a;dxm1http://schemas.devexpress.com/winfx/2008/xaml/map 	 6�     � Title$  
MainWindow��5
   	   $	��818��6   $
��1308��6)    � WindowStartupLocation$ CenterScreen=�66    � WindowStyle$
 None=�6[    � 
ResizeMode$ NoResize=�6n   .��5      � -   5        ���	#FFBCBFAD.+�5   
   �� -   5         ��Name$ LeftMenu��5       �� Orientation$ Vertical=�6'   $��80��6>   $
��Left=�6I   ���	#FF1B1C13 � 	Resources 5       �� 
TargetType �� Property	 �� Value��%w   '��       �� 5      " ��6   .�5      ��  � ��$		 100��6/   �� 5       � ��$	 80��6.   5      5      .+�5      � 
 � RowDefinitions
 5      �� 5      $��1* �6$   �� 5      $��1* �6$   �� 5      $��1* �6$   �� 5      $��1* �6$   �� 5      $��1* �6$   �� 5       $��1* �6$   �� 5!      $��1* �6$   �� 5"      $��1* �6$   .+�5$      �� -   5         ��Name$ Employments_bt��5$   &   $��0��6   
�������$��	0,120,0,0q�6~   ��6>   Z� ��6g   Z� .��5%      �� .+�5&      �� $��/Images/employments.png��6    $��50��6A   �� 5'      $	��Job��6$   $��Center=�6/   5(      5)      �� 5*      -   5        $ 	Actors_bt��5*   &   $��1��6   
���������69   Z� ��6b   Z� .��5+      �� .+�5,      �� $��/Images/actors.png��6    $��50��6<   �� 5-      $��Actors��6$   $��Center=�62   5.      5/      �� 50      -   5        $ Ranks_bt��50   &   $��2��6   
���������68   Z� ��6a   Z� .��51      �� .+�52      �� $��/Images/ranks.png��6    $��50��6;   �� 53      $��Ranks��6$   $��Center=�61   54      55      �� 56      -   5        $ Shows_bt��56   &   $��3��6   
���������68   Z� ��6a   Z� .��57      �� .+�58      �� $��/Images/shows.png��6    $��50��6;   �� 59      $��Shows��6$   $��Center=�61   5:      5;      �� 5<      -   5        $ 	Genres_bt��5<   &   $��4��6   
���������69   Z� ��6b   Z� .��5=      �� .+�5>      �� $��/Images/genres.png��6    $��50��6<   �� 5?      $��Genres��6$   $��Center=�62   5@      5A      �� 5B      -   5        $ Users_bt��5B   &   $��5��6   
���������68   Z� ��6a   Z� .��5C      �� .+�5D      �� $��/Images/users.png��6    $��50��6;   �� 5E      $��Users��6$   $��Center=�61   5F      5G      �� 5H      -	   5        $ View_bt��5H   &   $��6��6   
���������67   Z� ��6`   Z� .��5I      �� .+�5J      �� $��/Images/eye.png��6    $��50��69   �� 5K      $
��View��6$   $��Center=�60   5L      5M      5T      5U      � 5W   
   -
   5         �Name$ TopGrid��5W      $	��Top=�6    $	��100��68   $��0,10,0,0q�6E   ���	#FF2F3224 J� Opacity$	 0.9Q�6n    � ColumnDefinitions 5X      �� 5Y      �� 5Z      �� 5[      .+�5]      �� $��0��6   $ 
Horizontal=�6)   $��Center=�6B   $��Center=�6_   .+�5^      '  !MaterialDesignThemes.Wpf.PackIcon     Kind$ Search=�6*   $��35��68   $��35��6D   
�������6O   �� 5_      -   5         ��Name$ Search��5_      
�������$��Ubuntu Mono)�6=   $��20(�6V   )  #MaterialDesignThemes.Wpf.HintAssist   Hint$  Search for performances...��6{    �� SelectionBrush �	#FFBCBFAD��6d   Z� ��6�   Z�  �� 
CaretBrush 6�   Z� 6�   5`      �� 5a      -   5        $ ControlButtons��5a   )   $��2��6   $	��Top=�6A   $��Right=�6Y   $ Vertical=�6u   .+�5b      �� -   5        $ Close��5b       � ToolTip$ Close��6(   
������ $��60��6Q   
������ .��5c        $ 
CloseThick=�6.   
�������$��25��6S   $��25��6^   5d      �� 5e      -   5        $ Minimize��5e      $ Minimize��6+   
������ $��60��6Z   
������ .��5f        $ WindowMinimize=�6.   
�������$��25��6W   $��25��6b   5g      �� 5h      -   5        $ Restore��5h      $ Restore��6*   
������ $��60��6U   
������ .��5i        $ WindowRestore=�6.   
�������$��25��6V   $��25��6a   5j      5k      �� 5l      $ Vertical=�6   $��2��60   $��Center=�6@   .+�5m      �� -   5         ��Name$ AddName��5m      $�� ��6-   $��Ubuntu Moto)�66   $��40(�6O   
�������$��2��6p   $��Center=�6�   5n      �� 5o      $
��Left=�6   $��5,5,0,43q�64   .+�5p      �� -   5        $ About��5p      
������ $��50��6A   $��65��6M   .��5q      �� $��/Images/info.png��6   $��30��66   5r      5s      �� 5t      $��1��6   $ Vertical=�6)   .+�5u      �� -   5        $ 
Request_bt��5u      ���	#FFBCBFAD$��Center=�6D   $	��250��6a   $��30��6m   
����������	#FF9E9E9E$��Ubuntu Mono)�6�   $��22(�6�   $��0,10,0,0q�6�   .��5v      �� $��Cheap shows��6    5w      5x      5y      &   System.Windows.Controls.DataGrid  5{   
   -   5          Name$ 
MyDataGrid��5{      $	��596��6'   $
��1127��64   $��Bottom=�6A   $
��Left=�6\   $��
130,0,0,45q�6w   ���	#FFF2F2EF6�   �� 5|   
   -   5        $ OperationPanel��5|      $ 
Horizontal=�6-   $
��Left=�6F   $��Center=�6a   $
��1128��6|   $��129,136,0,652q�6�   .+�5}      �� -   5        $ Add_bt��5}      ���	#FF3D4032$��50��6<   $��30��6G   
����������	#FF9E9E9E$��0,0,10,0q�6�   .��5~        $
 Edit=�6*   $��20��66   $��20��6A   $��Center=�6M   5      �� 5�      -   5        $ 	Delete_bt��5�      ���	#FF3D4032$��50��6?   $��30��6J   $��0,0,10,0q�6n   .��5�        $ Delete=�6*   $��20��68   $��20��6C   
�������6O   5�      �� 5�      -   5        $ Save_bt��5�      ���	#FF3D4032$��50��6=   $��30��6H   $��0,0,10,0q�6j   .��5�        $ ContentSave=�6*   $��20��6=   $��20��6H   
�������6T   5�      5�      �� 5�   
   $ Vertical=�6   $	��596��6,   $
��1127��69   $��Bottom=�6F   $
��Left=�6a   $��
130,0,0,45q�6|   .+�5�      �� -   5        $ first_tb��5�      $��Welcome to the Theatre!��6*   $��Ubuntu Mono)�6I   $��70(�6b   
�������$y�Hidden=�6�   �� 5�      -   5        $ 	second_tb��5�      $��Where we are?��6+   $��Ink Free)�6@   $��70(�6V   ���	#FF3D4032$y�Hidden=�6{   # 	 DevExpress.Xpf.Map.MapControl  5�      -   5          Name$	 Map��5�         	ZoomLevel$ 4Q�6*   $	��430��68   $y�Hidden=�6E      MiniMap 5�        	 DevExpress.Xpf.Map.MiniMap  5�         	Alignment$ TopRight=�6"      Behavior 5�      - 	 'DevExpress.Xpf.Map.FixedMiniMapBehavior  5�         CenterPoint* 	 $DevExpress.Xpf.Map.GeoPointConverter$ 45, 18 67      Layers. 5�      / 	 )DevExpress.Xpf.Map.MiniMapImageTilesLayer     DataProvider. 5�      ,	 	 &DevExpress.Xpf.Map.BingMapDataProvider	   	  BingKey$ YOUR BING KEY��66   5�      5�          Layers.  5�      #
 	 DevExpress.Xpf.Map.ImageLayer
  ! 
  DataProvider! 5�      	  5�      $ YOUR BING KEY��62   5�      5�      5�      �� 5�   
   -   5        $ 	Backup_bt��5�      ���	#FF3D4032$��Right=�6;   $��50��6W   $��30��6b   
����������	#FF9E9E9E$��0,136,107,652q�6�   .��5�        $ Backup=�6&   $��20��64   $��20��6?   $��Center=�6K   5�      �� 5�   
   -   5        $ 	Report_bt��5�      ���	#FF3D4032$��Right=�6;   $��50��6W   $��30��6b   
����������	#FF9E9E9E$��0,136,51,652q�6�   .��5�        $ 
FileReport=�6&   $��20��68   $��20��6C   $��Center=�6O   5�      /  )DevExpress.Xpf.PdfViewer.PdfViewerControl  5�   
   -   5        "  Name$" RepView��5�   !   $	��596��62   $
��1127��6?   $��Bottom=�6L   $
��Left=�6g   $��
130,0,0,45q�6�   $y�Hidden=�6�   5�      5�      