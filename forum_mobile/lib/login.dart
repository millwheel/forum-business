import 'package:flutter/material.dart';
import 'package:forum_mobile/component/common_outlined_button.dart';

import 'component/common_elevated_button.dart';
import 'component/input_box.dart';
import 'component/head_space.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
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
              CommonOutlinedButton(
                text: "Google login",
                onPressed: () {},
              ),
              SizedBox(
                height: 20,
              ),
              CommonOutlinedButton(
                text: "Kakao login",
                onPressed: () {},
              ),
              SizedBox(
                height: 20,
              ),
              CommonOutlinedButton(
                text: "Email login",
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
