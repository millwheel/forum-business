import 'package:flutter/material.dart';

import 'component/common_elevated_button.dart';
import 'component/input_box.dart';
import 'component/head_space.dart';

class JoinPage extends StatelessWidget {
  const JoinPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: SizedBox(
          width: double.infinity,
          child: Column(
            children: [
              HeadSpace(),
              Center(
                child: Text(
                  "Join",
                  style: TextStyle(fontSize: 30),
                ),
              ),
              CommonInputBox(
                width: 300,
                text: "password",
              ),
              const Spacer(),
              Padding(
                padding: EdgeInsets.only(bottom: 60),
                child: CommonElevatedButton(
                  text: "뒤로가기",
                  onPressed: () => Navigator.pop(context),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
