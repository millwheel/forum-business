import 'package:flutter/material.dart';

class CommonInputBox extends StatelessWidget {
  final int width;
  final String text;

  const CommonInputBox({
    super.key,
    required this.width,
    required this.text,
  });

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 300,
      child: TextField(
        decoration: InputDecoration(
          border: OutlineInputBorder(),
          labelText: 'password',
        ),
      ),
    );
  }
}
