import os

def add_extension_to_files(directory):
    for root, _, files in os.walk(directory):
        for file in files:
            file_path = os.path.join(root, file)
            if not file_path.endswith(('.java', '.kt')):
                with open(file_path, 'r', encoding='utf-8') as f:
                    content = f.read()
                    if ';' in content:
                        new_file_path = file_path + '.java'
                    else:
                        new_file_path = file_path + '.kt'
                    os.rename(file_path, new_file_path)
                    print(f'Renamed: {file_path} to {new_file_path}')

if __name__ == "__main__":
    directory = '/Users/chaelin/intelliJProject/AlgorithmStudy/김채린'
    add_extension_to_files(directory)
