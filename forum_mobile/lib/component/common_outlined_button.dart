import 'package:flutter/material.dart';

class CommonOutlinedButton extends StatelessWidget {
  final String text;
  final Color fontColor;
  final Color backgroundColor;
  final VoidCallback onPressed;
  final Image? image;

  const CommonOutlinedButton({
    super.key,
    required this.text,
    required this.onPressed,
    this.fontColor = Colors.indigo,
    this.backgroundColor = Colors.white,
    this.image,
  });

  @override
  Widget build(BuildContext context) {
    return OutlinedButton(
      onPressed: onPressed,
      style: OutlinedButton.styleFrom(
        backgroundColor: backgroundColor,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(5),
        ),
        minimumSize: Size.zero,
        padding: EdgeInsets.all(0),
      ),
      child: SizedBox(
        width: 300,
        height: 60,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            if (image != null) ...[
              image!,
              SizedBox(
                width: 8,
              ),
            ],
            Text(
              text,
              style: TextStyle(
                color: fontColor,
                fontSize: 20,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
