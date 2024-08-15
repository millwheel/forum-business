import 'package:flutter/material.dart';

import 'component/common_button.dart';
import 'component/input_box.dart';
import 'component/head_space.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

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
                  "Login",
                  style: TextStyle(fontSize: 30),
                ),
              ),
              SizedBox(
                height: 36,
              ),
              OutlinedButton(
                onPressed: () {},
                child: Text("Google login"),
              ),
              CommonInputBox(
                width: 300,
                text: "password",
              ),
              const Spacer(),
              Padding(
                padding: EdgeInsets.only(bottom: 60),
                child: CommonLargeButton(
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
