   M S B A M L   `   `   `  ����C  ?Practice, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null#clr-namespace:PracticePractice  5   	       Practice.Login   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35a ]DevExpress.Xpf.Core.v19.2, Version=19.2.5.0, Culture=neutral, PublicKeyToken=b88d1754d700e49aW SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   (localclr-namespace:Practice     5   	   b ^MaterialDesignThemes.Wpf, Version=4.1.0.2556, Culture=neutral, PublicKeyToken=df2a72020bd7962aFmaterialdesign1http://materialdesigninxaml.net/winfx/xaml/themes  6.     � Title$  Login��5   	   $	��600��6   $	��450��6$    � WindowStartupLocation$ CenterOwner=�60    � 
ResizeMode$ NoResize=�6T    � WindowStyle$
 None=�6j   ���	#FF838579.��5	      � ���	#FFF2F2EF � RowDefinitions 5
   
   �� 5      $��1* �6   �� 5      $
��0.5* �6   �� 5      $
��0.5* �6   �� 5      $��1* �6   .+�5   
   �� $��Welcome!��6   ���	#FF4B5040$��Ubuntu Mono)�6;   $��80(�6T   $��Center=�6b   $��Center=�6   6�   �� 5   
   -   5         ��Name$ Username��5      $��1��6$   ���	#FF4B5040$��65��6H   $	��340��6T    J� Opacity$	 0.5Q�6`   )  #MaterialDesignThemes.Wpf.HintAssist   Hint$ Username��6n   
�������$��30(�6�   $��Center=�6�   $��Ubuntu Mono)�6�   G� 5   
   -   5         G�Name$ Password��5      $��2��6(   ���	#FF4B5040$��65��6L   $	��340��6X   $	 0.5Q�6d   $ Password��6r   
�������$��30(�6�   $��Center=�6�   $��Ubuntu Mono)�6�   �� 5   
   	 �� Orientation$	 
Horizontal=�6   $��3��6.   $��Center=�6;   $��Center=�6V   $��-1,24,1,116q�6s   $	��450��6�   .+�5      �� -   5        $��Login��5      $��30(�6%   $��3��63   ���	#FF4B5040$��60��6W   $	��200��6c   
�������$��130, 0, 0, 0q�6�   �� 5      -   5        
 ��Name$
 Reset��5      $��66��6e   $��50��6p   ��6$   Z� ��6:   Z� .��5      '  !MaterialDesignThemes.Wpf.PackIcon     Kind$ Trash=�6*   ���	#FF4B5040$��40��6N   $��40��6Z   5      5      �� 5   
   $	 
Horizontal=�6   $��30��6.   $	��Top=�6:   $��Right=�6R   $��0��6n   .+�5      �� -   5        $
 Close��5      ��6$   Z� ��6:   Z� .��5        $ Close=�6*   
���   �67   5      5      �� 5   
   
������ $��3��6*   $��Bottom=�67   $��0,0,0,40q�6R   ��6d   Z� .��5      �� -   5        $.��(Don't have an accoint yet? Register now!��5      6j   5       5!      5"      