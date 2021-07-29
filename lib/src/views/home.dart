import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  static const platform =
      const MethodChannel('flutterplugins.javatpoint.com/browser');
  Future<void> _openBrowser() async {
    try {
      final int res = await platform.invokeMethod<int>('openBrowser');
    } on PlatformException catch (e) {
      print(e);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Expanded(
        child: SingleChildScrollView(
          child: Column(
            children: <Widget>[
              Container(
                height: 40.0,
                child: Text(
                  "Fingerprint Test App",
                  textAlign: TextAlign.center,
                ),
              ),
              const SizedBox(
                height: 40.0,
              ),
              Center(
                child: ElevatedButton(
                  child: Text("Invoke"),
                  onPressed: () => _openBrowser(),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
