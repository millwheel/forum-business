import 'package:flutter/material.dart';

class BottomSpace extends StatelessWidget {
  const BottomSpace({super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: MediaQuery.of(context).size.height * 0.1,
    );
  }
}
