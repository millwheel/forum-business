import 'package:flutter/material.dart';
import 'package:forum_mobile/component/bottom_space.dart';
import 'package:forum_mobile/service/auth_service.dart';
import 'package:provider/provider.dart';

import 'component/common_elevated_button.dart';
import 'component/common_outlined_button.dart';
import 'component/head_space.dart';
import 'main.dart';

class JoinPage extends StatelessWidget {
  const JoinPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: SizedBox(
          width: double.infinity,
          child: Column(
            children: [
              TopSpace(),
              Center(
                child: Text(
                  "Join",
                  style: TextStyle(fontSize: 30, color: Colors.black),
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
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => EmailJoinPage()),
                  );
                },
              ),
              const Spacer(),
              CommonElevatedButton(
                text: "Go back",
                onPressed: () => Navigator.pop(context),
              ),
              BottomSpace(),
            ],
          ),
        ),
      ),
    );
  }
}

class EmailJoinPage extends StatefulWidget {
  const EmailJoinPage({super.key});

  @override
  State<EmailJoinPage> createState() => _EmailJoinPageState();
}

class _EmailJoinPageState extends State<EmailJoinPage> {
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  TextEditingController passwordConfirmController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Consumer<AuthService>(
      builder: (context, authService, child) {
        return Scaffold(
          backgroundColor: Colors.white,
          body: SafeArea(
            child: SizedBox(
              width: double.infinity,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  TopSpace(),
                  Text(
                    "Join with Email",
                    style: TextStyle(fontSize: 28),
                  ),
                  SizedBox(height: 45),
                  SizedBox(
                    width: 300,
                    height: 60,
                    child: TextField(
                      controller: emailController,
                      decoration: InputDecoration(hintText: "Email"),
                      style: TextStyle(color: Colors.black, fontSize: 22),
                    ),
                  ),
                  SizedBox(
                    width: 300,
                    height: 60,
                    child: TextField(
                      controller: passwordController,
                      obscureText: true,
                      decoration: InputDecoration(hintText: "Password"),
                      style: TextStyle(color: Colors.black, fontSize: 22),
                    ),
                  ),
                  SizedBox(
                    width: 300,
                    height: 60,
                    child: TextField(
                      controller: passwordConfirmController,
                      obscureText: true,
                      decoration: InputDecoration(hintText: "Password Confirm"),
                      style: TextStyle(color: Colors.black, fontSize: 22),
                    ),
                  ),
                  SizedBox(
                    height: 60,
                  ),
                  CommonElevatedButton(
                    text: "Join!",
                    onPressed: () {
                      authService.signUp(
                        email: emailController.text,
                        password: passwordController.text,
                        passwordConfirm: passwordConfirmController.text,
                        onSuccess: () {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                            content: Text("Sign up success"),
                          ));
                          Navigator.pushReplacement(
                            context,
                            MaterialPageRoute(builder: (context) => HomePage()),
                          );
                        },
                        onError: (err) {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                            content: Text(err),
                          ));
                        },
                      );
                    },
                    backgroundColor: Colors.blue,
                  ),
                  Spacer(),
                  CommonElevatedButton(
                    text: "Go back",
                    onPressed: () => Navigator.pop(context),
                  ),
                  BottomSpace()
                ],
              ),
            ),
          ),
        );
      },
    );
    ;
  }
}
