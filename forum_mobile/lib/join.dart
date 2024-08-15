import 'package:flutter/material.dart';

import 'component/common_elevated_button.dart';
import 'component/common_outlined_button.dart';
import 'component/input_box.dart';
import 'component/head_space.dart';

class JoinPage extends StatelessWidget {
  const JoinPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black87,
      body: SafeArea(
        child: SizedBox(
          width: double.infinity,
          child: Column(
            children: [
              HeadSpace(),
              Center(
                child: Text(
                  "Join",
                  style: TextStyle(fontSize: 30, color: Colors.yellow),
                ),
              ),
              SizedBox(
                height: 36,
              ),
              CommonOutlinedButton(
                text: "Join with Google",
                onPressed: () {},
              ),
              SizedBox(
                height: 20,
              ),
              CommonOutlinedButton(
                text: "Join with Kakao",
                onPressed: () {},
              ),
              SizedBox(
                height: 20,
              ),
              CommonOutlinedButton(
                text: "Join with Email",
                onPressed: () {},
              ),
              const Spacer(),
              Padding(
                padding: EdgeInsets.only(bottom: 60),
                child: CommonElevatedButton(
                  text: "Go back",
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
