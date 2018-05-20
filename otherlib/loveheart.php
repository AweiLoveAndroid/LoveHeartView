<?php 
    $width = 600; 
    $height = 650;
    header("Content-type: image/gif"); 
    $img = imagecreate($width,$height);//创建一张图片 
    $width = 600;
    $height = 650;
    header("Content-type: image/gif");
    $img = imagecreate($width,$height);//创建一张图片
    $bg_color = imagecolorallocate($img,0,0,0);
    $red = imagecolorallocate($img,255,0,0);
    for($i=0;$i<=100;$i++){
        for($j=0;$j<=100;$j++){ 
            $r = M_PI/50*$i * (1-sin(M_PI/50*$j))*40;
            $x = $r *cos(M_PI/50*$j)*sin(M_PI/50*$i)+$width/2;
            $y = -$r*sin(M_PI/50*$j)+$height/6;
            imagesetpixel($img,$x,$y,$red);
        }
    }
    imagegif($img);
    imagedestroy($img);
?>