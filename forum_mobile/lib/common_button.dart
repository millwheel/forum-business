import 'package:flutter/material.dart';

class CommonLargeButton extends StatelessWidget {
  final String text;
  final Color fontColor;
  final Color backgroundColor;
  final VoidCallback onPressed;

  const CommonLargeButton({
    super.key,
    required this.text,
    required this.onPressed,
    this.fontColor = Colors.black,
    this.backgroundColor = Colors.grey,
  });

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: onPressed,
      style: ElevatedButton.styleFrom(
        backgroundColor: backgroundColor,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10),
        ),
      ),
      child: SizedBox(
        width: 300,
        height: 60,
        child: Center(
          child: Text(
            text,
            textAlign: TextAlign.center,
            style: TextStyle(
              color: fontColor,
              fontSize: 18,
            ),
          ),
        ),
      ),
    );
  }
}
