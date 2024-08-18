import 'package:flutter/material.dart';

class TopSpace extends StatelessWidget {
  const TopSpace({super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: MediaQuery.of(context).size.height * 0.2,
    );
  }
}
