import 'package:flutter/material.dart';

class HeadSpace extends StatelessWidget {
  const HeadSpace({super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: MediaQuery.of(context).size.height * 0.2,
    );
  }
}
